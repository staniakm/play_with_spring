package pl.mariusz.demoannoatation.model;

import lombok.Getter;
import lombok.Value;
import org.apache.tomcat.jni.Address;
import pl.mariusz.demoannoatation.annotation.AddressConstraint;

@Value
@Getter
public class UserDto {

    String name;
    String surname;
    @AddressConstraint
    AddressDto address;
}
