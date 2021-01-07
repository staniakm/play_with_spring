package pl.mariusz.demomultiinject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.mariusz.demomultiinject.entity.CompanySubject;
import pl.mariusz.demomultiinject.entity.PersonSubject;
import pl.mariusz.demomultiinject.entity.Subject;
import pl.mariusz.demomultiinject.validators.CompanySubjectValidator;
import pl.mariusz.demomultiinject.validators.PersonSubjectValidator;
import pl.mariusz.demomultiinject.validators.SubjectValidationService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ValidationServiceTest {

    @Autowired
    private SubjectValidationService service;

    @Test
    void shouldValidatePersonSubject() {
        //given
        Subject subject = new PersonSubject("Jan", "Kowalski", "Address");

        //when
        boolean valid = service.isValid(subject);

        //then
        assertTrue(valid);
    }

    @Test
    void shouldValidatePersonSubjectWithError() {
        //given
        Subject subject = new PersonSubject("   ", "Kowalski", "Address");

        //when
        boolean valid = service.isValid(subject);

        //then
        assertFalse(valid);
    }

    @Test
    void shouldValidatePersonSubjectWithException() {
        //given
        Subject subject = new CompanySubject("Company",  "Address");

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new PersonSubjectValidator().validate(subject));

        //then
        assertThat(exception.getMessage()).isEqualTo("Subject of invalid type");
    }


    @Test
    void shouldValidateCompanySubject() {
        //given
        Subject subject = new CompanySubject("Company",  "Address");;

        //when
        boolean valid = service.isValid(subject);

        //then
        assertTrue(valid);
    }

    @Test
    void shouldValidateCompanySubjectWithError() {
        //given
        Subject subject = new CompanySubject(" ",  "Address");;

        //when
        boolean valid = service.isValid(subject);

        //then
        assertFalse(valid);
    }

    @Test
    void shouldValidateCompanySubjectWithException() {
        //given
        Subject subject = new PersonSubject("   ", "Kowalski", "Address");

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new CompanySubjectValidator().validate(subject));

        //then
        assertThat(exception.getMessage()).isEqualTo("Subject of invalid type");
    }
}
