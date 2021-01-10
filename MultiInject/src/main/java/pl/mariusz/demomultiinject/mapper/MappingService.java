package pl.mariusz.demomultiinject.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.mariusz.demomultiinject.dto.SubjectDto;
import pl.mariusz.demomultiinject.entity.Subject;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MappingService {
    private final List<SubjectMapper> mappers;


    public Subject map(SubjectDto subjectDto) {
        return mappers.stream()
                .filter(it -> it.canHandle(subjectDto))
                .map(it -> it.handle(subjectDto))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Subject invalid type"));
    }

}
