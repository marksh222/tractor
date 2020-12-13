package com.sberbank.tractor.exceptions;

/**
 * Исключение, возникающее, когда ориентация трактора не определена
 */
public class TractorOrientationException extends TractorException {
    public TractorOrientationException(String message) {
        super(message);
    }
}
