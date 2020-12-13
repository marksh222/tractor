package com.sberbank.tractor;

/**
 * Класс, описывающий ориентацию трактора в пространстве
 */
public enum Orientation {
    /**
     * Север
     */
    N
    {
        @Override
        public Orientation clockWise() {
            return E;
        }

        @Override
        public Position forward(Position position) {
            return new Position(position.getX(), position.getY() + 1);
        }
    },
    /**
     * Восток
     */
    E
    {
        @Override
        public Orientation clockWise() {
            return S;
        }

        @Override
        public Position forward(Position position) {
            return new Position(position.getX() + 1, position.getY());
        }
    },
    /**
     * Юг
     */
    S
    {
        @Override
        public Orientation clockWise() {
            return W;
        }

        @Override
        public Position forward(Position position) {
            return new Position(position.getX(), position.getY() - 1);
        }
    },
    /**
     * Запад
     */
    W
    {
        @Override
        public Orientation clockWise() {
            return N;
        }

        @Override
        public Position forward(Position position) {
            return new Position(position.getX() - 1, position.getY());
        }
    }
    ;

    /**
     * Поворот по часовой стрелке для данной ориентации, в результате получаем новую ориентацию
     */
    public abstract Orientation clockWise();
    /**
     * Движение вперед для данной ориентации, в результате получаем новое положение трактора
     */
    public abstract Position forward(Position position);

}