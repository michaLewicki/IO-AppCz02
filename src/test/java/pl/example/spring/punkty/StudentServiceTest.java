package pl.example.spring.punkty;

import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    public void getEmptyList() {
        final StudentService service = new StudentService();
        List<Student> students = service.getStudents();
        assertTrue(students.isEmpty());
    }

    @Test
    public void testAddStudent() {
        final StudentService service = new StudentService();
        final Student created=service.addStudent(new NewStudent("Student1","1-2-3","IP"));
        assertNotNull(created);
    }


}