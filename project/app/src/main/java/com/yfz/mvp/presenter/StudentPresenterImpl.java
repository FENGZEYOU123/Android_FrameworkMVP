package com.yfz.mvp.presenter;

/**
 * 作为Presenter控制器的逻辑的实现,分担Model的部分逻辑，例如Http请求可以写在这里。
 */
public class StudentPresenterImpl {

    public void doHttpRequest(OnHttpProcessListener onHttpProcessListener){
        /**
         * 这里不做http里的实现，可自己行写。
         * 等http的事件调完后，通过接口onHttpProcessListener返回给StudentPresenter做处理就可以了
         */
        onHttpProcessListener.succeed();
        onHttpProcessListener.failed();
    }

    /**
     * 接口返回http处理结果
     */
    public interface OnHttpProcessListener{
        void succeed();
        void failed();
    }
}
