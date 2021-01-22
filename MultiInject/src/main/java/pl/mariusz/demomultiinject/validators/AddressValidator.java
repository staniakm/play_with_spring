package pl.mariusz.demomultiinject.validators;

import org.springframework.stereotype.Component;
import pl.mariusz.demomultiinject.entity.Address;
import pl.mariusz.demomultiinject.validators.common.StringValidator;

import static pl.mariusz.demomultiinject.exception.ExceptionProvider.FIELD_REQUIRED;
import static pl.mariusz.demomultiinject.exception.ExceptionProvider.FIELD_TO_LONG;

@Component
public class AddressValidator {
    public void validate(Address address) {

        StringValidator.getInstance()
                .requiredField(address.getStreet(), FIELD_REQUIRED.getMessage("street"))
                .maxLengthValidator(address.getStreet(), 10, FIELD_TO_LONG.getMessage("street"));

        StringValidator.getInstance()
                .maxLengthValidator(address.getCity(), 15, FIELD_REQUIRED.getMessage("street"));
    }
}
