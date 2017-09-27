package com.example.a54hk.chatkit.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.a54hk.chatkit.APP;
import com.example.a54hk.chatkit.R;
import com.stfalcon.chatkit.commons.ImageLoader;
import com.stfalcon.chatkit.commons.models.IMessage;
import com.stfalcon.chatkit.messages.MessageHolders;
import com.stfalcon.chatkit.messages.MessagesList;
import com.stfalcon.chatkit.messages.MessagesListAdapter;
import com.stfalcon.chatkit.utils.DateFormatter;

import java.util.Date;

public class ChatkitActivity extends AppCompatActivity implements View.OnClickListener {

    MessagesList messagelist;
    Button sendBut;
    EditText sendMessage;
    protected ImageLoader imageLoader;
    protected final String senderId = "0";
    private MessagesListAdapter messagesAdapter;
    String imgPath = "https://www.baidu.com/link?url=twSfi09lRLdw8C_zzgfUmBQXrJubNw8mnnsh370tJ4KpVt6eoROguPrMYDn9U1n0&wd=&eqid=e8c514e4000059e50000000359cb0c0b";
    String myImgPath = "https://www.baidu.com/link?url=NTYzgYDp_vH9yuVx9oY9m3XRzr_9Q0gnU7Vq3pJV2PIJW1Ym1Xa7MsDJjfxQTi-pAR-1EvfMDgBA-w0OLuGO5z5hJSf9IiYmFqpaVekiqsu&wd=&eqid=e8c514e4000059e50000000359cb0c0b";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatkit);
        APP.ACTIVITY = this;
        initLayout();
        initMessageList();
    }


    private void initLayout() {
        messagelist = (MessagesList) findViewById(R.id.messagelist);
        sendBut  = (Button) findViewById(R.id.send_but);
        sendBut.setOnClickListener(this);
        sendMessage = (EditText) findViewById(R.id.send_message);
    }


    private void initMessageList() {
        imageLoader = new ImageLoader() {
            @Override
            public void loadImage(ImageView imageView, String url) {
                Glide.with(ChatkitActivity.this).load(url).placeholder(R.mipmap.manager_sound).error(R.mipmap.ic_launcher).into(imageView);
            }
        };
        MessageHolders holdersConfig = new MessageHolders()
//                输入文本布局
                .setIncomingTextLayout(R.layout.item_custom_incoming_text_message)
//                输出文本布局
                .setOutcomingTextConfig(CustomOutcomingTextMessageViewHolder.class,R.layout.item_custom_outcoming_text_message)
//                输入图片布局
                .setIncomingImageLayout(R.layout.item_custom_incoming_image_message)
//                输出图片布局
                .setOutcomingImageLayout(R.layout.item_custom_outcoming_image_message);

        messagesAdapter = new MessagesListAdapter<>(senderId, holdersConfig, imageLoader);
        messagesAdapter.setDateHeadersFormatter(new DateFormatter.Formatter() {
            @Override
            public String format(Date date) {
                return "";
            }
        });
        messagelist.setAdapter(messagesAdapter);
        messagesAdapter.registerViewClickListener(R.id.messageUserAvatar, new MessagesListAdapter.OnMessageViewClickListener() {
            @Override
            public void onMessageViewClick(View view, IMessage message) {
                Toast.makeText(ChatkitActivity.this, message.getUser().getName(), Toast.LENGTH_SHORT).show();
            }
        });

        messagesAdapter.addToStart(new ChatMessageBean(new ChatUserBean("1", "小寓", imgPath), "你好，我是小寓！"), true);

        String headInfo = "您可以直接向我提问，例如：\n·在线预约\n·联系管家";
        messagesAdapter.addToStart(new ChatMessageBean(new ChatUserBean("1", "小寓", imgPath), headInfo), true);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.send_but:
                messagesAdapter.addToStart(new ChatMessageBean(new ChatUserBean("0", "小寓AAAAAAAPPPPP", myImgPath), sendMessage.getText().toString().trim()), true);
                sendMessage.setText("");
                break;
        }
    }
}
