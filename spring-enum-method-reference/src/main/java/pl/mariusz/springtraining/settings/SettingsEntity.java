package pl.mariusz.springtraining.settings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.function.BiFunction;

@AllArgsConstructor
@Getter
@ToString
public class SettingsEntity {

    private String name;

}

@AllArgsConstructor
@Getter
@ToString
class SettingsEntityDto {
    private final OperationType operationType;
    private final String name;
    private final String value;

    public BiFunction<PatchStrategy, SettingsEntityDto, SettingsEntity> getPatchAlogritm(){
        return operationType.getPatchAlogritm();
    }
}
