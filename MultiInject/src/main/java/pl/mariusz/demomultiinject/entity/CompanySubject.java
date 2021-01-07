package pl.mariusz.demomultiinject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CompanySubject implements Subject {
    private String companyName;
    private String address;
}
