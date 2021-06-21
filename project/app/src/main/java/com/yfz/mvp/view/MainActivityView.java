package com.yfz.mvp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.yfz.mvp.R;
import com.yfz.mvp.presenter.StudentPresenter;

/**
 * Author: 游丰泽
 * Time: 9999/01/01
 * Describe: 探究MVP架构设计
 * Email: youfengze1995@163.com
 * Github: https://blog.csdn.net/ruiruiddd/article/details/117990466
 */
public class MainActivityView extends AppCompatActivity implements MainActivityViewImpl {

    private EditText vEdtName, vEdtGender;
    private Button vBtnAdd,vBtnGetStudentInfo;
    private TextView vTvDisplay,vTvDisplayListNumber;
    //实例化StudentPresenter控制器
    private StudentPresenter mStudentPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        addClickListener();
    }

    private void initView() {
        mStudentPresenter = new StudentPresenter(this);
        vEdtName = findViewById(R.id.vEdtName);
        vEdtGender = findViewById(R.id.vEdtGender);
        vTvDisplay = findViewById(R.id.vTvDisplayStudentInfo);
        vBtnAdd = findViewById(R.id.vBtnAdd);
        vTvDisplayListNumber = findViewById(R.id.vTvDisplayListNumber);
        vBtnGetStudentInfo = findViewById(R.id.vBtnGetStudentInfo);
    }

    private void addClickListener(){
        vBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStudentPresenter.addStudent(); //响应用户点击按钮操作，通知Presenter做处理

            }
        });
        vBtnGetStudentInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStudentPresenter.doRefreshListInfo();
            }
        });
    }

    @Override
    public String getStudentName() {
        return vEdtName.getText().toString().trim();
    }

    @Override
    public String getStudentGender() {
        return vEdtGender.getText().toString().trim();
    }

    @Override
    public void updateView_allStudentInfo(String string) {
        vTvDisplay.setText(string);
    }

    @Override
    public void updateView_studentNumber(String string) {
        vTvDisplayListNumber.setText(string);
    }

    //假如产品改需求，通过Toast弹窗的显示当前学生人数，
    //那么我们只需要在V层实现的自身接口改就行了。
//    @Override
//    public void updateView_studentNumber(String string) {
//        Toast.makeText(this,string,Toast.LENGTH_SHORT).show();
//    }

}