package pl.mariusz.demomultiinject.validators;

import org.springframework.stereotype.Component;
import pl.mariusz.demomultiinject.entity.Address;

@Component
public class AddressValidator {
    public void validate(Address address) {



        StringValidator.requiredField("street", address.getStreet());
        StringValidator.maxLengthValidator("street", address.getStreet(), 10);

        StringValidator.maxLengthValidator("city", address.getCity(), 15);
    }
}
