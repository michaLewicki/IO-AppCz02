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

    @Test
    public void addStudentIsReturned() {
        final StudentService service = new StudentService();
        final Student created = service.addStudent(new NewStudent("Student1", "1-2-3", "IP"));
        final List<Student> all = service.getStudents();
        assertEquals("Student1", all.head().name);
    }

    @Test
    public void addStudentHasNewId() {
        final StudentService service = new StudentService();
        final Student created1 = service.addStudent(new NewStudent("Student1", "1-2-3","IP"));
        final Student created2 = service.addStudent(new NewStudent("Student2", "4-5-6","ZIP"));
        final List<Student> studenci = service.getStudents();
        assertNotEquals(studenci.get(0).id, studenci.get(1).id);
        assertEquals(2,service.getStudents().size());
    }

}