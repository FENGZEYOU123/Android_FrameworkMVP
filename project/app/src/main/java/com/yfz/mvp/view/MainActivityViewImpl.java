package com.yfz.mvp.view;

/**
 * View层接口，在此定义并列出所有 V层 可以进行的操作
 */
public interface MainActivityViewImpl {
    /**
     * 获取学生姓名 (可以看作提供给 Presenter 调用的方法)
     */
    String getStudentName();
    /**
     * 获取学生性别 (可以看作提供给 Presenter 调用的方法)
     */
    String getStudentGender();
    /**
     * 手动更新View的UI-所有list学生信息
     */
    void updateView_allStudentInfo(String string);
    /**
     * 自动更新View的UI-学生List数量
     */
    void updateView_studentNumber(String string);
}
