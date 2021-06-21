package com.yfz.mvp.Model;

import com.yfz.mvp.bean.StudentBean;
import java.util.ArrayList;
import java.util.List;

/**
 * Model层，进行数据处理
 */
public class StudentModel {
    private List <StudentBean> mStudentList = new ArrayList<>();
    //回调接口
    private StudentModelListener mStudentModelListener;

    public void addModelListener(StudentModelListener studentModelListener){
        mStudentModelListener = studentModelListener;
    }
    /**
     * 向P层提供方法，对从Presenter拿到的 name 和 gender 作为数据进行处理，操作为创建一个新的学生bean并储存至学生list中
     * 处理完毕后，通过接口回调返回给P层状态
     * @param name
     * @param gender
     */
    public void addStudent(String name, String gender) {
        StudentBean studentBean = new StudentBean(name,gender);
        mStudentList.add(studentBean);
        mStudentModelListener.addStudentHasCompleted(mStudentList.size());
    }
    /**
     * 返回学生list
     */
    public List getStudentList() {
        return mStudentList;
    }

}
