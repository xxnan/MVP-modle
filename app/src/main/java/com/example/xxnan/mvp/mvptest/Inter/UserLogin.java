package com.example.xxnan.mvp.mvptest.Inter;

import com.example.xxnan.mvp.mvptest.bean.User;

/**
 * Created by Administrator on 2016/4/20.
 */
public class UserLogin implements ILogin {
    @Override
    public void login(final String username, final String password, final onLoginListener loginListener) {
        //模拟子线程耗时操作
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("xxnan".equals(username) && "123".equals(password))
                {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginListener.success(user);
                } else
                {
                    loginListener.failed();
                }
            }
        }.start();
    }
}
