package ru.psyfabriq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.psyfabriq.dto.StudentRequest;
import ru.psyfabriq.dto.StudentResponse;
import ru.psyfabriq.entity.Student;
import ru.psyfabriq.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class StudentController extends AbstractController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public String list(Map<String, Object> model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        page.ifPresent(p -> currentPage = p);
        size.ifPresent(s -> pageSize = s);
        Page<StudentResponse> articlePage = studentService.findPaginated(PageRequest.of(currentPage - 1, pageSize));
        model.put("listItems", articlePage);
        int totalPages = articlePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.put("pageNumbers", pageNumbers);
        }
        return "list-students";
    }

    @GetMapping("/students/add")
    public String add(Map<String, Object> model) {
        Student article = new Student();
        model.put("model", studentService.convertEntityToDTORequest(article).get());
        return "student-edit";
    }

    @GetMapping("/student/{id}")
    public String edit(Map<String, Object> model, @PathVariable(value = "id") Integer id) {
        if (!studentService.existsByID(id)) {
            return "";
        }
        Student student = studentService.getByID(id);
        model.put("model", studentService.convertEntityToDTORequest(student).get());
        return "edit-article";
    }

    @PostMapping("/student")
    public String action(HttpServletRequest request, @Valid @ModelAttribute StudentRequest obj) {
        Student student = studentService.convertDtoToEntityRequest(obj).get();
        studentService.edit(student);
        return "redirect:/students";

    }
}

