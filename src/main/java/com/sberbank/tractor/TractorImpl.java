package com.sberbank.tractor;

/**
 * Реализация абстрактного класса Tractor
 */
class TractorImpl extends Tractor {

    private Position position = new Position(DEFAULT_POSITION);
    private Field field = new Field(DEFAULT_FIELD);
    private Orientation orientation = DEFAULT_ORIENTATION;

    TractorImpl() {
    }

    TractorImpl(final Position position, final Field field) {
        this.position = position;
        this.field = field;
    }

    @Override
    public long moveOneCommand(String command) {
        long rc = 0;
        Command enumCommand = null;
        try {
            enumCommand = Command.valueOf(command);
        }
        catch (IllegalArgumentException ex) {
            System.err.println("Unknown command - '" + command + "'");
        }
        if (enumCommand != null) {
            enumCommand.execute(this);
            nativeMove(command);  // Передаем команду на исполнительное ус-во трактора
            rc = enumCommand.getMaxTime();
        }
        return rc;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    protected void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public Field getField() {
        return field;
    }

    /**
     * Передача команды на исполнительное устройство трактора
     * @param command
     */
    private void nativeMove(String command) {
        // Поскольку нам неизвестно ничего об испольнительном устройстве трактора.
        // Оставим этот метод пока пустым
    }

}