package com.timen4.ronnny.customview1.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.timen4.ronnny.customview1.R;
import com.timen4.ronnny.customview1.view.ScoreView;

/**
 * Created by Ronny on 2016/7/5.
 */
public class ScoreActivity extends Activity {

    private LinearLayout scoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        scoreView = (LinearLayout) findViewById(R.id.score_View);
        scoreView.addView(new ScoreView(this,80));
    }
}
