package pl.example.spring.punkty;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/punkty")
public class PunktyController {
    @RequestMapping(value = "/users")
    public List<String> getUsers() {
        return Arrays.asList("Jan", "Piotr", "Paweł");
    }
}
