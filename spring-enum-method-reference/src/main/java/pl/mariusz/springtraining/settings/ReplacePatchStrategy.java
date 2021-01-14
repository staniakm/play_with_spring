package pl.mariusz.springtraining.settings;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Slf4j
@RequiredArgsConstructor
public class ReplacePatchStrategy {
    private final SettingsRepository repository;

    public SettingsEntity apply(SettingsEntityDto dto) {
        log.info("{}.  {}", this.getClass().getName(), dto);
        if ("email".equalsIgnoreCase(dto.getName()) && StringUtils.isEmpty(dto.getValue()))
            throw new IllegalArgumentException("Email must not be empty");

        SettingsEntity settingsEntity = new SettingsEntity(dto.getOperationType() + " " + dto.getName().toUpperCase() + " " + dto.getValue());
        return repository.save(settingsEntity);
    }
}
