package pl.mariusz.springtraining.mapping.strategy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.mariusz.springtraining.mapping.entity.MapDto;
import pl.mariusz.springtraining.mapping.entity.MapEntity;
import pl.mariusz.springtraining.mapping.mapper.MapMapper;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
public class MappingStrategy {

    private final MapMapper mapMapper;

    public MapDto map(MapEntity mapEntity, MappingType mappingType) {
        return mappingType.getAlgoritm().apply(this, mapEntity);
    }

    public List<MapDto> mapDtoList(List<MapEntity> entities, MappingType mappingType) {
        return entities.stream()
                .map(it -> mappingType.getAlgoritm().apply(this, it))
                .collect(Collectors.toList());
    }

    MapDto mapMinimal(MapEntity entity) {
        log.info("Mapping strategy: minimal");
        return mapMapper.map(mapMapper.mapToMinimal(entity));

    }

    MapDto mapFull(MapEntity entity) {
        log.info("Mapping strategy: full");
        return mapMapper.mapToFull(entity);
    }

    MapDto mapMeta(MapEntity entity) {
        log.info("Mapping strategy: meta");
        return mapMapper.map(mapMapper.mapToMeta(entity));
    }


}
