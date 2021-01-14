package pl.mariusz.demoannoatation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
@Getter
@AllArgsConstructor
public class AddressDto {

    AddressType type;
    String street;
    String buildingNumber;
    String postCode;
    @NotNull
    String city;
}
