package tn.iit.flashScoreIIT.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.ToString.Exclude;

import java.io.Serializable;
import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
@Entity
@Table(name = "t_team")
public class Team implements Serializable {
    private static final long serialVersionUID = 1L;

    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Player> players;

    @Exclude
    @OneToOne(mappedBy = "team")
    private Coach coach;

    public Team(String name) {
        super();
        this.name = name;
    }

    // Constructors, getters, and setters
}

