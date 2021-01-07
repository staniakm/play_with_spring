package pl.mariusz.demomultiinject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MappingServiceTest {

    @Autowired
    private MappingService service;

    @Test
    void shouldMapToPersonSubject() {
        //given
        SubjectDto dto = new SubjectDto();
        dto.setName("Jan");
        dto.setSurname("Kowalski");
        dto.setAddress("Address");

        //when
        Subject map = service.map(dto);

        //then
        assertThat(map).isInstanceOf(PersonSubject.class);
        PersonSubject personSubject = (PersonSubject) map;
        assertThat(personSubject.getAddress()).isEqualTo("Address");
        assertThat(personSubject.getName()).isEqualTo("Jan");
        assertThat(personSubject.getSurname()).isEqualTo("Kowalski");
    }

    @Test
    void shouldMapToCompanySubject() {
        //given
        SubjectDto dto = new SubjectDto();
        dto.setCompanyName("Company");
        dto.setAddress("Address");

        //when
        Subject map = service.map(dto);

        //then
        assertThat(map).isInstanceOf(CompanySubject.class);
        CompanySubject companySubject = (CompanySubject) map;
        assertThat(companySubject.getAddress()).isEqualTo("Address");
        assertThat(companySubject.getCompanyName()).isEqualTo("Company");
    }
}
