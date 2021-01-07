package pl.mariusz.demomultiinject.validators;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.mariusz.demomultiinject.entity.PersonSubject;
import pl.mariusz.demomultiinject.entity.Subject;

@Component
@Slf4j
public class PersonSubjectValidator implements SubjectValidator {
    @Override
    public boolean canHandle(Subject subject) {
        return subject instanceof PersonSubject;
    }

    @Override
    public boolean validate(Subject subject) {
        log.info("Validator: " + this.getClass().getName());
        if (subject instanceof PersonSubject) {
            PersonSubject personSubject = (PersonSubject) subject;
            if (personSubject.getName().trim().length() == 0) {
                return false;
            }

            return true;
        }
        throw new IllegalArgumentException("Subject of invalid type");
    }
}
