package com.sberbank.tractor.exceptions;

/**
 * Исключение, возникающее, когда положение трактора не определено
 */
public class TractorPositionException extends TractorException {
    public TractorPositionException(String message) {
        super(message);
    }
}
