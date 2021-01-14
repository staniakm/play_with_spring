package pl.mariusz.demoannoatation.model;

import lombok.Getter;
import lombok.Value;
import org.apache.tomcat.jni.Address;
import pl.mariusz.demoannoatation.annotation.AddressConstraint;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Value
@Getter
public class UserDto {

    String name;
    String surname;
    @NotNull
    AddressDto address;
}
