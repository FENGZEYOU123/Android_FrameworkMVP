package com.yfz.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.yfz.mvp.presenter.LoginPresenter;
import com.yfz.mvp.view.LoginView;

/**
 * Author: 游丰泽
 * Time: 9999/01/01
 * Describe: 探究MVC架构设计
 * Github: https://blog.csdn.net/ruiruiddd/article/details/117990466
 */
public class LoginActivity extends AppCompatActivity implements LoginView,View.OnClickListener{

    private EditText etUserName;
    private EditText etPassword;
    private Button btnLogin;
    private ProgressBar progressBar;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        etUserName = (EditText)findViewById(R.id.et_user_name);
        etPassword = (EditText)findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        btnLogin.setOnClickListener(this);

        loginPresenter = new LoginPresenter(this);
    }

    @Override
    public void onClick(View view) {
        loginPresenter.doLogin();
    }

    @Override
    public String getUserName() {
        return etUserName.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString().trim();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showLoginSuccessMsg(LoginInfo loginInfo) {
        Toast.makeText(this,loginInfo.getName()+" login success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginFailMsg(String fail) {
        Toast.makeText(this,fail,Toast.LENGTH_SHORT).show();
    }

}