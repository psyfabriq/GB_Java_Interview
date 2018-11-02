package ru.psyfabriq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.psyfabriq.dto.StudentRequest;
import ru.psyfabriq.dto.StudentResponse;
import ru.psyfabriq.entity.Mark;
import ru.psyfabriq.entity.Student;
import ru.psyfabriq.repository.StudentRepository;


import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student add(Student student) {
        return studentRepository.saveAndFlush(student);
    }

    @Override
    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student getByName(String name) {
        return studentRepository.findByName(name).get();
    }

    @Override
    public Student getByID(Integer id) {
        return studentRepository.getOne(id);
    }

    @Override
    public Student edit(Student student) {
        return studentRepository.saveAndFlush(student);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Boolean existsByName(String name) {
        return studentRepository.existsByName(name);
    }

    @Override
    public Boolean existsByID(Integer id) {
        return studentRepository.existsById(id);
    }

    @Override
    public Optional<Student> convertDtoToEntityRequest(StudentRequest dto) {

        Optional<Student> tmp = studentRepository.findById(dto.getId());
        Student student = tmp.isPresent()?tmp.get():new Student();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());

        Mark mark = student.getMark();
        mark.setValue(dto.getMark());
        mark.setStudent(student);
        student.setMark(mark);

        return Optional.ofNullable(student);
    }

    @Override
    public Optional<StudentRequest> convertEntityToDTORequest(Student entity) {
        StudentRequest articleRequest = new StudentRequest();
        articleRequest.setFirstName(entity.getFirstName());
        articleRequest.setLastName(entity.getLastName());
        articleRequest.setMark(entity.getMark().getValue());
        articleRequest.setId(entity.getId());
        return Optional.ofNullable(articleRequest);
    }

    @Override
    public Optional<Student> convertDtoToEntityResponse(StudentResponse dto) {
        Student student = studentRepository.findById(dto.getId()).get();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());

        Mark mark = student.getMark();
        mark.setValue(dto.getMark());
        mark.setStudent(student);
        student.setMark(mark);

        return Optional.ofNullable(student);
    }

    @Override
    public Optional<StudentResponse> convertEntityToDTOResponse(Student entity) {
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setFirstName(entity.getFirstName());
        studentResponse.setLastName(entity.getLastName());
        studentResponse.setMark(entity.getMark().getValue());
        studentResponse.setId(entity.getId());
        studentResponse.setCreatedAt(new Date());
        return Optional.ofNullable(studentResponse);
    }

    @Override
    public Page<StudentResponse> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<StudentResponse> list;
        List<Student> students = getAll();
        if (students.size() < startItem) {
            list = Collections.emptyList();
        } else {
            list = new ArrayList<>();
            int toIndex = Math.min(startItem + pageSize, students.size());
            students.subList(startItem, toIndex).forEach((v) -> {
                list.add(convertEntityToDTOResponse(v).get());
            });
        }

        Page<StudentResponse> studentsPage = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), students.size());

        return studentsPage;

    }
}

