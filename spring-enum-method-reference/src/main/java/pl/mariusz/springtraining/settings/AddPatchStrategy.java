package pl.mariusz.springtraining.settings;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AddPatchStrategy {

    private final SettingsRepository repository;

    public SettingsEntity apply(SettingsEntityDto dto) {
        log.info("{}.  {}", this.getClass().getName(), dto);
        return repository.save(new SettingsEntity(" " + dto.getName().toUpperCase() + " " + dto.getValue()));
    }
}
