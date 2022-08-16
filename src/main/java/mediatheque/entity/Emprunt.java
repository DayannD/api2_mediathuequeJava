package mediatheque.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter @NoArgsConstructor @Entity
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date date_emprunt;

    @ManyToOne
    @JoinColumn(name = "email_id")
    private User email;

    @ManyToOne
    @JoinColumn(name = "name_livre_id")
    private Livre name_livre;

    private boolean isLoan = false;

    private Date renderingAt;

    private Date loanAt;

    private boolean isRendering;
}
