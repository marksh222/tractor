package com.sberbank.tractor;

import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;

/**
 * Фабрика классов тракторов и 'водителей' тракторов
 */
public class TractorFactory {
    /**
     * Возвращает трактор, с характеристиками по умолчанию
     */
    static Tractor createTractor() {
       return new TractorImpl();
    }

    /**
     * Возвращает трактор, c заданной начальной позицией и размерами поля
     */
    public static Tractor createTractor(final Position position, final Field field) {
        return new TractorImpl(position, field);
    }

    /**
     * Возвращает 'водителя' трактора, который действует на основе локального json-файла
     */
    public static TractorDriver createTractorDriver(final File file) throws IOException, ParseException {
        return new TractorDriverImpl(file);
    }
}