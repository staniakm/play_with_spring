package pl.mariusz.springstrategy.patch.strategy;

import org.springframework.stereotype.Component;
import pl.mariusz.springstrategy.domain.OpertationType;
import pl.mariusz.springstrategy.domain.Subject;
import pl.mariusz.springstrategy.dto.PatchParametersDto;

@Component
public class PatchRemoveStrategy implements PatchStrategy {
    @Override
    public OpertationType patchType() {
        return OpertationType.REMOVE;
    }

    @Override
    public Subject patch(Subject in, PatchParametersDto patchParameters) {

        if ("email".equalsIgnoreCase(patchParameters.getPath())) {
                throw new IllegalArgumentException("Email cannot be deleted");
        }
        return in;
    }
}
