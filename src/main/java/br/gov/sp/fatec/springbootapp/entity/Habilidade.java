package br.gov.sp.fatec.springbootapp.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.springbootapp.controller.View;

@Entity
@Table(name = "hab_habilidade")
public class Habilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hab_id")
    @JsonView(View.PersonagemCompleto.class)
    private Long id;

    @Column(name = "hab_nome")
    @JsonView(View.PersonagemSimplificado.class)
    private String nome;

    @Column(name = "hab_descricao")
    @JsonView(View.PersonagemSimplificado.class)
    private String descricao;

    @Column(name = "hab_elemento")
    @JsonView(View.PersonagemSimplificado.class)
    private String elemento;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "habilidades")
    private Set<Personagem> personagens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public Set<Personagem> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(Set<Personagem> personagens) {
        this.personagens = personagens;
    }

    
}
