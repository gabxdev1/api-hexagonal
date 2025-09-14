package br.com.gabxdev.api.controller;

import br.com.gabxdev.api.dto.request.UsuarioPostRequest;
import br.com.gabxdev.api.dto.response.UsuarioGetResponse;
import br.com.gabxdev.api.dto.response.UsuarioPostResponse;
import br.com.gabxdev.api.mapper.UsuarioInboundMapper;
import br.com.gabxdev.domain.port.inbound.usuario.CreateUsuarioUseCase;
import br.com.gabxdev.domain.port.inbound.usuario.FindUsuarioByEmailUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final CreateUsuarioUseCase create;

    private final FindUsuarioByEmailUseCase findByEmail;

    private final UsuarioInboundMapper mapper;

    @PostMapping
    public ResponseEntity<UsuarioPostResponse> create(@RequestBody UsuarioPostRequest request) {
        var usuarioToSave = mapper.toUsuario(request);

        var savedUsuario = create.execute(usuarioToSave);

        var usuarioPostResponse = mapper.toUsuarioPostResponse(savedUsuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioPostResponse);
    }

    @GetMapping
    public ResponseEntity<UsuarioGetResponse> findByEmail(@RequestParam String email) {
        var foundUsuario = findByEmail.execute(email);

        var usuarioGetResponse = mapper.toUsuarioGetResponse(foundUsuario);

        return ResponseEntity.ok(usuarioGetResponse);
    }
}
