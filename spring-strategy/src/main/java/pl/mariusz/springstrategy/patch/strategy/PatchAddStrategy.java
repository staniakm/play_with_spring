package pl.mariusz.springstrategy.patch.strategy;

import org.springframework.stereotype.Component;
import pl.mariusz.springstrategy.domain.OpertationType;
import pl.mariusz.springstrategy.domain.Subject;
import pl.mariusz.springstrategy.dto.PatchParametersDto;

@Component
public class PatchAddStrategy implements PatchStrategy {
    @Override
    public OpertationType patchType() {
        return OpertationType.ADD;
    }

    @Override
    public Subject patch(Subject in, PatchParametersDto patchParameters) {

        if ("email".equalsIgnoreCase(patchParameters.getPath())) {
            if (patchParameters.getValue() == null || patchParameters.getValue().trim().length() == 0)
                throw new IllegalArgumentException("Email must not be empty");

            in.setEmail(patchParameters.getValue());
        }


        return in;
    }
}
