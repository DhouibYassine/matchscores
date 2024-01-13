package tn.iit.flashScoreIIT.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@MappedSuperclass
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
}
