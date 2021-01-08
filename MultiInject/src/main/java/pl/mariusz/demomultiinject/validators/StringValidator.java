package pl.mariusz.demomultiinject.validators;

public class StringValidator {

    public static void maxLengthValidator(String fieldName, String value, int maxLength) {
        if (value != null && value.length() > maxLength)
            throw new IllegalArgumentException(String.format("Field %s - is too long", fieldName));
    }

    public static void requiredField(String fieldName, String value) {
        if (value == null) throw new IllegalArgumentException(String.format("Field %s - is required", fieldName));
    }
}
