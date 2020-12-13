package com.sberbank.tractor.exceptions;

/**
 * Исключение, возникающее, когда трактор пытается выйти за пределы поля
 */
public class TractorInDitchException extends TractorException {
    public TractorInDitchException(String message) {
        super(message);
    }
}