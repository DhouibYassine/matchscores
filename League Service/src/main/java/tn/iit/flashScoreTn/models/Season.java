package tn.iit.flashScoreTn.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "t_season")
public class Season implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "season_id")
    private Long id ;

    private Date startingDate ;
    private Date endingDate;

    @JsonIgnore
    @OneToMany(mappedBy = "season" )
    private List<MatchDay> matchDay ;

    @ManyToOne
    @JoinColumn(name = "id_league")
    private  League league;

}
