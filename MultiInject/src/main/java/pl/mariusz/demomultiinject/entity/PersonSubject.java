package pl.mariusz.demomultiinject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class PersonSubject implements Subject {
    private String name;
    private String surname;
    private String address;
}
