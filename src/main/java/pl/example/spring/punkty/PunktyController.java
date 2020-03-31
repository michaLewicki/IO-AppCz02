package pl.example.spring.punkty;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/punkty")
public class PunktyController {

    private List<String> users = new CopyOnWriteArrayList<>();
    {
        users.addAll(Arrays.asList("Jan", "Piotr", "Paweł"));
    }

    @RequestMapping(value = "/users")
    public List<String> getUsers() {
        return users;
    }
}
