package pl.mariusz.demomultiinject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.mariusz.demomultiinject.entity.Address;
import pl.mariusz.demomultiinject.entity.CompanySubject;
import pl.mariusz.demomultiinject.entity.PersonSubject;
import pl.mariusz.demomultiinject.entity.Subject;
import pl.mariusz.demomultiinject.validators.AddressValidator;
import pl.mariusz.demomultiinject.validators.CompanySubjectValidator;
import pl.mariusz.demomultiinject.validators.PersonSubjectValidator;
import pl.mariusz.demomultiinject.validators.SubjectValidationService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ValidationServiceTest {

    @Autowired
    private SubjectValidationService service;

    @Autowired
    private AddressValidator addressValidator;

    @Test
    void shouldValidatePersonSubject() {
        //given
        Subject subject = new PersonSubject("Jan", "Kowalski", getAddress());

        //when
        boolean valid = service.isValid(subject);

        //then
        assertTrue(valid);
    }

    @Test
    void shouldValidatePersonSubjectWithError() {
        //given
        Subject subject = new PersonSubject("   ", "Kowalski", getAddress());

        //when
        boolean valid = service.isValid(subject);

        //then
        assertFalse(valid);
    }

    @Test
    void shouldValidatePersonSubjectWithException() {
        //given
        Subject subject = new CompanySubject("Company", getAddress());

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new PersonSubjectValidator(addressValidator).validate(subject));

        //then
        assertThat(exception.getMessage()).isEqualTo("Subject of invalid type");
    }

    @Test
    void shouldValidatePersonSubjectWithAddressException() {
        //given
        Address address = new Address("very long street name", "city");
        Subject subject = new PersonSubject("Jan", "kowalski", address);

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new PersonSubjectValidator(addressValidator).validate(subject));

        //then
        assertThat(exception.getMessage()).isEqualTo("Field street - is too long");
    }

    @Test
    void shouldValidatePersonSubjectWithEmptyStreetAddressException() {
        //given
        Address address = new Address(null, "city");
        Subject subject = new PersonSubject("Jan", "kowalski", address);

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new PersonSubjectValidator(addressValidator).validate(subject));

        //then
        assertThat(exception.getMessage()).isEqualTo("Field street - is required");
    }


    @Test
    void shouldValidateCompanySubject() {
        //given
        Subject subject = new CompanySubject("Company", getAddress());
        ;

        //when
        boolean valid = service.isValid(subject);

        //then
        assertTrue(valid);
    }

    @Test
    void shouldValidateCompanySubjectWithError() {
        //given
        Subject subject = new CompanySubject(" ", getAddress());
        ;

        //when
        boolean valid = service.isValid(subject);

        //then
        assertFalse(valid);
    }

    @Test
    void shouldValidateCompanySubjectWithException() {
        //given
        Subject subject = new PersonSubject("   ", "Kowalski", getAddress());

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new CompanySubjectValidator(addressValidator).validate(subject));

        //then
        assertThat(exception.getMessage()).isEqualTo("Subject of invalid type");
    }

    private Address getAddress() {
        return new Address("Street", "City");
    }
}
