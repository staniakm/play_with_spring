package pl.mariusz.springtraining.mapping.entity;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class MapDto {
    private String minimal;
    private String metadata;
    private String content;
    private int size;

}
