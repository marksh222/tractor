package com.sberbank.tractor.exceptions;

/**
 * Исключение, возникающее, когда не задан файл для управления трактором, или он недоступен
 */
public class TractorInputFileException extends TractorException {
    public TractorInputFileException(String message) {
        super(message);
    }
}
