package pl.mariusz.demomultiinject.validators;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.mariusz.demomultiinject.entity.CompanySubject;
import pl.mariusz.demomultiinject.entity.Subject;

@Component
@Slf4j
@RequiredArgsConstructor
public class CompanySubjectValidator implements SubjectValidator {

    private final AddressValidator validator;

    @Override
    public boolean canHandle(Subject subject) {
        return subject instanceof CompanySubject;
    }

    @Override
    public boolean validate(Subject subject) {
        log.info("Validator: " + this.getClass().getName());
        if (subject instanceof CompanySubject) {
            CompanySubject companySubject = (CompanySubject) subject;
            if (companySubject.getCompanyName().trim().length() == 0) {
                return false;
            }

            validator.validate(companySubject.getCompanyAddress());

            return true;
        }
        throw new IllegalArgumentException("Subject of invalid type");
    }
}
