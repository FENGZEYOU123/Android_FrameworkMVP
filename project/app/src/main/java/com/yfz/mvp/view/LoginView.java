package com.yfz.mvp.view;


import com.yfz.mvp.LoginInfo;

public interface LoginView {

    String getUserName();
    String getPassword();

    void showProgressBar();
    void hideProgressBar();

    void showLoginSuccessMsg(LoginInfo loginInfo);
    void showLoginFailMsg(String fail);
}