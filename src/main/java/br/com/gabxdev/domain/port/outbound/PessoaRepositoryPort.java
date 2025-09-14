package br.com.gabxdev.domain.port.outbound;

import br.com.gabxdev.domain.model.Pessoa;

public interface PessoaRepositoryPort {
    Pessoa create(Pessoa usuario);
}
