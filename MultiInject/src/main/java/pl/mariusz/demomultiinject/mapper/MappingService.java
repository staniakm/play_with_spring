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
        for (SubjectMapper mapper : mappers) {
            if (mapper.canHandle(subjectDto)) {
                return mapper.handle(subjectDto);
            }
        }
        throw new IllegalArgumentException("Subject is invalid type");
    }

}
