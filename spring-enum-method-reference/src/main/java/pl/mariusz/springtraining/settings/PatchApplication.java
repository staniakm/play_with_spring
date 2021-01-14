package pl.mariusz.springtraining.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.mariusz.springtraining.settings.model.OperationType;
import pl.mariusz.springtraining.settings.model.SettingsEntityDto;
import pl.mariusz.springtraining.settings.strategy.PatchStrategy;

@SpringBootApplication
public class PatchApplication implements CommandLineRunner {

    @Autowired
    private PatchStrategy patchStrategy;

    public static void main(String[] args) {
        SpringApplication.run(PatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SettingsEntityDto addEntity = new SettingsEntityDto(OperationType.ADD, "email", "email@eu.pl");
        SettingsEntityDto replaceEntity = new SettingsEntityDto(OperationType.REPLACE, "email", "email@ue.pl");

        System.out.println(patchStrategy.applyPatch(addEntity));
        System.out.println(patchStrategy.applyPatch(replaceEntity));
        System.out.println(patchStrategy.applyPatch(new SettingsEntityDto(OperationType.REPLACE, "email", "")));
        System.out.println(patchStrategy.applyPatch(new SettingsEntityDto(OperationType.DELETE, "email", "")));

    }
}
