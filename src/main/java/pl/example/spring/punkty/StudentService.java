package pl.example.spring.punkty;

import io.vavr.collection.List;
import org.springframework.stereotype.Service;
import pl.example.spring.punkty.db.ScoreRepository;
import pl.example.spring.punkty.db.StudentRepository;
import pl.example.spring.punkty.db.StudentRow;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final ScoreRepository scoreRepository;

    public StudentService(StudentRepository studentRepository, ScoreRepository scoreRepository)
    {
        this.studentRepository = studentRepository;
        this.scoreRepository = scoreRepository;
    }

    List<Student> getStudents(){
        return List.ofAll(this.studentRepository.findAll()).map(StudentRow::toStudent);
    }

    Student addStudent(final NewStudent newStudent) {
        return this.studentRepository.save(new StudentRow( newStudent.name, newStudent.number, newStudent.grupa)).toStudent();
    }

    @Transactional
    public Optional<Student> changeNumber(long studentId, String newNumber) {
        final Optional<StudentRow> student = this.studentRepository.findById(studentId);
        return student.map(c -> { c.setNumber(newNumber); return c.toStudent(); });
    }

    public int addScore(long id, Score score) {
    }
}
