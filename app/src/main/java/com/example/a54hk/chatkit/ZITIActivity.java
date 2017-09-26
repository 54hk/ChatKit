package com.example.a54hk.chatkit;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;

public class ZITIActivity extends AppCompatActivity {

    TextView textc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ziti);

        textc = (TextView) findViewById(R.id.textc);
        Typeface typeface = Typeface.createFromAsset(getAssets() ,"美化自由之翼.ttf");
        textc.setTypeface(typeface);

    }
}
