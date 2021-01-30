package pl.mariusz.springtraining.mapping;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.mariusz.springtraining.mapping.entity.MapDto;
import pl.mariusz.springtraining.mapping.entity.MapEntity;
import pl.mariusz.springtraining.mapping.strategy.MappingStrategy;
import pl.mariusz.springtraining.mapping.strategy.MappingType;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class MappingApplication implements CommandLineRunner {

    private final MappingStrategy mappingStrategy;

    public static void main(String[] args) {
        SpringApplication.run(MappingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        MapEntity mapEntity = new MapEntity("minimal", "meta", "content", 10);
        MapDto DTO1 = mappingStrategy.map(mapEntity, MappingType.MINIMAL);
        MapDto DTO2 = mappingStrategy.map(mapEntity, MappingType.FULL);
        MapDto DTO3 = mappingStrategy.map(mapEntity, MappingType.META);

        System.out.println(DTO1);
        System.out.println(DTO2);
        System.out.println(DTO3);

        System.out.println(mappingStrategy.mapDtoList(List.of(mapEntity, mapEntity), MappingType.MINIMAL));

    }
}
