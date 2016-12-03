package com.chess.android.achess.core;

/**
 * Created by NKostya on 03.12.2016.
 */
public abstract class Figures {

    /**
     * Позиция фигуры.
     */
    protected int position;

    /**
     * Id игрока
     */
    protected int player;

    /**
     * Метод для передвижения фигуры по шахматной доске.
     * @param position - индекс ячейки
     */
    protected abstract void move(int position);

    /**
     * Метод для задания начального размещения фигуры.
     * @param position - индекс ячейки
     */
    protected abstract void setPosition(int position);


    /**
     * Метод для получения текущей позиции фигуры на доске.
     * @return boolean
     */
    protected abstract int getPosition();

    /**
     * Метод для удаления фигуры.
     */
    protected abstract void remove();

    /**
     * Метод проверки ячейки. Существует ли фигура в выбранной ячейке.
     * @param position - индекс ячейки
     * @return boolean
     */
    protected abstract boolean checkCell(int position);

    /**
     * Метод для установки игрока (белый, черный).
     * @param player - id игрока (0 - белый, 1 - черный)
     */
    protected abstract void setPlayer(int player);

    /**
     * Метод для получения игрока.
     * @return int - id игрока
     */
    protected abstract int getPlayer();
}
