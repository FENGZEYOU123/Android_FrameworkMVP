package com.yfz.mvp.Model;

import com.yfz.mvp.bean.StudentBean;
import java.util.ArrayList;
import java.util.List;

/**
 * Model层，作为数据处理的层,通过实现StudentModelImpl里的方法，进行对应的数据操作
 */
public class StudentModel implements StudentModelImpl {
    private List <StudentBean> mStudentList = new ArrayList<>();
    /**
     * 向P层提供方法，对从Presenter拿到的 name 和 gender 作为数据进行处理，操作为创建一个新的学生bean并储存至学生list中
     * 处理完毕后，通过接口回调返回给P层状态
     * @param name
     * @param gender
     */
    @Override
    public void addStudent(String name, String gender, eventAddStudentCallBack studentCallBack) {
        StudentBean studentBean = new StudentBean(name,gender);
        mStudentList.add(studentBean);
        studentCallBack.completed(mStudentList.size()); //回调返回给P层
    }
    /**
     * 返回学生list
     */
    @Override
    public List getStudentList() {
        return mStudentList;
    }


}
