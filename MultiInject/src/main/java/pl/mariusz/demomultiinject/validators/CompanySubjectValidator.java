package pl.mariusz.demomultiinject.validators;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.mariusz.demomultiinject.entity.CompanySubject;
import pl.mariusz.demomultiinject.entity.Subject;

@Component
@Slf4j
public class CompanySubjectValidator implements SubjectValidator {
    @Override
    public boolean canHandle(Subject subject) {
        return subject instanceof CompanySubject;
    }

    @Override
    public boolean validate(Subject subject) {
        log.info("Validator: " + this.getClass().getName());
        if (subject instanceof CompanySubject) {
            CompanySubject personSubject = (CompanySubject) subject;
            if (personSubject.getCompanyName().trim().length() == 0) {
                return false;
            }

            return true;
        }
        throw new IllegalArgumentException("Subject of invalid type");
    }
}
