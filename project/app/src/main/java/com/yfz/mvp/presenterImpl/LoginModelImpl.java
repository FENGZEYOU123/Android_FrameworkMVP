package com.yfz.mvp.presenterImpl;

import com.yfz.mvp.LoginInfo;
import com.yfz.mvp.bean.User;

public class LoginModelImpl {

    public void doLogin(final User user, final OnLoginListener onLoginListener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(user.getUserName().equals("1")){
                    LoginInfo loginInfo= new LoginInfo();
                    loginInfo.setName("t001");
                    loginInfo.setUserid("t001");
                    loginInfo.setRole("tbrole3");
                    onLoginListener.loginSuccess(loginInfo);
                }else{
                    onLoginListener.loginFail("login fail");
                }
            }
        }).start();
    }

    public interface OnLoginListener{

        void loginSuccess(LoginInfo loginInfo);
        void loginFail(String fail);
    }
}