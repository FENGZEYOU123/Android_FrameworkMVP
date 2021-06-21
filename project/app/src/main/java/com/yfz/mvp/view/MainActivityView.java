package com.yfz.mvp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.yfz.mvp.R;
import com.yfz.mvp.bean.StudentBean;
import com.yfz.mvp.presenter.StudentPresenter;
import java.util.List;

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
    public void updateView_allStudentInfo(List<StudentBean> list) {
        String title = "\n list中所有学生信息：\n";
        String text = "";
        for(int i=0; i<list.size(); i++){
            String studentInfo = "\n"+"姓名："+list.get(i).getName() +" 性别: "+ list.get(i).getGender()+"\n";
            text = text + studentInfo;
        }
        text = text +title;
        vTvDisplay.setText(text);
    }

    @Override
    public void updateView_studentNumber(int listSize) {
        vTvDisplayListNumber.setText("学生人数： "+listSize);
    }


}