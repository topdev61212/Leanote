package com.akioss.leanote.ui.mvpview;

import java.util.List;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 15/12/12.
 * Package: com.akioss.leanote.ui.mvpview
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public interface NotesView<T> extends BaseView {

    void setUpAdapter(List<T> datas);

    void appendDataToAdapter(List<T> datas);

    void dragCompleate();

    void pullCompleate();

    void showFab();

    void hideFab();

}
