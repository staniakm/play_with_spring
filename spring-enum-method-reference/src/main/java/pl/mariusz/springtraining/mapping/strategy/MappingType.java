package pl.mariusz.springtraining.mapping.strategy;

import lombok.Getter;
import pl.mariusz.springtraining.mapping.entity.MapDto;
import pl.mariusz.springtraining.mapping.entity.MapEntity;

import java.util.function.BiFunction;

@Getter
public enum MappingType {
    FULL(MappingStrategy::mapFull),
    MINIMAL(MappingStrategy::mapMinimal),
    META(MappingStrategy::mapMeta);

    private final BiFunction<MappingStrategy, MapEntity, MapDto> algoritm;

    MappingType(BiFunction<MappingStrategy, MapEntity, MapDto> algoritm) {
        this.algoritm = algoritm;
    }
}
