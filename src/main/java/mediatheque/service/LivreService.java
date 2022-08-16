package mediatheque.service;

import mediatheque.entity.Livre;
import mediatheque.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivreService {

    @Autowired
    private LivreRepository repository;

    public List<Livre> getAll(){
        return repository.findAll();
    }

    public Livre getOneById(int id){
        return repository.findById(id).get();
    }

/*
    public Optional<List<Livre>> search(Livre livre){
        return Optional.of((List<Livre>) repository.findAll().stream().filter(i -> i == livre));
    }
*/

    public Livre deleteOneBook(Livre livre) throws Exception {
        if(livre.getNumberExamp() == 0){
            throw new Exception("Il n'y a plus d'exemplaire de ce livre");
        }
        return repository.save(livre);
    }

    public Livre addOneBook(Livre livre){
        return repository.save(livre);
    }
}
