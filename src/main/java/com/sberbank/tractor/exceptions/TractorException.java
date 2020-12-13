package com.sberbank.tractor.exceptions;

/**
 * Базовый класс исключений возможных в пакете
 */
class TractorException extends RuntimeException {
    TractorException(String message) {
        super(message);
    }
}
