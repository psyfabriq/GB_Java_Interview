package ru.psyfabriq.util;

import com.github.javafaker.Faker;
import ru.psyfabriq.entity.Mark;
import ru.psyfabriq.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratorEntity {

    public static Student getFakeStudent(){
        Faker faker = new Faker();
        Student student = Student.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .build();
        Mark mark = Mark.builder()
                .student(student)
                .value(getFakeMark(1,5))
                .build();
        student.setMark(mark);
        return student;
    }

    private static int getFakeMark(int begin, int end) {
        if (begin >= end) {
            throw new IllegalArgumentException("not correct");
        }
        Random r = new Random();
        return r.nextInt((end - begin) + 1) + end;
    }
}
