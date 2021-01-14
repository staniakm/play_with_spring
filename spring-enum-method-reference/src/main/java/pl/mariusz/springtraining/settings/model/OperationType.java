package pl.mariusz.springtraining.settings.model;

import lombok.Getter;
import pl.mariusz.springtraining.settings.strategy.PatchStrategy;

import java.util.function.BiFunction;

@Getter
public enum OperationType {
    ADD(PatchStrategy::addSettings, 1),
    REPLACE(PatchStrategy::replaceSettings, 2),
    DELETE(PatchStrategy::deleteSettings, 3);

    private final BiFunction<PatchStrategy, SettingsEntityDto, SettingsEntity> patchAlogritm;
    private int randomValue;

    OperationType(BiFunction<PatchStrategy, SettingsEntityDto, SettingsEntity> patchAlogritm, int randomValue) {
        this.patchAlogritm = patchAlogritm;
        this.randomValue = randomValue;
    }
}
