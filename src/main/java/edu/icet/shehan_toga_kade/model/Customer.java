package edu.icet.shehan_toga_kade.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    String id;
    String title;
    String name;
    String address;
    String contact;
   LocalDate birthDate;
}
