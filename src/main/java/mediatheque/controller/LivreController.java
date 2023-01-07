package mediatheque.controller;

import mediatheque.entity.Livre;
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

    @GetMapping("/")
    public List<Livre> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Livre getOneById(@PathVariable int id){
        return service.getOneById(id);
    }
    // TODO: 16/08/2022 A faire la méthode search 


    @PutMapping("/delete/{id}")
    public Livre deleteOneBook(@PathVariable int id) throws Exception {
        Livre livre = service.getOneById(id);
        livre.setNumberExamp(livre.getNumberExamp()-1);
        return service.deleteOneBook(livre);
    }
}
