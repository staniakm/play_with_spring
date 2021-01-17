package pl.mariusz.springstrategy.dto;

import lombok.AllArgsConstructor;
import lombok.Value;
import pl.mariusz.springstrategy.domain.OpertationType;

@AllArgsConstructor
@Value
public class PatchParametersDto {
    private OpertationType opertationType;
    private String path;
    private String value;


}
