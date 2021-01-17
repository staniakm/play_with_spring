package pl.mariusz.springstrategy.patch.strategy;

import pl.mariusz.springstrategy.domain.OpertationType;
import pl.mariusz.springstrategy.domain.Subject;
import pl.mariusz.springstrategy.dto.PatchParametersDto;

public interface PatchStrategy {
    OpertationType patchType();

    Subject patch(Subject in, PatchParametersDto patchParameters);
}
