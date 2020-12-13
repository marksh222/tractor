package com.sberbank.tractor;

import com.sberbank.tractor.exceptions.TractorFieldException;
import com.sberbank.tractor.exceptions.TractorInDitchException;
import com.sberbank.tractor.exceptions.TractorOrientationException;
import com.sberbank.tractor.exceptions.TractorPositionException;

/**
 * Класс, описывающий команды трактора.
 * Каждой команде соответствует свое действие, минимальное и максимальное время выполнения (в микросекундах).
 */
enum Command {
    /**
     * Вперед
     */
    F(new long[]{1000, 5000})
    {
        @Override
        void execute(Tractor tractor) {
            Position position = tractor.getPosition();
            Orientation orientation = tractor.getOrientation();
            Field field = tractor.getField();

            if (position == null) {
                throw new TractorPositionException("The position of the tractor is not defined");
            }
            if (orientation == null) {
                throw new TractorOrientationException("The orientation of the tractor is not defined");
            }
            if (field == null) {
                throw new TractorFieldException("Tractor field is not defined");
            }

            Position newPosition = orientation.forward(position);

            if (newPosition.getX() > field.getWidth() || newPosition.getY() > field.getLength() ||
                newPosition.getX() < 0 || newPosition.getY() < 0)
            {
                // Команда не будет выполнена! За пределами поля может быть что угодно.
                // Позиция трактора останется прежней.
                throw new TractorInDitchException("The attempt to go beyond the field. The position (" +
                        newPosition.getX() + ", " + newPosition.getY() + ") unacceptable."
                );
            }
            else {
                // Все в порядке - передвинем трактор.
                tractor.setPosition(newPosition);
            }
        }
    },

    /**
     * Поворот по часовой стрелке
     */
    T(new long[]{3000, 10000})
    {
        @Override
        void execute(Tractor tractor) {
            Orientation orientation = tractor.getOrientation();
            if (orientation != null)
                tractor.setOrientation(orientation.clockWise());
        }
    }
    ;

    /**
     * Минимальное и максимальное время выполнения команды
     */
    private long[] timeInterval;

    Command(long[] timeInterval) {
        this.timeInterval = timeInterval;
    }

    /**
     * Реализация команды
     * @param tractor
     */
    abstract void execute(Tractor tractor);

    /**
     * Минимальное время выполнения команды
     */
    long getMinTime() {
        return timeInterval[0];
    }

    /**
     * Максимальное время выполнения команды
     */
    long getMaxTime() {
        return timeInterval[1];
    }
}