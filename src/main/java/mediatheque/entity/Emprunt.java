package mediatheque.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Getter @Setter @NoArgsConstructor @Entity @AllArgsConstructor @Builder
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "email_id")
    private User email;

    @ManyToOne
    @JoinColumn(name = "name_livre_id")
    private Livre name_livre;

    private boolean isLoan = false;

    @Column(nullable = true)
    private LocalDate renderingAt;

    @CreatedDate()
    private Instant loanAt;

    private boolean isRendering = false;
}
