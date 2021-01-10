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
        return validators.stream()
                .filter(it -> it.canHandle(subject))
                .map(it -> it.validate(subject))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Subject invalid type"));
    }


}
