package com.example.a54hk.chatkit.first;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;


import com.stfalcon.chatkit.messages.MessageHolders;

public class CustomIncomingTextMessageViewHolder
        extends MessageHolders.IncomingTextMessageViewHolder<ChatMessageBean> {

    public CustomIncomingTextMessageViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void onBind(ChatMessageBean message) {
        super.onBind(message);
        if ("2421".equals(message.getUser().getId())) {
            String headerInfo = text.getText().toString();
            if (headerInfo.indexOf("\n") > 0) {
                text.setLineSpacing(0, (float) 1.5);
                SpannableString spanInfo = new SpannableString(headerInfo);
                spanInfo.setSpan(new ForegroundColorSpan(Color.MAGENTA), headerInfo.indexOf("\n"), headerInfo.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                text.setText(spanInfo);
            }
        }
    }
}
