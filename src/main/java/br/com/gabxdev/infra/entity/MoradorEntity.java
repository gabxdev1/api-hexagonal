package br.com.gabxdev.infra.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_morador")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class MoradorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String cpf;

    private String endereco;

    private String celular;

    @OneToOne(cascade = CascadeType.ALL)
    private PessoaEntity pessoa;

}
