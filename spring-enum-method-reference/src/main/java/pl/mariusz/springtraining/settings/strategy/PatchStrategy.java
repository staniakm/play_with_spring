package pl.mariusz.springtraining.settings.strategy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.mariusz.springtraining.settings.model.SettingsEntity;
import pl.mariusz.springtraining.settings.model.SettingsEntityDto;

@Component
@RequiredArgsConstructor
public class PatchStrategy {

    private final AddPatchStrategy addPatchStrategy;
    private final ReplacePatchStrategy replacePatchStrategy;
    private final DeletePatchStrategy deletePatchStrategy;

    public SettingsEntity applyPatch(SettingsEntityDto settingsEntity) {
        return settingsEntity.getPatchAlogritm()
                .apply(this, settingsEntity);
    }

    public SettingsEntity addSettings(SettingsEntityDto settingsEntity) {
        return addPatchStrategy.apply(settingsEntity);
    }

    public SettingsEntity replaceSettings(SettingsEntityDto settingsEntity) {
        return replacePatchStrategy.apply(settingsEntity);
    }

    public SettingsEntity deleteSettings(SettingsEntityDto settingsEntity) {
        return deletePatchStrategy.apply(settingsEntity);
    }

}
