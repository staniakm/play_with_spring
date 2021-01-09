package pl.mariusz.demomultiinject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class CustomSubject implements Subject {
    private final String name;
}
