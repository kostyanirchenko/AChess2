package com.chess.android.achess;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by NKostya on 02.12.2016.
 */
public class GameActivity extends Activity {

    private boolean blitzMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);

        Intent intent = getIntent();
        blitzMode = intent.getBooleanExtra("BlitzMode", false);
    }
}
