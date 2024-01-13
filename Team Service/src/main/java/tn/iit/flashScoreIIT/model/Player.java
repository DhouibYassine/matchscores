package tn.iit.flashScoreIIT.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
@Entity
@Table(name = "t_player")
public class Player extends Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Long id;
    private String position;
    private String nationality;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonIgnore // Ignore team during serialization to break the circular reference
    private Team team;

    // Constructors, getters, and setters
}

