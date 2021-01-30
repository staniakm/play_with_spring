package pl.mariusz.springtraining.mapping.mapper;

import org.springframework.stereotype.Component;
import pl.mariusz.springtraining.mapping.entity.MapDto;
import pl.mariusz.springtraining.mapping.entity.MapEntity;
import pl.mariusz.springtraining.mapping.entity.MapMeta;
import pl.mariusz.springtraining.mapping.entity.MapMinimal;

@Component
public class MapMapper {


    public MapMinimal mapToMinimal(MapEntity entity) {

        return new MapMinimal(entity.getMinimal());
    }

    public MapDto map(MapMinimal minimal) {
        MapDto mapDto = new MapDto();
        mapDto.setMinimal(minimal.getMinimal());
        return mapDto;
    }


    public MapMeta mapToMeta(MapEntity entity) {

        return new MapMeta(entity.getMinimal(), entity.getMetadata());
    }

    public MapDto map(MapMeta mapMeta) {
        MapDto mapDto = new MapDto();
        mapDto.setMetadata(mapMeta.getMinimal());
        mapDto.setMetadata(mapMeta.getMetadata());
        return mapDto;
    }

    public MapDto mapToFull(MapEntity entity) {
        MapDto dto = new MapDto();

        dto.setMinimal(entity.getMinimal());
        dto.setMetadata(entity.getMetadata());
        dto.setContent(entity.getContent());
        dto.setSize(entity.getSize());
        return dto;
    }
}
