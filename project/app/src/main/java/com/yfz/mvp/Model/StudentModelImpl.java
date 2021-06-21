package com.yfz.mvp.Model;

import java.util.List;

/**
 * Model层接口，在此定义并列出所有 M层 可以进行的操作
 */
public interface StudentModelImpl {

    /**
     * 添加学生操作 - 回调
     */
    interface eventAddStudentCallBack{
        void completed(int listSize);
    }

    /**
     * 添加学生操作，(可以看作提供给 Presenter 调用的方法)
     * @param name
     * @param gender
     * @param studentCallBack
     */
    void addStudent(String name, String gender,eventAddStudentCallBack studentCallBack);

    /**
     * 获取学生list,(可以看作提供给 Presenter 调用的方法)
     */
    List getStudentList();
}
