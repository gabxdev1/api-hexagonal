package br.com.gabxdev.api.controller;

import br.com.gabxdev.api.dto.request.VisitaPostRequest;
import br.com.gabxdev.api.dto.response.VisitaGetRespose;
import br.com.gabxdev.api.dto.response.VisitaPostRespose;
import br.com.gabxdev.api.mapper.VisitaInboundMapper;
import br.com.gabxdev.domain.port.inbound.visita.FindVisitaByMoradorUseCase;
import br.com.gabxdev.domain.port.inbound.visita.FindVisitaByVisitanteAndMoradorUseCase;
import br.com.gabxdev.domain.port.inbound.visita.FindVisitaByVisitanteUseCase;
import br.com.gabxdev.domain.port.inbound.visita.RegistrarVisitaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitas")
@RequiredArgsConstructor
class VisitaController {
    private final RegistrarVisitaUseCase registrarVisitar;

    private final FindVisitaByMoradorUseCase findVisitaByMorador;

    private final FindVisitaByVisitanteUseCase findVisitaByVisitante;

    private final FindVisitaByVisitanteAndMoradorUseCase findVisitaByVisitanteAndMorador;

    private final VisitaInboundMapper mapper;

    @PostMapping
    public ResponseEntity<VisitaPostRespose> registrar(@RequestBody VisitaPostRequest request) {
        var savedVisita = registrarVisitar.execute(request.visitanteId(), request.moradorId());

        var visitantePostResponse = mapper.toVisitaPostResponse(savedVisita);

        return ResponseEntity.status(HttpStatus.CREATED).body(visitantePostResponse);
    }

    @GetMapping("/moradores/{moradorId}")
    public ResponseEntity<List<VisitaGetRespose>> listAllByMorador(@PathVariable Long moradorId) {
        var visitas = findVisitaByMorador.execute(moradorId);

        return ResponseEntity.ok(mapper.toVisitaGetResponse(visitas));
    }

    @GetMapping("/visitantes/{visitanteId}")
    public ResponseEntity<List<VisitaGetRespose>> listAllByVisitante(@PathVariable Long visitanteId) {
        var visitas = findVisitaByVisitante.execute(visitanteId);

        return ResponseEntity.ok(mapper.toVisitaGetResponse(visitas));
    }

    @GetMapping("/moradores/{moradorId}/visitantes/{visitanteId}")
    public ResponseEntity<List<VisitaGetRespose>> listAllByVisitanteAndMorador(@PathVariable Long moradorId,
                                                                               @PathVariable Long visitanteId) {
        var visitas = findVisitaByVisitanteAndMorador.execute(visitanteId, moradorId);

        return ResponseEntity.ok(mapper.toVisitaGetResponse(visitas));
    }
}
