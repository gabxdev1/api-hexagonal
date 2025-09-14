package br.com.gabxdev.api.controller;

import br.com.gabxdev.api.dto.request.MoradorPostRequest;
import br.com.gabxdev.api.dto.response.MoradorGetResponse;
import br.com.gabxdev.api.dto.response.MoradorPostResponse;
import br.com.gabxdev.api.mapper.MoradorInboundMapper;
import br.com.gabxdev.domain.port.inbound.morador.CreateMoradorUseCase;
import br.com.gabxdev.domain.port.inbound.morador.FindMoradorByCpfUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/moradores")
@RequiredArgsConstructor
public class MoradorController {

    private final CreateMoradorUseCase create;

    private final FindMoradorByCpfUseCase findByCpf;

    private final MoradorInboundMapper mapper;

    @PostMapping
    public ResponseEntity<MoradorPostResponse> create(@RequestBody MoradorPostRequest request) {
        var moradorToCreate = mapper.toMorador(request);

        var savedMorador = create.execute(moradorToCreate);

        var moradorPostResponse = mapper.toMoradorPostResponse(savedMorador);

        return ResponseEntity.status(HttpStatus.CREATED).body(moradorPostResponse);
    }

    @GetMapping
    public ResponseEntity<MoradorGetResponse> findByCpf(@RequestParam String cpf) {
        var foundMorador = findByCpf.execute(cpf);

        var moradorGetResponse = mapper.toMoradorGetResponse(foundMorador);

        return ResponseEntity.ok(moradorGetResponse);
    }
}
