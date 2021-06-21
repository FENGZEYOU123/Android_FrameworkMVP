package com.yfz.mvp.presenter;

/**
 * Presenter层接口，在此定义并列出所有 P层 可以进行的操作
 */
public interface StudentPresenterImpl {

    /**
     * 发送指令给M层，添加学生
     */
    void addStudent();

    /**
     * 发送指令给V层，刷新UI
     */
    void doRefreshListInfo();
}
