package pl.mariusz.springtraining.settings.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.mariusz.springtraining.settings.model.SettingsEntity;

@Component
@Slf4j
public class SettingsRepository {

    public SettingsEntity save(SettingsEntity settingsEntity) {
        log.info("Saving: {}", settingsEntity);
        return settingsEntity;
    }

    public SettingsEntity delete(SettingsEntity settingsEntity) {
        return null;
    }
}
