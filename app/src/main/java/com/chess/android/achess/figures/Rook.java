package com.chess.android.achess.figures;

import com.chess.android.achess.core.Figures;

/**
 * Created by NKostya on 03.12.2016.
 */
public class Rook extends Figures {

    private boolean firstMove = true;

//    private String tag = "";

    public Rook(int position, int player, String tag) {
        this.position = position;
        this.player = player;
        this.tag = tag;
    }

    @Override
    public void move(int position) {
        setPosition(position);
    }

    @Override
    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void remove() {
        this.removed = true;
    }

    @Override
    public boolean checkCell(int position) {
        return false;
    }

    @Override
    public void setPlayer(int player) {
        this.player = player;
    }

    @Override
    public int getPlayer() {
        return player;
    }

    public boolean isFirstMove() {
        return firstMove;
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

    @Override
    public String getTag() {
        return tag;
    }

    @Override
    public void setTag(String tag) {
        this.tag = tag;
    }
}
