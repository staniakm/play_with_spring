package pl.mariusz.springtraining.settings.strategy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import pl.mariusz.springtraining.settings.repository.SettingsRepository;
import pl.mariusz.springtraining.settings.model.SettingsEntity;
import pl.mariusz.springtraining.settings.model.SettingsEntityDto;

@Component
@Slf4j
@RequiredArgsConstructor
public class ReplacePatchStrategy {
    private final SettingsRepository repository;

    public SettingsEntity apply(SettingsEntityDto dto) {
        log.info("{}.  {}", this.getClass().getName(), dto);
        if ("email".equalsIgnoreCase(dto.getName()) && StringUtils.isEmpty(dto.getValue()))
            throw new IllegalArgumentException("Email must not be empty");

        SettingsEntity settingsEntity = new SettingsEntity(dto.getName().toUpperCase(), dto.getValue());
        return repository.save(settingsEntity);
    }
}
