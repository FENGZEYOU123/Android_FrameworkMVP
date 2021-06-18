package com.yfz.mvp.presenter;

import android.os.Handler;

import com.yfz.mvp.LoginInfo;
import com.yfz.mvp.bean.User;
import com.yfz.mvp.presenterImpl.LoginModelImpl;
import com.yfz.mvp.view.LoginView;

public class LoginPresenter {

    private LoginView loginView;
    private LoginModelImpl loginModel;
    private User user;
    private Handler handler;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        loginModel = new LoginModelImpl();
        handler = new Handler();

    }

    public void doLogin(){
        user = new User(loginView.getUserName(),loginView.getPassword());
        loginView.showProgressBar();
        loginModel.doLogin(user, new LoginModelImpl.OnLoginListener() {
            @Override
            public void loginSuccess(final LoginInfo loginInfo) {
                //登录成功返回的数据进行处理
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.hideProgressBar();
                        loginView.showLoginSuccessMsg(loginInfo);
                    }
                });

            }

            @Override
            public void loginFail(final String fail) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.hideProgressBar();
                        loginView.showLoginFailMsg(fail);
                    }
                });
            }
        });
    }
}