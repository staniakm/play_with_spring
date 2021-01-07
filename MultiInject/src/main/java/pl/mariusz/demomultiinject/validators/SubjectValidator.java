package pl.mariusz.demomultiinject.validators;


import pl.mariusz.demomultiinject.entity.Subject;

public interface SubjectValidator {
    boolean canHandle(Subject subject);

    boolean validate(Subject subject);
}
