package pl.example.spring.punkty;

import io.vavr.collection.List;

public class StudentService {
    private List<Student> students = List.empty();

    List<Student> getStudents(){
        return List.empty();
    }

    Student addStudent(NewStudent nowyStudent) {
        return new Student(1,"aa","aa","aa");
    }
}
