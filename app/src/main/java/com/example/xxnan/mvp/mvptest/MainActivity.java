package com.example.xxnan.mvp.mvptest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.xxnan.mvp.mvptest.bean.User;
import com.example.xxnan.mvp.mvptest.persener.LoginPersener;
import com.example.xxnan.mvp.mvptest.view.PersenerView;

public class MainActivity extends AppCompatActivity implements PersenerView,View.OnClickListener{
    @Override
    public String getUserName() {
        return  username_ET.getText().toString();
    }

    @Override
    public String getPassword() {
        return  password_ET.getText().toString();
    }

    @Override
    public void clearUserName() {
        username_ET.setText("");
    }

    @Override
    public void clearPassword() {
        password_ET.setText("");
    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, user.getUsername() +
                " login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }
    private Button login,clear;
    private EditText username_ET,password_ET;
    private LoginPersener mLoginPersener;
    private ProgressBar mPbLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoginPersener=new LoginPersener(this);
        setContentView(R.layout.content_main);
        username_ET=(EditText)findViewById(R.id.user);
        password_ET=(EditText)findViewById(R.id.psw);
        login=(Button)findViewById(R.id.login);
        login.setOnClickListener(this);
        clear=(Button)findViewById(R.id.clear);
        clear.setOnClickListener(this);
        mPbLoading=(ProgressBar)findViewById(R.id.progress);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.login:
                mLoginPersener.login();
                break;
            case R.id.clear:
                clearPassword();
                clearUserName();
                break;
        }
    }
}
