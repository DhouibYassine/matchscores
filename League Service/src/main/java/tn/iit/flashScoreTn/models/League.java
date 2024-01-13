package tn.iit.flashScoreTn.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_league")
public class League implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "leagueName")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "league", cascade = CascadeType.ALL)
    private List<Season> season ;

}

