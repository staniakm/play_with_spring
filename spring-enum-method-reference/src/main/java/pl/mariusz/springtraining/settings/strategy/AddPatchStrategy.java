package pl.mariusz.springtraining.settings.strategy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.mariusz.springtraining.settings.repository.SettingsRepository;
import pl.mariusz.springtraining.settings.model.SettingsEntity;
import pl.mariusz.springtraining.settings.model.SettingsEntityDto;

@Slf4j
@Component
@RequiredArgsConstructor
public class AddPatchStrategy {

    private final SettingsRepository repository;

    public SettingsEntity apply(SettingsEntityDto dto) {
        log.info("{}.  {}", this.getClass().getName(), dto);
        return repository.save(new SettingsEntity(dto.getName().toUpperCase(), dto.getValue()));
    }
}
