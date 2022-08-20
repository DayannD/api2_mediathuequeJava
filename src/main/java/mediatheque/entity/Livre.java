package mediatheque.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.File;
import java.util.Date;

@Getter @Setter @NoArgsConstructor
@Entity
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    private Date date_parution;

    private String description;

    private String file;

    private File imageFile;

    private boolean dispo;

    private String genre;

    private String auteur;

    private int numberExamp;

    public boolean getDispo(){
        return this.dispo;
    }

}
