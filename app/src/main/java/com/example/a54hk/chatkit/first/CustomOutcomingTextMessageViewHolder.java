package com.example.a54hk.chatkit.first;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.a54hk.chatkit.APP;
import com.example.a54hk.chatkit.R;

import com.stfalcon.chatkit.messages.MessageHolders;

public class CustomOutcomingTextMessageViewHolder
        extends MessageHolders.OutcomingTextMessageViewHolder<ChatMessageBean> {

    public CustomOutcomingTextMessageViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void onBind(ChatMessageBean message) {
        super.onBind(message);
        ImageView ivUserAvatar = itemView.findViewById(R.id.messageUserAvatar);
        Glide.with(APP.ACTIVITY).load(message.getUser().getAvatar()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(ivUserAvatar);
//        ImageLoadUtils.displayAsBitmap(itemView.getContext(),message.getUser().getAvatar(),ivUserAvatar,R.mipmap.profile_head_default);
    }
}
