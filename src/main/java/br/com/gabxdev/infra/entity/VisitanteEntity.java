package br.com.gabxdev.infra.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_visitante")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class VisitanteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rg;

    @OneToOne(cascade = CascadeType.ALL)
    private PessoaEntity pessoa;
}
