package tn.iit.matchService.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString()
@Entity
@Table(name = "t_match")
public class Match implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date date;
	@Column(name="awayTeam")
	private Long awayTeam;
	@Column(name="homeTeam")
	private Long homeTeam;
	@OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Goal> goals;
	private Long refree;

	@ManyToOne
	@JoinColumn(name = "id_stadium")
	private Stadium stadium;
	private int spectator;

	private Long matchDay ;
}
