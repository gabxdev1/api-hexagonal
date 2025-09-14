package br.com.gabxdev.api.controller;

import br.com.gabxdev.api.dto.request.VisitantePostRequest;
import br.com.gabxdev.api.dto.response.VisitanteGetResponse;
import br.com.gabxdev.api.dto.response.VisitantePostResponse;
import br.com.gabxdev.api.mapper.VisitanteInboundMapper;
import br.com.gabxdev.domain.port.inbound.visitante.CreateVisitanteUseCase;
import br.com.gabxdev.domain.port.inbound.visitante.FindVisitanteByRgUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/visitantes")
@RequiredArgsConstructor
public class VisitanteController {

    private final CreateVisitanteUseCase create;

    private final FindVisitanteByRgUseCase findByRg;

    private final VisitanteInboundMapper mapper;

    @PostMapping
    public ResponseEntity<VisitantePostResponse> create(@RequestBody VisitantePostRequest request) {
        var visitanteToSave = mapper.toVisitante(request);

        var savedVisitante = create.execute(visitanteToSave);

        var visitantePostResponse = mapper.toVisitantePostResponse(savedVisitante);

        return ResponseEntity.status(HttpStatus.CREATED).body(visitantePostResponse);
    }

    @GetMapping
    public ResponseEntity<VisitanteGetResponse> findByRg(@RequestParam String rg) {
        var foundVisitante = findByRg.execute(rg);

        var visitanteGetResponse = mapper.toVisitanteGetResponse(foundVisitante);

        return ResponseEntity.ok(visitanteGetResponse);
    }
}
