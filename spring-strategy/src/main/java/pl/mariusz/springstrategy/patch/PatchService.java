package pl.mariusz.springstrategy.patch;

import org.springframework.stereotype.Component;
import pl.mariusz.springstrategy.domain.OpertationType;
import pl.mariusz.springstrategy.domain.Subject;
import pl.mariusz.springstrategy.dto.PatchParametersDto;
import pl.mariusz.springstrategy.patch.strategy.PatchStrategy;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

@Component
public class PatchService {

    private final Map<OpertationType, PatchStrategy> patchStrategyMap;

    public PatchService(List<PatchStrategy> patchStrategyList) {
        patchStrategyMap = patchStrategyList.stream()
                .collect(toMap(PatchStrategy::patchType, Function.identity()));
    }


    public Subject patch(Subject subject, PatchParametersDto patchParametersDto) {
        if (!patchStrategyMap.containsKey(patchParametersDto.getOpertationType()))
            throw new IllegalArgumentException("Invalid operation type");

        return patchStrategyMap.get(patchParametersDto.getOpertationType())
                .patch(subject, patchParametersDto);
    }
}
