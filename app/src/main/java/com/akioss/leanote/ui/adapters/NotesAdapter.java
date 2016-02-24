package com.akioss.leanote.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akioss.leanote.R;
import com.akioss.leanote.model.entity.NoteItemEntity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 15/12/10.
 * Package: com.akioss.leanote.ui.adapters
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public class NotesAdapter extends BaseRecyclerAdapter<NoteItemEntity, NotesAdapter.NotesViewHolder> {

    public NotesAdapter(List<NoteItemEntity> mDatas, Context mContext) {
        super(mDatas, mContext);
    }

    @Override
    public NotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contentView = LayoutInflater.from(mContext)
                .inflate(R.layout.recycler_item_note, parent, false);
        NotesViewHolder vh = new NotesViewHolder(contentView);
        return vh;
    }

    @Override
    protected void bindItemData(NotesViewHolder viewHolder, NoteItemEntity data, int position) {
        viewHolder.titleTxt.setText(data.getTitle());
        viewHolder.timeTxt.setText(data.getCreatedTime());
        viewHolder.tagTxt.setText(data.getTags() != null && data.getTags().size() > 0 ?
                data.getTags().get(0) : "other");
    }

    static class NotesViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.title_txt)
        TextView titleTxt;
        @Bind(R.id.time_txt)
        TextView timeTxt;
        @Bind(R.id.tag_txt)
        TextView tagTxt;

        NotesViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }
}
