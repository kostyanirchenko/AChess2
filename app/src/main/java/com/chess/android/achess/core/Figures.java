package com.chess.android.achess.core;

/**
 * Created by NKostya on 03.12.2016.
 */
public abstract class Figures {

    /**
     * Тег фигуры.
     */
    public String tag;
    /**
     * Позиция фигуры.
     */
    public int position;

    /**
     * Id игрока.
     */
    public int player;

    /**
     * Удалена ли фигура из поля.
     */
    public boolean removed;

    /**
     * Метод для передвижения фигуры по шахматной доске.
     * @param position - индекс ячейки
     */
    public abstract void move(int position);

    /**
     * Метод для задания начального размещения фигуры.
     * @param position - индекс ячейки
     */
    public abstract void setPosition(int position);


    /**
     * Метод для получения текущей позиции фигуры на доске.
     * @return boolean
     */
    public abstract int getPosition();

    /**
     * Метод для удаления фигуры.
     */
    public abstract void remove();

    /**
     * Метод проверки ячейки. Существует ли фигура в выбранной ячейке.
     * @param position - индекс ячейки
     * @return boolean
     */
    public abstract boolean checkCell(int position);

    /**
     * Метод для установки игрока (белый, черный).
     * @param player - id игрока (0 - белый, 1 - черный)
     */
    public abstract void setPlayer(int player);

    /**
     * Метод для получения игрока.
     * @return int - id игрока
     */
    public abstract int getPlayer();

    public abstract void setTag(String tag);

    public abstract String getTag();
}
