package pl.mariusz.demomultiinject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import pl.mariusz.demomultiinject.dto.SubjectDto;
import pl.mariusz.demomultiinject.entity.CompanySubject;

@Component
@Mapper(uses ={AddressMapper.class} ,componentModel = "spring")
abstract class CompanyMapper implements SubjectMapper {

    @Override
    public boolean canHandle(SubjectDto dto) {
        return dto.getCompanyName() != null;
    }

    @Override
    @Mapping(source = "dto.address", target = "companyAddress")
    public abstract CompanySubject handle(SubjectDto dto);
}
