package mediatheque.controller;

import mediatheque.entity.Emprunt;
import mediatheque.entity.Livre;
import mediatheque.entity.User;
import mediatheque.service.EmpruntService;
import mediatheque.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LivreController {
    // TODO: search,deleteOneBook,getAll,getOneById,
    @Autowired
    private LivreService service;

    @Autowired
    private EmpruntService empruntService;

    @GetMapping("/")
    public List<Livre> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Livre getOneById(@PathVariable int id){
        return service.getOneById(id);
    }
    // TODO: 16/08/2022 A faire la méthode search 


    @PutMapping("/emprunt/{id}/{userid}")
    public Livre empruntOneBook(@PathVariable int id,@PathVariable int userid) throws Exception {
        Livre livre = service.getOneById(id);
        livre.setNumberExamp(livre.getNumberExamp()-1);
        return empruntService.create(livre);
    }
}
