package pl.mariusz.springtraining.settings.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import pl.mariusz.springtraining.settings.strategy.PatchStrategy;

import java.util.function.BiFunction;

@AllArgsConstructor
@Getter
@ToString
public class SettingsEntityDto {
    private final OperationType operationType;
    private final String name;
    private final String value;

    public BiFunction<PatchStrategy, SettingsEntityDto, SettingsEntity> getPatchAlogritm() {
        return operationType.getPatchAlogritm();
    }
}
