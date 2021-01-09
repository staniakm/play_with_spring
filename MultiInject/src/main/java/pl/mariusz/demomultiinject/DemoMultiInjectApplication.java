package pl.mariusz.demomultiinject;

import lombok.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.mariusz.demomultiinject.dto.SubjectDto;
import pl.mariusz.demomultiinject.entity.Subject;
import pl.mariusz.demomultiinject.mapper.MappingService;

@SpringBootApplication
public class DemoMultiInjectApplication{

    public static void main(String[] args) {
        SpringApplication.run(DemoMultiInjectApplication.class, args);
    }

}


