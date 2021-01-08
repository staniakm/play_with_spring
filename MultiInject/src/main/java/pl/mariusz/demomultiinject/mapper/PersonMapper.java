package pl.mariusz.demomultiinject.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import pl.mariusz.demomultiinject.dto.SubjectDto;
import pl.mariusz.demomultiinject.entity.PersonSubject;

@Component
@Mapper(uses ={AddressMapper.class} ,componentModel = "spring")
abstract class PersonMapper implements SubjectMapper {

    @Override
    public boolean canHandle(SubjectDto dto) {
        return dto.getName() != null && dto.getSurname() != null;
    }

    @Override
    public abstract PersonSubject handle(SubjectDto dto);
}
