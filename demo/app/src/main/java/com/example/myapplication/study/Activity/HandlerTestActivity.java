package com.example.myapplication.study.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.myapplication.R;

import java.util.Timer;
import java.util.TimerTask;

public class HandlerTestActivity extends AppCompatActivity {
    //定义切换的图片的数组id
    int imgids[] = new int[]{
            R.drawable.handler_test_1, R.drawable.handler_test_2,R.drawable.handler_test_3
    };
    int imgstart = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handler_demo);
        final ImageView imgchange = (ImageView) findViewById(R.id.imgchange);
        final Handler myHandler = new Handler() {
            @Override
            //重写handleMessage方法,根据msg中what的值判断是否执行后续操作
            public void handleMessage(Message msg) {
                if(msg.what == 0x123)
                {
                    imgchange.setImageResource(imgids[imgstart++ % 3]);
                }
            }
        };
        //使用定时器,每隔200毫秒让handler发送一个空信息
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                myHandler.sendEmptyMessage(0x123);

            }
        }, 0,200);
    }

}
