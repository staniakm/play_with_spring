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
        Subject subject = null;
        for (SubjectMapper mapper : mappers) {
            if (mapper.canHandle(subjectDto)) {
                subject = mapper.handle(subjectDto);
                break;
            }
        }
        return subject;
    }

}
