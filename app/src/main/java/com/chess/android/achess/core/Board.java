package com.chess.android.achess.core;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.chess.android.achess.R;
import com.chess.android.achess.figures.Bishop;
import com.chess.android.achess.figures.King;
import com.chess.android.achess.figures.Knight;
import com.chess.android.achess.figures.Pawn;
import com.chess.android.achess.figures.Queen;
import com.chess.android.achess.figures.Rook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Created by NKostya on 03.12.2016.
 */
public class Board {

    private int[][] allBoard = new int[8][8];

    private ImageButton tmp;

    private GridLayout gridLayout;

    private Context context;

    private LayoutInflater inflater;

    private int[] colors = {
            Color.parseColor("#E1D3E6"),
            Color.parseColor("#504254")
    };

    /**
     * WHITE = 1
     * BLACK = 2
     */
    enum Players {

        WHITE, BLACK;

    }


    public Board(Activity context) {
        this.context = context;
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

    private final static int WHITE_PAWNS = 1;
    private final static int WHITE_ROOK = 3;
    private final static int WHITE_KNIGHT = 5;
    private final static int WHITE_BISHOP = 7;
    private final static int WHITE_QUEEN = 9;
    private final static int WHITE_KING = 11;

    private final static int BLACK_PAWNS = 2;
    private final static int BLACK_ROOK = 4;
    private final static int BLACK_KNIGHT = 6;
    private final static int BLACK_BISHOP = 8;
    private final static int BLACK_QUEEN = 12;
    private final static int BLACK_KING = 10;
    private final static int NULL_CELL = 0;

    private List<Figures> figures = new ArrayList<Figures>();

//    private

    private void placeFigures() {
        for(int i = 0; i < 64; i++) {
            FrameLayout cell = (FrameLayout) gridLayout.getChildAt(i);
            ImageButton btn = (ImageButton) cell.getChildAt(0);

            if (i > 7 && i < 16) {
                btn.setImageResource(R.drawable.white_pawn);
                Pawn whitePawn = new Pawn(i, Players.WHITE.ordinal(), "" + WHITE_PAWNS);
                figures.add(whitePawn);
                btn.setTag(WHITE_PAWNS + " |" + figures.lastIndexOf(whitePawn));
            } else {
                if (i == 0 || i == 7) {
                    btn.setImageResource(R.drawable.white_rook);
                    Rook whiteRook = new Rook(i, Players.WHITE.ordinal(), "" + WHITE_ROOK);
                    figures.add(whiteRook);
                    btn.setTag(WHITE_ROOK + " |" + figures.lastIndexOf(whiteRook));
                } else {
                    if (i == 1 || i == 6) {
                        btn.setImageResource(R.drawable.white_knight);
                        Knight whiteKnight = new Knight(i, Players.WHITE.ordinal(), "" + WHITE_KNIGHT);
                        figures.add(whiteKnight);
                        btn.setTag(WHITE_KNIGHT + " |" + figures.lastIndexOf(whiteKnight));
                    } else {
                        if (i == 2 || i == 5) {
                            btn.setImageResource(R.drawable.white_bishop);
                            Bishop whiteBishop = new Bishop(i, Players.WHITE.ordinal(), "" + WHITE_BISHOP);
                            figures.add(whiteBishop);
                            btn.setTag(WHITE_BISHOP + " |" + figures.lastIndexOf(whiteBishop));
                        } else {
                            if (i == 3) {
                                btn.setImageResource(R.drawable.white_king);
                                King whiteKing = new King(i, Players.WHITE.ordinal(), "" + WHITE_KING);
                                figures.add(whiteKing);
                                btn.setTag(WHITE_KING + " |" + figures.lastIndexOf(whiteKing));
                            } else {
                                if (i == 4) {
                                    btn.setImageResource(R.drawable.white_queen);
                                    Queen whiteQueen = new Queen(i, Players.WHITE.ordinal(), "" + WHITE_QUEEN);
                                    figures.add(whiteQueen);
                                    btn.setTag(WHITE_QUEEN + " |" + figures.lastIndexOf(whiteQueen));
                                } else {
                                    if (i > 47 && i < 56) {
                                        btn.setImageResource(R.drawable.black_pawn);
                                        Pawn blackPawn = new Pawn(i, Players.BLACK.ordinal(), "" + BLACK_PAWNS);
                                        figures.add(blackPawn);
                                        btn.setTag(BLACK_PAWNS + " |" + figures.lastIndexOf(blackPawn));
                                    } else {
                                        if (i == 56 || i == 63) {
                                            btn.setImageResource(R.drawable.black_rook);
                                            Rook blackRook = new Rook(i, Players.BLACK.ordinal(), "" + BLACK_ROOK);
                                            figures.add(blackRook);
                                            btn.setTag(BLACK_ROOK + " |" + figures.lastIndexOf(blackRook));
                                        } else {
                                            if (i == 57 || i == 62) {
                                                btn.setImageResource(R.drawable.black_knight);
                                                Knight blackKnight = new Knight(i, Players.BLACK.ordinal(), "" + BLACK_KNIGHT);
                                                figures.add(blackKnight);
                                                btn.setTag(BLACK_KNIGHT + " |" + figures.lastIndexOf(blackKnight));
                                            } else {
                                                if (i == 58 || i == 61) {
                                                    btn.setImageResource(R.drawable.black_bishop);
                                                    Bishop blackBishop = new Bishop(i, Players.BLACK.ordinal(), "" + BLACK_BISHOP);
                                                    figures.add(blackBishop);
                                                    btn.setTag(BLACK_BISHOP + " |" + figures.lastIndexOf(blackBishop));
                                                } else {
                                                    if (i == 59) {
                                                        btn.setImageResource(R.drawable.black_king);
                                                        King blackKing = new King(i, Players.BLACK.ordinal(), "" + BLACK_KING);
                                                        figures.add(blackKing);
                                                        btn.setTag(BLACK_KING + " |" + figures.lastIndexOf(blackKing));
                                                    } else {
                                                        if (i == 60) {
                                                            btn.setImageResource(R.drawable.black_queen);
                                                            Queen blackQueen = new Queen(i, Players.BLACK.ordinal(), "" + BLACK_QUEEN);
                                                            figures.add(blackQueen);
                                                            btn.setTag(BLACK_QUEEN + " |" + figures.lastIndexOf(blackQueen));
                                                        } else {
                                                            btn.setImageResource(R.drawable.null_cell);
                                                            btn.setTag(NULL_CELL + "|" + i);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("Click", v.getTag().toString());

                    if (tmp == null && ! v.getTag().toString().equals("0") || tmp == null) {
                        tmp = (ImageButton) v;
                    } else {
                        replace(tmp, (ImageButton) v, figures.get(Integer.parseInt(
                                tmp.getTag().toString().substring(tmp.getTag().toString().indexOf("|")+1).trim()
                        )));
                        Log.d("TAG: ", v.getTag().toString());
                        tmp = null;
                    }
                }
            });
            cell = null;
            btn = null;
        }
        for (Figures f : figures) {
            Log.d("Array", ""+f.getPosition());
        }
    }

    private boolean check() {
        return true;
    }


    private void replace(ImageButton first, ImageButton second, Figures figure) {
        int currentPosition = figure.getPosition();
        Log.d("Last", figure.getPosition() + "");
//        Log.d("Click", first.getTag().toString());
//        Log.d("Click", second.getTag().toString());
        ImageButton tmp;
        if (second.getTag().toString().substring(0, second.getTag().toString().indexOf("|")).equals("0")) {
            tmp = new ImageButton(context);
            tmp.setImageDrawable(first.getDrawable());
            tmp.setTag(first.getTag());
            first.setImageDrawable(second.getDrawable());
            first.setTag(second.getTag());
            second.setImageDrawable(tmp.getDrawable());

            Log.d("Last", figure.getPosition() + "");
            figure.setPosition(Integer.parseInt(
                    first.getTag().toString().substring(first.getTag().toString().indexOf("|")+1).trim()));
            second.setTag(tmp.getTag());
        } else {
            tmp = new ImageButton(context);
            tmp.setImageDrawable(first.getDrawable());
            tmp.setTag(first.getTag());
            first.setImageResource(R.drawable.null_cell);
            first.setTag(NULL_CELL);
            second.setImageDrawable(tmp.getDrawable());
            second.setTag(tmp.getTag());
        }
//        Log.d("Click", first.getTag().toString());
//        Log.d("Click", second.getTag().toString());
        tmp = null;
    }

    public int[][] getBoard() {
        return allBoard;
    }
}
