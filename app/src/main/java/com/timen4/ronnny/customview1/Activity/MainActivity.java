package com.timen4.ronnny.customview1.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.timen4.ronnny.customview1.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button scoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        registEvents();
    }

    private void registEvents() {
        scoreView.setOnClickListener(this);
    }

    private void initView() {
        scoreView = (Button) findViewById(R.id.scoreView);
        
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.scoreView:
                Intent intent = new Intent(this,ScoreActivity.class);
                startActivity(intent);
                break;
        }
    }
}
