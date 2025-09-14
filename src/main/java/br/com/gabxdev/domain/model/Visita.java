package br.com.gabxdev.domain.model;

import java.time.LocalDateTime;

public class Visita {

    private Long id;

    private LocalDateTime dataVisita;

    private Visitante visitante;

    private Morador morador;

    public Visita() {
    }

    public Visita(Long id, LocalDateTime dataVisita, Visitante visitante, Morador morador) {
        this.id = id;
        this.dataVisita = dataVisita;
        this.visitante = visitante;
        this.morador = morador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataVisita() {
        return dataVisita;
    }

    public void setDataVisita(LocalDateTime dataVisita) {
        this.dataVisita = dataVisita;
    }

    public Visitante getVisitante() {
        return visitante;
    }

    public void setVisitante(Visitante visitante) {
        this.visitante = visitante;
    }

    public Morador getMorador() {
        return morador;
    }

    public void setMorador(Morador morador) {
        this.morador = morador;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Visita visita = (Visita) o;
        return id.equals(visita.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
