package mediatheque.controller;

import mediatheque.entity.Livre;
import mediatheque.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LivreController {

    boolean submitted = false;
    // TODO: search,deleteOneBook,addOneBook,getAll,getOneById,
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
/*    @GetMapping("/search")
    public Optional<List<Livre>> search(@RequestBody Livre livre){
        if (!submitted){
            
        }
        return service.search(livre);
    }*/

    @PutMapping("/delete/{id}")
    public Livre deleteOneBook(@PathVariable int id) throws Exception {
        Livre livre = service.getOneById(id);
        livre.setNumberExamp(livre.getNumberExamp()-1);
        return service.deleteOneBook(livre);
    }

    @PutMapping("/add/{id}")
    public Livre addOneBook(@PathVariable int id){
        Livre livre = service.getOneById(id);
        livre.setNumberExamp(livre.getNumberExamp()+1);
        return service.addOneBook(livre);
    }


}
