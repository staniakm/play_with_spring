package pl.mariusz.springtraining.mapping.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MapEntity {
    private String minimal;
    private String metadata;
    private String content;
    private int size;
}
