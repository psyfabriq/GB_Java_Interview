package ru.psyfabriq.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class StudentResponse {
    Integer id;
    String firstName;
    String lastName;
    Integer mark;
    Date createdAt;
}
