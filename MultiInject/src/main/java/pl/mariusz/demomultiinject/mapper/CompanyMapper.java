package pl.mariusz.demomultiinject.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import pl.mariusz.demomultiinject.dto.SubjectDto;
import pl.mariusz.demomultiinject.entity.CompanySubject;

@Component
@Mapper(componentModel = "spring")
abstract class CompanyMapper implements SubjectMapper {

    @Override
    public boolean canHandle(SubjectDto dto) {
        return dto.getCompanyName() != null;
    }

    @Override
    public abstract CompanySubject handle(SubjectDto dto);
}
