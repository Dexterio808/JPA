package nl.belastingdienst.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Builder @NoArgsConstructor @AllArgsConstructor // lombok
@Entity
public class Person {
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

}
