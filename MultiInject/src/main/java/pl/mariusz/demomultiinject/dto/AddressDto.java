package pl.mariusz.demomultiinject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class AddressDto {

    private final String street;
    private final String city;
}
