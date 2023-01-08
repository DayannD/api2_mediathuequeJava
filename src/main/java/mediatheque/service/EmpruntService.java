package mediatheque.service;

import mediatheque.entity.Emprunt;
import mediatheque.entity.Livre;
import mediatheque.entity.User;
import mediatheque.repository.EmpruntRepository;
import mediatheque.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Service
public class EmpruntService {

    @Autowired
    private LivreRepository livreRepository;
    @Autowired
    private EmpruntRepository empruntRepository;
    
    @Autowired
    private LivreService livreService;

    public void create(Livre livre, User user){
        Emprunt emprunt = new Emprunt();

        livre.setDispo(false);

        emprunt.builder()
                .id(user.getId())
                .name_livre(livre)
                .isLoan(true)
                .build();

        empruntRepository.save(emprunt);
    }

    public List<Emprunt> getEmprunt(int id){
        return empruntRepository.findAllByEmail(id);
    }

   public void rendering(Livre livre,User user){
/*        Emprunt emprunt = empruntRepository
                                .findByEmailAndName_livre(
                                        user.getId(),livre
                                        );

        emprunt.setRenderingAt(LocalDate.now());
        emprunt.setRendering(true);
        emprunt.setLoan(false);
        // TODO: 07/01/2023 à modifier avec une table nomber livre
        livre.setNumberExamp(livre.getNumberExamp() + 1);
        empruntRepository.save(emprunt);*/
    }
}
