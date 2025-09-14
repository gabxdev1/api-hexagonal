package br.com.gabxdev.infra.config;

import br.com.gabxdev.application.morador.CreateMoradorService;
import br.com.gabxdev.application.morador.FindMoradorByCpfService;
import br.com.gabxdev.application.morador.FindMoradorByIdService;
import br.com.gabxdev.application.usuario.CreateUsuarioService;
import br.com.gabxdev.application.usuario.FindUsuarioByEmailService;
import br.com.gabxdev.application.visita.FindVisitaByMoradorService;
import br.com.gabxdev.application.visita.FindVisitaByVisitanteAndMoradorService;
import br.com.gabxdev.application.visita.FindVisitaByVisitanteService;
import br.com.gabxdev.application.visita.RegistrarVisitaService;
import br.com.gabxdev.application.visitante.CreateVisitanteService;
import br.com.gabxdev.application.visitante.FindVisitanteByIdService;
import br.com.gabxdev.application.visitante.FindVisitanteByRgService;
import br.com.gabxdev.domain.port.inbound.morador.CreateMoradorUseCase;
import br.com.gabxdev.domain.port.inbound.morador.FindMoradorByCpfUseCase;
import br.com.gabxdev.domain.port.inbound.morador.FindMoradorByIdUseCase;
import br.com.gabxdev.domain.port.inbound.usuario.CreateUsuarioUseCase;
import br.com.gabxdev.domain.port.inbound.usuario.FindUsuarioByEmailUseCase;
import br.com.gabxdev.domain.port.inbound.visita.FindVisitaByMoradorUseCase;
import br.com.gabxdev.domain.port.inbound.visita.FindVisitaByVisitanteAndMoradorUseCase;
import br.com.gabxdev.domain.port.inbound.visita.FindVisitaByVisitanteUseCase;
import br.com.gabxdev.domain.port.inbound.visita.RegistrarVisitaUseCase;
import br.com.gabxdev.domain.port.inbound.visitante.CreateVisitanteUseCase;
import br.com.gabxdev.domain.port.inbound.visitante.FindVisitanteByIdUseCase;
import br.com.gabxdev.domain.port.inbound.visitante.FindVisitanteByRgUseCase;
import br.com.gabxdev.domain.port.outbound.MoradorRepositoryPort;
import br.com.gabxdev.domain.port.outbound.UsuarioRepositoryPort;
import br.com.gabxdev.domain.port.outbound.VisitaRepositoryPort;
import br.com.gabxdev.domain.port.outbound.VisitanteRepositoryPort;
import br.com.gabxdev.domain.service.ValidatorMoradorService;
import br.com.gabxdev.domain.service.ValidatorUsuarioService;
import br.com.gabxdev.domain.service.ValidatorVisitanteService;
import br.com.gabxdev.infra.adapter.MoradorJpaRepositoryAdapter;
import br.com.gabxdev.infra.adapter.UsuarioJpaRepositoryAdapter;
import br.com.gabxdev.infra.adapter.VisitaJpaRepositoryAdapter;
import br.com.gabxdev.infra.adapter.VisitanteJpaRepositoryAdapter;
import br.com.gabxdev.infra.mapper.MoradorOutboundMapper;
import br.com.gabxdev.infra.mapper.UsuarioOutboundMapper;
import br.com.gabxdev.infra.mapper.VisitaOutboundMapper;
import br.com.gabxdev.infra.mapper.VisitanteOutboundMapper;
import br.com.gabxdev.infra.repository.MoradorJpaRepository;
import br.com.gabxdev.infra.repository.UsuarioJpaRepository;
import br.com.gabxdev.infra.repository.VisitaJpaRepository;
import br.com.gabxdev.infra.repository.VisitanteJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    /**
     * Beans resource usuario
     */
    @Bean
    public UsuarioRepositoryPort usuarioRepositoryPort(UsuarioJpaRepository repository,
                                                       UsuarioOutboundMapper mapper) {
        return new UsuarioJpaRepositoryAdapter(repository, mapper);
    }

    @Bean
    public ValidatorUsuarioService validatorUsuarioService() {
        return new ValidatorUsuarioService();
    }

    @Bean
    public CreateUsuarioUseCase createUsuarioUseCase(UsuarioRepositoryPort usuarioRepositoryPort,
                                                     ValidatorUsuarioService validator) {
        return new CreateUsuarioService(usuarioRepositoryPort, validator);
    }

    @Bean
    public FindUsuarioByEmailUseCase findUsuarioByEmailUseCase(UsuarioRepositoryPort usuarioRepositoryPort) {
        return new FindUsuarioByEmailService(usuarioRepositoryPort);
    }
    //-----------------------------------------------------------------------------------------//


    /**
     * Beans resource morador
     */
    @Bean
    public MoradorRepositoryPort moradorRepositoryPort(MoradorJpaRepository repository,
                                                       MoradorOutboundMapper mapper) {
        return new MoradorJpaRepositoryAdapter(repository, mapper);
    }

    @Bean
    public ValidatorMoradorService validatorMoradorService() {
        return new ValidatorMoradorService();
    }

    @Bean
    public CreateMoradorUseCase createMoradorUseCase(MoradorRepositoryPort moradorRepositoryPort,
                                                     ValidatorMoradorService validator) {
        return new CreateMoradorService(validator, moradorRepositoryPort);
    }

    @Bean
    public FindMoradorByCpfUseCase findMoradorByCpfUseCase(MoradorRepositoryPort moradorRepositoryPort) {
        return new FindMoradorByCpfService(moradorRepositoryPort);
    }

    @Bean
    public FindMoradorByIdUseCase findMoradorByIdUseCase(MoradorRepositoryPort moradorRepositoryPort) {
        return new FindMoradorByIdService(moradorRepositoryPort);
    }
    //-----------------------------------------------------------------------------------------//

    /**
     * Beans resource visitante
     */
    @Bean
    public VisitanteRepositoryPort visitanteRepositoryPort(VisitanteJpaRepository repository,
                                                           VisitanteOutboundMapper mapper) {
        return new VisitanteJpaRepositoryAdapter(repository, mapper);
    }

    @Bean
    public ValidatorVisitanteService validatorVisitanteService() {
        return new ValidatorVisitanteService();
    }

    @Bean
    public CreateVisitanteUseCase createVisitanteUseCase(VisitanteRepositoryPort visitanteRepositoryPort,
                                                         ValidatorVisitanteService validator) {
        return new CreateVisitanteService(visitanteRepositoryPort, validator);
    }

    @Bean
    public FindVisitanteByRgUseCase findVisitanteByRgUseCase(VisitanteRepositoryPort visitanteRepositoryPort) {
        return new FindVisitanteByRgService(visitanteRepositoryPort);
    }

    @Bean
    public FindVisitanteByIdUseCase findVisitanteByIdUseCase(VisitanteRepositoryPort visitanteRepositoryPort) {
        return new FindVisitanteByIdService(visitanteRepositoryPort);
    }
    //-----------------------------------------------------------------------------------------//


    /**
     * Beans resource visita
     */
    @Bean
    public VisitaRepositoryPort visitaRepositoryPort(VisitaJpaRepository visitaJpaRepository,
                                                     VisitaOutboundMapper mapper) {
        return new VisitaJpaRepositoryAdapter(visitaJpaRepository, mapper);
    }

    @Bean
    public RegistrarVisitaUseCase registrarVisitaUseCase(VisitaRepositoryPort visitaRepositoryPort,
                                                         FindVisitanteByIdUseCase findVisitanteByIdUseCase,
                                                         FindMoradorByIdUseCase findMoradorByIdUseCase) {
        return new RegistrarVisitaService(visitaRepositoryPort, findMoradorByIdUseCase, findVisitanteByIdUseCase);
    }

    @Bean
    public FindVisitaByMoradorUseCase findVisitaByMoradorUseCase(VisitaRepositoryPort visitaRepositoryPort) {
        return new FindVisitaByMoradorService(visitaRepositoryPort);
    }

    @Bean
    public FindVisitaByVisitanteUseCase findVisitaByVisitanteUseCase(VisitaRepositoryPort visitaRepositoryPort) {
        return new FindVisitaByVisitanteService(visitaRepositoryPort);
    }

    @Bean
    public FindVisitaByVisitanteAndMoradorUseCase findVisitaByVisitanteAndMoradorUseCase(VisitaRepositoryPort visitaRepositoryPort) {
        return new FindVisitaByVisitanteAndMoradorService(visitaRepositoryPort);
    }
    //-----------------------------------------------------------------------------------------//
}
