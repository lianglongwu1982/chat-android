package com.hyphenate.easeui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hyphenate.easeui.R;
import com.hyphenate.easeui.widget.chatextend.EaseChatExtendMenu.ChatMenuItemModel;

public class EaseChatExtendMenuAdapter extends EaseBaseChatExtendMenuAdapter<EaseChatExtendMenuAdapter.ViewHolder, ChatMenuItemModel> {
    @Override
    protected int getItemLayoutId() {
        return R.layout.ease_chat_menu_item;
    }

    @Override
    protected EaseChatExtendMenuAdapter.ViewHolder easeCreateViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EaseChatExtendMenuAdapter.ViewHolder holder, int position) {
        ChatMenuItemModel item = mData.get(position);
        holder.imageView.setBackgroundResource(item.image);
        holder.textView.setText(item.name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(item.clickListener != null){
                    item.clickListener.onChatExtendMenuItemClick(item.id, v);
                }
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            textView = (TextView) itemView.findViewById(R.id.text);
        }
    }
}

