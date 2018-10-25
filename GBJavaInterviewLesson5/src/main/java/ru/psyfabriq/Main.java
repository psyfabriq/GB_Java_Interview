package ru.psyfabriq;

import ru.psyfabriq.dao.StudentDAO;
import ru.psyfabriq.dao.StudentDAOImpl;
import ru.psyfabriq.entity.Student;
import ru.psyfabriq.util.GeneratorEntity;

import java.util.List;

public class Main {
    private static StudentDAO studentDAO = new StudentDAOImpl();

    public static void main(String[] args) {
        generateData();
        showAll();
        studentTester(1);
    }

    private static void generateData() {
        System.out.println("#################################################### Generate 1000 Students");
        for (int i = 0; i < 1000; i++) {
            Student student = GeneratorEntity.getFakeStudent();
            studentDAO.persist(student);

        }

    }

    private static void showAll() {
        System.out.println("#################################################### Show All ");
        List<Student> students = studentDAO.findAll();
        students.forEach(student -> {
            System.out.println(student);
        });
        System.out.println("Students size :" + students.size());
    }

    private static void studentTester(int i) {
        studentDAO.findById(i).ifPresent(o -> {
            Student student = (Student) o;
            System.out.println("#################################################### Find Student");
            System.out.println(student.toString());
            System.out.println("#################################################### Update Student ");
            student.setFirstName("TESTER");
            student.setLastName("TESTER");
            studentDAO.update(student);
            studentDAO.findById(i).ifPresent(o1 -> {
                System.out.println(o1.toString());
            });
            System.out.println("#################################################### Delete Student ");
            studentDAO.delete(student);
            if (!studentDAO.findById(i).isPresent()) {
                System.out.println("Delete success");
            }

        });
    }
}
