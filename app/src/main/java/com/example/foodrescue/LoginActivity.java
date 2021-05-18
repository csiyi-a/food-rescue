package com.example.foodrescue;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.greendao.db.bean.User;
import com.greendao.db.helper.UserHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.edit_name)
    EditText editName;
    @BindView(R.id.edit_pwd)
    EditText editPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        findViewById(R.id.loginBtn).setOnClickListener(v -> {
            User user = UserHelper.find();

            if (user == null) {
                Toast.makeText(LoginActivity.this, "Please register", Toast.LENGTH_SHORT).show();
            } else if (!user.getPhone().equals(StringUtils.getVal(editName)) || !user.getPassword().equals(StringUtils.getVal(editPwd))) {
                Toast.makeText(LoginActivity.this, "The user name or password is incorrect", Toast.LENGTH_SHORT).show();
            }else{

                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }
        });

        findViewById(R.id.signBtn).setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, RegActivity.class));
        });

    }
}