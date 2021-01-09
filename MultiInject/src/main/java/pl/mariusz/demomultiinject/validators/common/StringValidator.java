package pl.mariusz.demomultiinject.validators.common;

import static java.lang.String.format;

public class StringValidator {

    private StringValidator() {
    }

    public static StringValidator getInstance() {
        return new StringValidator();
    }

    public StringValidator maxLengthValidator(String fieldName, String value, int maxLength) {
        if (value != null && value.length() > maxLength)
            throw new IllegalArgumentException(format("Field %s - is too long", fieldName));
        return this;
    }

    public StringValidator requiredField(String fieldName, String value) {
        if (value == null) throw new IllegalArgumentException(format("Field %s - is required", fieldName));
        return this;
    }
}
