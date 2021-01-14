package pl.mariusz.springtraining.settings;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class DeletePatchStrategy {
    private final SettingsRepository repository;

    public SettingsEntity apply(SettingsEntityDto dto) {
        log.info("{}.  {}", this.getClass().getName(), dto);
        if ("email".equalsIgnoreCase(dto.getName()))
            throw new IllegalArgumentException("Email must not be deleted");
        return repository.delete(new SettingsEntity(dto.getOperationType() + " " + dto.getName().toUpperCase()));
    }
}
