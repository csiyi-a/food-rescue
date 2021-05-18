package com.example.foodrescue;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.greendao.db.bean.User;
import com.greendao.db.helper.UserHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AccountActivity extends AppCompatActivity {


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        ButterKnife.bind(this);

        User user = UserHelper.find();
        if (user!=null){
            editFullName.setText(user.getName());
            editEmail.setText(user.getEmail());
            editPhone.setText(user.getPhone());
            editAddress.setText(user.getAddress());
            editPassword.setText(user.getPassword());
        }

    }
}