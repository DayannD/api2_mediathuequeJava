package mediatheque.controller;

import mediatheque.entity.Emprunt;
import mediatheque.entity.User;
import mediatheque.service.EmpruntService;
import mediatheque.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmpruntService empruntService;

    @GetMapping("/user/{id}")
    public User getOneUser(@PathVariable int id){
        return this.userService.findById(id);
    }

    @GetMapping("/emprunt/{id}")
    public List<Emprunt> getOneEmprunt(@PathVariable int id){
        return empruntService.getEmprunt(id);
    }
}
