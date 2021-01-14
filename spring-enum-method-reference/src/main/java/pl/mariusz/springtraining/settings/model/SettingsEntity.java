package pl.mariusz.springtraining.settings.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class SettingsEntity {
    private String key;
    private String value;

}

