package com.example.foodrescue;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.greendao.db.bean.User;
import com.greendao.db.helper.UserHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegActivity extends AppCompatActivity {


    @BindView(R.id.edit_full_name)
    EditText editFullName;

    @BindView(R.id.edit_email)
    EditText editEmail;

    @BindView(R.id.edit_phone)
    EditText editPhone;

    @BindView(R.id.edit_address)
    EditText editAddress;

    @BindView(R.id.edit_password)
    EditText editPassword;

    @BindView(R.id.edit_pwd_confirm)
    EditText editPwdConfirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        ButterKnife.bind(this);

        findViewById(R.id.submitBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!StringUtils.isNotNull(editFullName)) {
                    Toast.makeText(RegActivity.this, "Please input Full name", Toast.LENGTH_SHORT).show();
                } else if (!StringUtils.isNotNull(editEmail)) {
                    Toast.makeText(RegActivity.this, "Please input Email", Toast.LENGTH_SHORT).show();
                } else if (!StringUtils.isNotNull(editPhone)) {
                    Toast.makeText(RegActivity.this, "Please input Phone", Toast.LENGTH_SHORT).show();
                } else if (!StringUtils.isNotNull(editAddress)) {
                    Toast.makeText(RegActivity.this, "Please input Address", Toast.LENGTH_SHORT).show();
                } else if (!StringUtils.isNotNull(editPassword)) {
                    Toast.makeText(RegActivity.this, "Please input Password", Toast.LENGTH_SHORT).show();
                } else if (!StringUtils.isNotNull(editPwdConfirm)) {
                    Toast.makeText(RegActivity.this, "Please input Confirm password", Toast.LENGTH_SHORT).show();
                } else if (!StringUtils.getVal(editPassword).equals(StringUtils.getVal(editPwdConfirm))) {
                    Toast.makeText(RegActivity.this, "The two passwords are not the same", Toast.LENGTH_SHORT).show();
                } else {


                    User user = UserHelper.find();

                    if (user==null){
                        user  = new User();
                    }else{
                        UserHelper.delete(user);
                    }

                    user.setName(StringUtils.getVal(editFullName));
                    user.setEmail(StringUtils.getVal(editEmail));
                    user.setPhone(StringUtils.getVal(editPhone));
                    user.setAddress(StringUtils.getVal(editAddress));
                    user.setPassword(StringUtils.getVal(editPassword));

                    UserHelper.save(user);

                    finish();
                }

            }
        });
    }
}