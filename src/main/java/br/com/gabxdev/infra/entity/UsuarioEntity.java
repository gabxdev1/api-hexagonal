package br.com.gabxdev.infra.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String senha;

    private Boolean administrador;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private PessoaEntity pessoa;
}
