package tn.iit.flashScoreIIT.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
@Entity
@Table(name = "t_refree")
public class Refree extends Person implements Serializable{
    private static final long serialVersionUID = 1L;
    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "refree_id")
    private Long id;
}



