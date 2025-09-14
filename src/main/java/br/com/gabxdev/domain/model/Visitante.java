package br.com.gabxdev.domain.model;

public class Visitante {
    private Long id;
    private String rg;
    private Pessoa pessoa;

    public Visitante() {
    }

    public Visitante(Long id, String rg, Pessoa pessoa) {
        this.id = id;
        this.rg = rg;
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Visitante visitanteEntity = (Visitante) o;
        return id.equals(visitanteEntity.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
