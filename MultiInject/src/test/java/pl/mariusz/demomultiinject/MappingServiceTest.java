package pl.mariusz.demomultiinject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.mariusz.demomultiinject.dto.AddressDto;
import pl.mariusz.demomultiinject.dto.SubjectDto;
import pl.mariusz.demomultiinject.entity.Address;
import pl.mariusz.demomultiinject.entity.CompanySubject;
import pl.mariusz.demomultiinject.entity.PersonSubject;
import pl.mariusz.demomultiinject.entity.Subject;
import pl.mariusz.demomultiinject.mapper.MappingService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class MappingServiceTest {

    @Autowired
    private MappingService service;

    @Test
    void shouldMapToPersonSubject() {
        //given
        Address address = new Address("Street", "City");
        SubjectDto dto = new SubjectDto();
        dto.setName("Jan");
        dto.setSurname("Kowalski");
        AddressDto addressDto = new AddressDto("Street", "City");
        dto.setAddress(addressDto);

        //when
        Subject map = service.map(dto);

        //then
        assertThat(map).isInstanceOf(PersonSubject.class);
        PersonSubject personSubject = (PersonSubject) map;
        assertThat(personSubject.getAddress()).usingRecursiveComparison().isEqualTo(address);
        assertThat(personSubject.getName()).isEqualTo("Jan");
        assertThat(personSubject.getSurname()).isEqualTo("Kowalski");
    }

    @Test
    void shouldMapToCompanySubject() {
        //given
        Address address = new Address("Street", "City");
        AddressDto addressDto = new AddressDto("Street", "City");
        SubjectDto dto = new SubjectDto();
        dto.setCompanyName("Company");
        dto.setAddress(addressDto);

        //when
        Subject map = service.map(dto);

        //then
        assertThat(map).isInstanceOf(CompanySubject.class);
        CompanySubject companySubject = (CompanySubject) map;
        assertThat(companySubject.getCompanyAddress()).usingRecursiveComparison().isEqualTo(address);
        assertThat(companySubject.getCompanyName()).isEqualTo("Company");
    }

    @Test
    void shouldThrowExceptionOnUnknownEntity() {
        //given
        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setName("Jan");

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> service.map(subjectDto));

        assertThat(exception.getMessage()).isEqualTo("Subject is invalid type");
    }
}
