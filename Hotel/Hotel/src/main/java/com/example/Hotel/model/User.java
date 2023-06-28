package com.example.Hotel.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    public  Long id;
    public  String FirstName;
    public  String MiddleName;
    public  String LastName;
    public  String Email;


}
