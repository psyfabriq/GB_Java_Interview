package ru.psyfabriq.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class StudentRequest {
    @NotBlank(message = "{error.empty}")
    Integer id;
    @Size(max = 256, min = 3, message = "{error.size}")
    @NotBlank(message = "{error.empty}")
    String firstName;
    @Size(max = 256, min = 3, message = "{error.size}")
    @NotBlank(message = "{error.empty}")
    String lastName;
    @NotBlank(message = "{error.empty}")
    Integer mark;
}

