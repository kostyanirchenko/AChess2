package com.chess.android.achess.core;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageButton;

import com.chess.android.achess.R;

/**
 * Created by NKostya on 03.12.2016.
 */
public class Board extends Activity {

    private GridLayout gridLayout;

    private LayoutInflater inflater;

    private int[] colors = {
            Color.parseColor("#E1D3E6"),
            Color.parseColor("#504254")
    };


    public Board(Activity context) {
        gridLayout = (GridLayout) context.findViewById(R.id.root);
        inflater = context.getLayoutInflater();
        int id = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                View item = inflater.inflate(R.layout.board_cell, gridLayout, false);
                ImageButton imageButton = (ImageButton) item.findViewById(R.id.btn);
                imageButton.setId(id);
                imageButton.setBackgroundColor(((i + j) % 2) == 0 ? colors[0] : colors[1]);
                System.out.println(id);
                gridLayout.addView(item);
                id++;
            }
        }
        placeFigures();
    }

    public GridLayout getGridLayout() {
        return gridLayout;
    }

    private void placeFigures() {
        for (int i = 8; i < 16; i++) {
//            gridLayout.findViewById(i);
            FrameLayout fl = (FrameLayout) gridLayout.getChildAt(i);
            ImageButton imgBut = (ImageButton) fl.getChildAt(0);
            imgBut.setImageResource(R.drawable.king);
        }
    }

}

/*
    public void OnClickDel(View v) {
        //Вызов getParent() возвращает FrameLayout в который вложена кнопка Del
        FrameLayout fl=(FrameLayout) v.getParent();
        //Определяем родительскую группу LinearLayout в которую мы добавляли item
        LinearLayout ll=(LinearLayout) fl.getParent();
        //Теперь у нас есть все данные, чтобы определить номер позиции в которой
        //находится item в родительской группе
        int index=ll.indexOfChild(fl);
        //Зная индекс item в группе LinearLayout, можно удалить  элемент
        ll.removeViewAt(index);
    }*/
