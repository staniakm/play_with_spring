package pl.mariusz.demomultiinject.exception;

import java.util.function.Function;
import java.util.function.Supplier;

public enum ExceptionProvider {

    FIELD_REQUIRED(fieldName -> new IllegalArgumentException(String.format("Field %s - is required", fieldName))),
    FIELD_TO_LONG(fieldName -> new IllegalArgumentException(String.format("Field %s - is too long", fieldName)));

    private final Function<String, RuntimeException> exceptionSupplier;

    ExceptionProvider(Function<String, RuntimeException> exceptionSupplier) {
        this.exceptionSupplier = exceptionSupplier;
    }

    public Supplier<RuntimeException> getMessage(String fieldName) {
        return () -> exceptionSupplier.apply(fieldName);
    }
}
