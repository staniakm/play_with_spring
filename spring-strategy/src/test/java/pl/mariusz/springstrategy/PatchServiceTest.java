package pl.mariusz.springstrategy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.mariusz.springstrategy.domain.Subject;
import pl.mariusz.springstrategy.dto.PatchParametersDto;
import pl.mariusz.springstrategy.patch.PatchService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.mariusz.springstrategy.domain.OpertationType.*;

@SpringBootTest
public class PatchServiceTest {

    @Autowired
    private PatchService patchService;

    @Test
    void shouldPatchSubjectAddEmail() {
        //given
        Subject subject = new Subject("email", "phone", "address");
        PatchParametersDto patchParametersDto = new PatchParametersDto(ADD, "email", "email@email.pl");

        //when
        Subject patch = patchService.patch(subject, patchParametersDto);

        //then
        assertEquals("email@email.pl", patch.getEmail());
        assertEquals("phone", patch.getPhone());
        assertEquals("address", patch.getAddress());
    }

    @Test
    void shouldPatchSubjectReplaceEmail() {
        //given
        Subject subject = new Subject("email", "phone", "address");
        PatchParametersDto patchParametersDto = new PatchParametersDto(REPLACE, "email", "");

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> patchService.patch(subject, patchParametersDto));

        //then
        assertEquals("Email must not be empty", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionOnEmptyEmail() {
        //given
        Subject subject = new Subject("email", "phone", "address");
        PatchParametersDto patchParametersDto = new PatchParametersDto(REMOVE, "email", "email@email.pl");

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> patchService.patch(subject, patchParametersDto));

        //then
        assertEquals("Email cannot be deleted", exception.getMessage());
    }
}
