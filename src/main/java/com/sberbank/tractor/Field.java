package com.sberbank.tractor;

/**
 * Класс, описывающий поле трактора.
 */
public class Field {
    private int width  = 0;
    private int length = 0;

    public Field(int width, int length) {
        this.width = width;
        this.length = length;
    }
    public Field(Field field) {
        this.width = field.width;
        this.length = field.length;
    }

    public int getWidth() {
        return width;
    }
    public int getLength() {
        return length;
    }

}