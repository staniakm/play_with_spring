package pl.mariusz.demomultiinject.entity;

import lombok.*;

@Getter
@Value
@ToString
public class PersonSubject implements Subject {
    private String name;
    private String surname;
    private Address address;
}
