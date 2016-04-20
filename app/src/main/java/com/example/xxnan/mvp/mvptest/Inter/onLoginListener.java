package com.example.xxnan.mvp.mvptest.Inter;

import com.example.xxnan.mvp.mvptest.bean.User;

/**
 * Created by Administrator on 2016/4/20.
 */
public interface onLoginListener {
    public void success(User user);
    public void failed();
}
