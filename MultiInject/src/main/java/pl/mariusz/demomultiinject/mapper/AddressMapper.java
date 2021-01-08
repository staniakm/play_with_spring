package pl.mariusz.demomultiinject.mapper;

import org.mapstruct.Mapper;
import pl.mariusz.demomultiinject.dto.AddressDto;
import pl.mariusz.demomultiinject.entity.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address mapFromDto(AddressDto dto);

}
