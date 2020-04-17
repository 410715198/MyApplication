package com.example.myapplication;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView txv;
    long count = 0;

    Handler handler;
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            count++;
            txv.setText(String.valueOf(count));
            handler.postDelayed(runnable, 1000);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        txv = (TextView) findViewById(R.id.txv);
        handler = new Handler();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn.getText() == "結束計數"){
                    btn.setText("開始計數");
                    handler.removeCallbacks(runnable);  //銷毀執行緒
                }
                else{
                    btn.setText("結束計數");
                    handler.postDelayed(runnable, 1000);
                }
            }
        });

    }
        }


