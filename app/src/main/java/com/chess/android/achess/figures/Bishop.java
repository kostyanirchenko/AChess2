package com.chess.android.achess.figures;

import com.chess.android.achess.core.Figures;

/**
 * Created by NKostya on 03.12.2016.
 */
public class Bishop extends Figures {
    @Override
    protected void move(int position) {
        setPosition(position);
    }

    @Override
    protected void setPosition(int position) {
        this.position = position;
    }

    @Override
    protected int getPosition() {
        return position;
    }

    @Override
    protected void remove() {

    }

    @Override
    protected boolean checkCell(int position) {
        return false;
    }

    @Override
    protected void setPlayer(int player) {
        this.player = player;
    }

    @Override
    protected int getPlayer() {
        return player;
    }
}
