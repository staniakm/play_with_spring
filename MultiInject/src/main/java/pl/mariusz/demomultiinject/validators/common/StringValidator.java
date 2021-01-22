package pl.mariusz.demomultiinject.validators.common;

import java.util.function.Supplier;

public class StringValidator {

    private StringValidator() {
    }

    public static StringValidator getInstance() {
        return new StringValidator();
    }

    public StringValidator maxLengthValidator(String value, int maxLength, Supplier<RuntimeException> exceptionSupplier) {
        if (value != null && value.length() > maxLength)
            throw exceptionSupplier.get();
        return this;
    }

    public StringValidator requiredField(String value, Supplier<RuntimeException> exceptionSupplier) {
        if (value == null) throw exceptionSupplier.get();
        return this;
    }
}
