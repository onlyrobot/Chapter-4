package com.bytedance.clockapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.bytedance.clockapplication.widget.Clock;

public class MainActivity extends AppCompatActivity {

    private View mRootView;
    private Clock mClockView;

    private static Handler handler = new Handler() {
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRootView = findViewById(R.id.root);
        mClockView = findViewById(R.id.clock);

        mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClockView.setShowAnalog(!mClockView.isShowAnalog());
            }
        });
        handler.post(new Runnable() {
            @Override
            public void run() {
                mClockView.invalidate();
                Log.d("hello", "run() called");
                handler.postDelayed(this, 1000);
            }
        });
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        //destroy the handler after activity destroyed
        handler.removeCallbacksAndMessages(null);
    }
}
