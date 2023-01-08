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
    private LivreRepository livreRepository;

    public List<Livre> getAll(){

        return livreRepository.findAll();
    }

    public Livre getOneById(int id){
        return livreRepository.findById(id).get();
    }

    public Livre deleteOneBook(Livre livre) throws Exception {
        if(livre.getNumberExamp() == 0){
            livre.setDispo(false);
            throw new Exception("Il n'y a plus d'exemplaire de ce livre");
        }
        return livreRepository.save(livre);
    }

    public Livre addOneBook(Livre livre){
        if (livre.isDispo() == false){
            livre.setDispo(true);
        }
        return livreRepository.save(livre);
    }
}
