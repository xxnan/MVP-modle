package com.example.xxnan.mvp.mvptest.view;

import com.example.xxnan.mvp.mvptest.bean.User;

/**
 * Created by Administrator on 2016/4/20.
 */
public interface PersenerView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
