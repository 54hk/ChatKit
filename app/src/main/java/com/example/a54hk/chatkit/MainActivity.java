package com.example.a54hk.chatkit;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private ImageView ivSound;
    private RelativeLayout rlTalkLayout;
    private RippleLayoutView rippleLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initID();

    }

    private void initID() {
        ivSound = (ImageView) findViewById(R.id.iv_sound);
        ivSound.setOnTouchListener(this);
        rlTalkLayout = (RelativeLayout) findViewById(R.id.rl_talk_layout);
        rippleLayout = (RippleLayoutView) findViewById(R.id.ripple_layout);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        int action = motionEvent.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:

                ivSound.setEnabled(true);
                rlTalkLayout.setVisibility(View.VISIBLE);
                rippleLayout.startRippleAnimation();
                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:
                ivSound.setEnabled(false);
                rlTalkLayout.setVisibility(View.GONE);
                break;
        }
                return true;

        }


}
