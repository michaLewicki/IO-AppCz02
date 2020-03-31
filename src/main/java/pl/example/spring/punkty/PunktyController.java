package pl.example.spring.punkty;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<String> getUsers() {
        return users;
    }

    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public int addUsers(@RequestBody String name) {
        users.add(name);
        return users.size();
    }
}
