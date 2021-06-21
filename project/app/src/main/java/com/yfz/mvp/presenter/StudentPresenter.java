package com.yfz.mvp.presenter;

import com.yfz.mvp.Model.StudentModel;
import com.yfz.mvp.Model.StudentModelImpl;
import com.yfz.mvp.bean.StudentBean;
import com.yfz.mvp.view.MainActivityView;
import java.util.List;

/**
 * Presenter控制器负责逻辑分发，在View层（Activity与xml）收到的用户的操作指令后，将起转发给Model层处理
 * Model层处理完毕后，返回结果到这里进行处理后，再告知View层进行UI更新。
 */
public class StudentPresenter{
    //Activity对象,同时V层实现了自身的接口
    private MainActivityView mainActivityView;
    //Model对象,同时M对象实现了自身的接口
    private StudentModel mStudentModel;
    public StudentPresenter(MainActivityView activity){
        mainActivityView = activity;
        mStudentModel = new StudentModel();
    }

    /**
     * 调用M层的接口对象，添加学生信息，并从回调结果更新V层的UI
     */
    public void addStudent(){
        String name = mainActivityView.getStudentName(); //从V层的接口方法获取输入的学生名字
        String gender = mainActivityView.getStudentGender(); //从V层的接口方法获取输入的学生性别
        //将数据 和 操作指令转发给M层做处理,M层处理结束后通过接口返回结果
        mStudentModel.addStudent(name, gender, new StudentModelImpl.eventAddStudentCallBack() {
            @Override
            public void completed(int listSize) {
                mainActivityView.updateView_studentNumber("当前人数: "+listSize);
            }
        });
    }

    /**
     * 调用V层的接口对象，更新V层的UI
     */
    public void doRefreshListInfo(){
        List<StudentBean> list  = mStudentModel.getStudentList();
        String text = "";
        for(int i=0; i<list.size(); i++){
            String studentInfo = "\n"+"姓名："+list.get(i).getName() +" 性别: "+ list.get(i).getGender()+"\n";
            text = text + studentInfo;
        }
        mainActivityView.updateView_allStudentInfo(text);
    }

}
