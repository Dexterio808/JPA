package nl.belastingdienst.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Builder @NoArgsConstructor @AllArgsConstructor // lombok
@Entity
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
