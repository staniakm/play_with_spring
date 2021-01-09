package pl.mariusz.demomultiinject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddressDto {

    private final String street;
    private final String city;
}
