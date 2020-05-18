package ro.spet.pdg.backend.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @Column(name = "minimum_final_score")
    private BigDecimal minFinalScore;
    @Column(name = "minimum_attendances")
    private int minAttendances;
    private String finalScoreFormula;
}
