package com.chess.android.achess.core;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.chess.android.achess.GameActivity;
import com.chess.android.achess.R;

/**
 * Created by NKostya on 03.12.2016.
 */
public class Board extends Activity {

    private GridLayout board;

    private LayoutInflater inflater;

    private int[] colors = {
            Color.parseColor("#E1D3E6"),
            Color.parseColor("#504254")
    };


    public Board() {
        board = (GridLayout) findViewById(R.id.root);
        for (int i = 0; i < 64; i++) {
            View item = inflater.inflate(R.layout.board_cell, board, false);

            ImageButton imageButton = (ImageButton) item.findViewById(R.id.btn);

            imageButton.setId(i);
//            item.setBackgroundColor(colors[i % 2]);
            imageButton.setBackgroundColor((i % 2) != 0 ? colors[0] : colors[1]);
            board.addView(item);

        }
    }

}


    /*void refreshShedule() {
        linLayout.removeAllViews();
        for (int pair = 0; pair < 6; pair++) {
            View item = ltInflater.inflate(R.layout.pair, linLayout, false);

            TextView tvSubj = (TextView) item.findViewById(R.id.tvSubj);
            tvSubj.setText(pairs[day][pair].subject);
            TextView tvTchr = (TextView) item.findViewById(R.id.tvTchr);
            tvTchr.setText(pairs[day][pair].teacher);
            TextView tvAud = (TextView) item.findViewById(R.id.tvAud);
            tvAud.setText(pairs[day][pair].aud);
            TextView tvStart = (TextView) item.findViewById(R.id.tvStart);
            tvStart.setText(pairs[day][pair].startTime);
            TextView tvEnd = (TextView) item.findViewById(R.id.tvEnd);
            tvEnd.setText(pairs[day][pair].endTime);

            item.setId(pair);
            item.getLayoutParams().width = LayoutParams.MATCH_PARENT;
            item.setBackgroundColor(colors[pair % 2]);
            registerForContextMenu(item);
            linLayout.addView(item);
        }
    }*/