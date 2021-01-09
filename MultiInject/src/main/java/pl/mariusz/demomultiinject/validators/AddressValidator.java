package pl.mariusz.demomultiinject.validators;

import org.springframework.stereotype.Component;
import pl.mariusz.demomultiinject.entity.Address;
import pl.mariusz.demomultiinject.validators.common.StringValidator;

@Component
public class AddressValidator {
    public void validate(Address address) {


        StringValidator.getInstance()
                .requiredField("street", address.getStreet())
                .maxLengthValidator("street", address.getStreet(), 10);

        StringValidator.getInstance()
                .maxLengthValidator("city", address.getCity(), 15);
    }
}
