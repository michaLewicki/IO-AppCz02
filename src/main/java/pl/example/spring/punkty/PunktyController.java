package pl.example.spring.punkty;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping(value = "/punkty")
public class PunktyController {

    private final StudentService service;

    public PunktyController(StudentService service) { this.service = service;}

    @RequestMapping(value = "/students",method = RequestMethod.GET)
    public List<Student> getUsers() {
        return this.service.getStudents().asJava();
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Student addUsers(@RequestBody NewStudent student) {
        return this.service.addStudent(student);
    }
}
