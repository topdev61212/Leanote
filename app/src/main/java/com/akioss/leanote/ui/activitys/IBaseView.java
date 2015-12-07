package com.akioss.leanote.ui.activitys;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 15/12/2.
 * Package: com.akioss.leanote.ui.activitys
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public interface IBaseView {

    /**
     * 获取contentView的layoutId
     */
    int bindLayout();

    /**
     * 初始化依赖注入
     */
//    void initInject();

    /**
     * 初始化activity所需参数
     */
    void initParams();

    /**
     * 初始化view控件
     */
    void initView();

    /**
     * 页面初始时的业务处理
     */
    void doBusiness();
}
