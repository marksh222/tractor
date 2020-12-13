package com.sberbank.tractor;

/**
 * Класс, описывающий положение трактора на поле
 */
public class Position {
    private int x = 0;
    private int y = 0;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(Position position) {
        this.x = position.getX();
        this.y = position.getY();
    }

    /**
     * Позиция по оси x
     */
    public int getX() {
        return x;
    }
    /**
     * Позиция по оси y
     */
    public int getY() {
        return y;
    }
}