package ru.psyfabriq.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.psyfabriq.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByIdIn(List<Integer> studentsIds);
    Optional<Student> findByName(String name);
    Boolean existsByName(String name);
}