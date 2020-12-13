package com.sberbank.tractor;

import com.sberbank.tractor.exceptions.TractorCommandException;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Абстарактный класс, описывающий трактор.
 * Базовый класс для всех реальных тракторов.
 */
public abstract class Tractor {
    static final Position DEFAULT_POSITION = new Position(0, 0);
    static final Field DEFAULT_FIELD = new Field(5, 5);
    static final Orientation DEFAULT_ORIENTATION = Orientation.N;
    private final ReentrantLock lock = new ReentrantLock();
    /**
     * Выполняет команду трактора. Все коммнады в классе Command
     * @param command
     * @return Время ожидания реального выполнения команды
     */
    protected abstract long moveOneCommand(String command);

    public void moveListCommands(String commands) {
        try {
            lock.lock(); // Когда трактор выполняет команду - никакой другой поток не должен управлять им.
            if (commands == null) return;
            String[] aTok = commands.split(",");
            for (String command : aTok) {
                long wait = moveOneCommand(command);
                // Ждем
                if (wait > 0) {
                    try {
                        Thread.sleep(wait);
                    }
                    catch (InterruptedException e) {
                        throw new TractorCommandException(
                                "System error when running the command '" + command + "' " + e.getMessage());
                    }
                }
            }
        }
        finally {
            lock.unlock();
        }
    }

    /**
     * Возвращает положение трактора
     */
    public abstract Position getPosition();

    /**
     * Возвращает ориентацию трактора в пространстве
     */
    public abstract Orientation getOrientation();

    /**
     * Возвращает размеры поля.
     */
    public abstract Field getField();

    protected abstract void setPosition(Position position);
    protected abstract void setOrientation(Orientation orientation);
}