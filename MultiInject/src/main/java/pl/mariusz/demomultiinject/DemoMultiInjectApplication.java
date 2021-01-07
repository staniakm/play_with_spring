package pl.mariusz.demomultiinject;

import lombok.*;
import org.mapstruct.Mapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoMultiInjectApplication implements CommandLineRunner {

    private final MappingService service;

    public static void main(String[] args) {
        SpringApplication.run(DemoMultiInjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setAddress("Address");
        subjectDto.setName("Jan");
        subjectDto.setSurname("kowalski");

        Subject s = service.map(subjectDto);

        System.out.println(s);

    }

}


@Component
@RequiredArgsConstructor
class MappingService {
    private final List<SubjectMapper> mappers;


    public Subject map(SubjectDto subjectDto) {
        Subject subject = null;
        for (SubjectMapper mapper : mappers) {
            if (mapper.canHandle(subjectDto)) {
                subject = mapper.handle(subjectDto);
                break;
            }
        }
        return subject;
    }

}

interface SubjectMapper {
    boolean canHandle(SubjectDto dto);

    Subject handle(SubjectDto dto);
}

interface Subject {
}

@Getter
@Setter
class SubjectDto {
    private String name;
    private String surname;
    private String companyName;
    private String address;
}

@Getter
@Setter
@AllArgsConstructor
@ToString
class PersonSubject implements Subject {
    private String name;
    private String surname;
    private String address;
}

@Getter
@Setter
@AllArgsConstructor
@ToString
class CompanySubject implements Subject {
    private String companyName;
    private String address;
}

@Component
@Mapper(componentModel = "spring")
abstract class PersonMapper implements SubjectMapper {

    @Override
    public boolean canHandle(SubjectDto dto) {
        return dto.getName() != null && dto.getSurname() != null;
    }

    @Override
    public abstract PersonSubject handle(SubjectDto dto);
}

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
