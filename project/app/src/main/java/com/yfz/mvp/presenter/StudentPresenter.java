package com.yfz.mvp.presenter;

import com.yfz.mvp.Model.StudentModel;
import com.yfz.mvp.Model.StudentModelListener;
import com.yfz.mvp.bean.StudentBean;
import com.yfz.mvp.view.MainActivityView;

import java.util.List;

/**
 * Presenter控制器负责逻辑分发，在View层（Activity与xml）收到的用户的操作指令后，将起转发给Model层处理
 * Model层处理完毕后，返回结果到这里进行处理后，再告知View层进行UI更新。
 */
public class StudentPresenter implements StudentModelListener {
    //传入Activity对象,同时因为我们在M层已经实现了MainActivityViewListener的接口，所以在P层相当于也监听了lister
    private MainActivityView mainActivityView;
    //实例化创建一个Model对象,并监听M层的回调结果
    private StudentModel mStudentModel;
    public StudentPresenter(MainActivityView activity){
        mainActivityView = activity;
        mStudentModel = new StudentModel();
        mStudentModel.addModelListener(this); //添加回调
    }
    //M层的回调结果,添加学生完毕后，理解更新V层视图
    @Override
    public void addStudentHasCompleted(int listSize) {
        mainActivityView.updateView_studentNumber(listSize);
    }

    /**
     * 调Model层方法，进行数据处理
     */
    public void doAddUser(){
        String name = mainActivityView.getStudentName(); //从V层的接口获取输入的学生名字
        String gender = mainActivityView.getStudentGender(); //从V层的接口获取输入的学生性别
        mStudentModel.addStudent(name,gender); //将数据 和 操作指令转发给M层做处理,M层处理结束后通过接口返回结果
    }
    /**
     * 提供V层（Activity）手动更新学生list中的信息
     * 从M层拿学生的list
     */
    public void doRefreshListInfo(){
        List<StudentBean> list  = mStudentModel.getStudentList();
        mainActivityView.updateView_allStudentInfo(list);
    }


}
