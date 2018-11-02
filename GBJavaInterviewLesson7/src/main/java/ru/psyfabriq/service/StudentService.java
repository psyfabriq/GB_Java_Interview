package ru.psyfabriq.service;


import ru.psyfabriq.dto.StudentRequest;
import ru.psyfabriq.dto.StudentResponse;
import ru.psyfabriq.entity.Student;

import java.util.List;

public interface StudentService extends ExecutestService<Student,StudentRequest,StudentResponse> {
    Student add(Student student);
    void delete(Integer id);
    Student getByName(String name);
    Student getByID(Integer id);
    Student edit(Student student);
    List<Student > getAll();
    Boolean existsByName(String name);
    Boolean existsByID(Integer id);
}

