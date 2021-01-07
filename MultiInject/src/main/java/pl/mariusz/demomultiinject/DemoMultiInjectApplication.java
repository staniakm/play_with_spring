package pl.mariusz.demomultiinject;

import lombok.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.mariusz.demomultiinject.dto.SubjectDto;
import pl.mariusz.demomultiinject.entity.Subject;
import pl.mariusz.demomultiinject.mapper.MappingService;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoMultiInjectApplication implements CommandLineRunner {

    private final MappingService service;

    public static void main(String[] args) {
        SpringApplication.run(DemoMultiInjectApplication.class, args);
    }

    @Override
    public void run(String... args) {

        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setAddress("Address");
        subjectDto.setName("Jan");
        subjectDto.setSurname("kowalski");

        Subject s = service.map(subjectDto);

        System.out.println(s);



    }

}


