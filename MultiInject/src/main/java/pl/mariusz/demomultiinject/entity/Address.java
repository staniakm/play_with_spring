package pl.mariusz.demomultiinject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Address {

    private final String street;
    private final String city;
}
