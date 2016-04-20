package com.example.xxnan.mvp.mvptest.persener;

import android.os.Handler;

import com.example.xxnan.mvp.mvptest.Inter.UserLogin;
import com.example.xxnan.mvp.mvptest.Inter.onLoginListener;
import com.example.xxnan.mvp.mvptest.bean.User;
import com.example.xxnan.mvp.mvptest.view.PersenerView;

/**
 * Created by Administrator on 2016/4/20.
 */
public class LoginPersener {
    private PersenerView persenerView;
    private UserLogin userLogin;
    private Handler mHandler;
    public LoginPersener(PersenerView persenerView) {
        this.persenerView=persenerView;
        userLogin=new UserLogin();
        mHandler=new Handler();
    }
    public void login()
    {
        persenerView.showLoading();
        userLogin.login(persenerView.getUserName(), persenerView.getPassword(), new onLoginListener() {
            @Override
            public void success(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        persenerView.toMainActivity(user);
                        persenerView.hideLoading();
                    }
                });
            }

            @Override
            public void failed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                    persenerView.showFailedError();
                    }
                });
            }
        });
    }
}
