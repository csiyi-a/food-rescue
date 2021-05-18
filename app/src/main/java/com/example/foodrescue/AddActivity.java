package com.example.foodrescue;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.greendao.db.bean.Food;
import com.greendao.db.helper.FoodHelper;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnResultCallbackListener;

import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddActivity extends AppCompatActivity {

    @BindView(R.id.addBtn)
    ImageView addBtn;
    @BindView(R.id.edit_title)
    EditText editTitle;
    @BindView(R.id.edit_description)
    EditText editDescription;
    @BindView(R.id.edit_date)
    EditText editDate;
    @BindView(R.id.edit_quantity)
    EditText editQuantity;
    @BindView(R.id.edit_location)
    EditText editLocation;

    private String imagePath;
    String hourformat;
    String minuteformat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);


    }


    @OnClick({R.id.addBtn, R.id.btn_save, R.id.edit_date})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addBtn:
                select();
                break;
            case R.id.btn_save:
                save();
                break;
            case R.id.edit_date:
                selectDate();
                break;
        }
    }

    private void selectDate() {

        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog dialog = new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {

            int mhour = calendar.get(Calendar.HOUR_OF_DAY);
            int mminute = calendar.get(Calendar.MINUTE);

            new TimePickerDialog(AddActivity.this, (view1, hourOfDay, minute) -> {

                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                calendar.set(Calendar.MINUTE, minute);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);


                hourformat = format(hourOfDay);
                minuteformat = format(minute);


                String time = year + "-"
                        + StringUtils.getLocalMonth(month) + "-"
                        + StringUtils.getMultiNumber(dayOfMonth)
                        + " " + hourformat + ":" + minuteformat;

                editDate.setText(time);

            }, mhour, mminute, true).show();



        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        dialog.getDatePicker().setMinDate(calendar.getTimeInMillis());
        dialog.show();
    }


    private String format(int x) {
        String s = "" + x;
        if (s.length() == 1) {
            s = "0" + s;
        }
        return s;
    }

    private void save() {

        if (imagePath == null) {
            Toast.makeText(this, "Please add Image", Toast.LENGTH_SHORT).show();
        } else if (!StringUtils.isNotNull(editTitle)) {
            Toast.makeText(this, "Please input Title", Toast.LENGTH_SHORT).show();
        } else if (!StringUtils.isNotNull(editDescription)) {
            Toast.makeText(this, "Please input Description", Toast.LENGTH_SHORT).show();
        } else if (!StringUtils.isNotNull(editDate)) {
            Toast.makeText(this, "Please select Date", Toast.LENGTH_SHORT).show();
        } else if (!StringUtils.isNotNull(editQuantity)) {
            Toast.makeText(this, "Please input Quantity", Toast.LENGTH_SHORT).show();
        } else if (!StringUtils.isNotNull(editLocation)) {
            Toast.makeText(this, "Please input Location", Toast.LENGTH_SHORT).show();
        } else {

            Food food = new Food();

            food.setImgUrl(imagePath);
            food.setTitle(StringUtils.getVal(editTitle));
            food.setDesc(StringUtils.getVal(editDescription));
            food.setCreateDate(StringUtils.getVal(editDate));
            food.setQuantity(StringUtils.getVal(editQuantity));
            food.setLocation(StringUtils.getVal(editLocation));

            FoodHelper.save(food);

            Toast.makeText(this, "save success", Toast.LENGTH_SHORT).show();
            finish();
        }


    }

    private void select() {

        PictureSelector.create(AddActivity.this)
                .openGallery(PictureMimeType.ofImage())
                .loadImageEngine(GlideEngine.createGlideEngine())
                .selectionMode(PictureConfig.SINGLE)
                .isZoomAnim(true)
                .isEnableCrop(true)
                .circleDimmedLayer(true)
                .showCropGrid(true)
                .rotateEnabled(true)
                .scaleEnabled(true)
                .freeStyleCropEnabled(true)
                .isCompress(true)
                .forResult(new OnResultCallbackListener<LocalMedia>() {
                    @Override
                    public void onResult(List<LocalMedia> result) {
                        String path;
                        LocalMedia localMedia = result.get(0);

                        if (localMedia.isCompressed()) {
                            path = localMedia.getCompressPath();
                        } else if (localMedia.isCut()) {
                            path = localMedia.getCutPath();
                        } else {
                            path = localMedia.getPath();
                        }

                        imagePath = path;

                        GlideEngine.createGlideEngine().loadImage(AddActivity.this, path, addBtn);

                    }

                    @Override
                    public void onCancel() {
//                                photoCallback.onCancel();
                    }
                });
    }
}