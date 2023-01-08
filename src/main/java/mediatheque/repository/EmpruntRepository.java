package mediatheque.repository;

import mediatheque.entity.Emprunt;
import mediatheque.entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt, Integer> {

    List<Emprunt> findAllByEmail(int id);
    //Emprunt findByEmailAndName_livre(int id, Livre livre);
}
