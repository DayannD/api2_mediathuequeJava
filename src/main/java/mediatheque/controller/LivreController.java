package mediatheque.controller;

import mediatheque.entity.Emprunt;
import mediatheque.entity.Livre;
import mediatheque.entity.User;
import mediatheque.service.EmpruntService;
import mediatheque.service.LivreService;
import mediatheque.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LivreController {
    // TODO: search,deleteOneBook,getAll,getOneById,
    @Autowired
    private LivreService livreService;

    @Autowired
    private UserService userService;
    @Autowired
    private EmpruntService empruntService;

    @GetMapping("/")
    public List<Livre> getAll(){
        return livreService.getAll();
    }

    @GetMapping("/test")
    public String test(){
        System.err.println(livreService.getAll());
        return "ok";
    }

    @GetMapping("/{id}")
    public Livre getOneById(@PathVariable int id){
        return livreService.getOneById(id);
    }
    // TODO: 16/08/2022 A faire la méthode search 


    @PostMapping("/emprunt/{id}/{userid}")
    public void empruntOneBook(@PathVariable int id,@PathVariable int userid) throws Exception {
        Livre livre = livreService.getOneById(id);
        User user = userService.findById(userid);
        livre.setNumberExamp(livre.getNumberExamp()-1);
        empruntService.create(livre,user);
    }
}
