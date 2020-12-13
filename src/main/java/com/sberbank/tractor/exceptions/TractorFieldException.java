package com.sberbank.tractor.exceptions;

/**
 * Исключение, возникающее, когда поле трактора не определено
 */
public class TractorFieldException extends TractorException {
    public TractorFieldException(String message) {
        super(message);
    }
}
