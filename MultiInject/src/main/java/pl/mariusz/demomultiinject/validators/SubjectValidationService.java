package pl.mariusz.demomultiinject.validators;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.mariusz.demomultiinject.entity.Subject;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class SubjectValidationService {

    private final List<SubjectValidator> validators;

    public boolean isValid(Subject subject) {
        log.info("Start validate " + subject);
        for (SubjectValidator validator : validators) {
            if (validator.canHandle(subject)) {
                return validator.validate(subject);
            }
        }
        throw new IllegalArgumentException("Subject is invalid type");
    }


}
