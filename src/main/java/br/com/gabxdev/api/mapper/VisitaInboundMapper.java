package br.com.gabxdev.api.mapper;

import br.com.gabxdev.api.dto.response.VisitaGetRespose;
import br.com.gabxdev.api.dto.response.VisitaPostRespose;
import br.com.gabxdev.domain.model.Visita;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {
        MoradorInboundMapper.class,
        VisitanteInboundMapper.class
})
public interface VisitaInboundMapper {
    VisitaPostRespose toVisitaPostResponse(Visita visita);

    VisitaGetRespose toVisitaGetResponse(Visita visita);

    List<VisitaGetRespose> toVisitaGetResponse(List<Visita> visitas);
}
