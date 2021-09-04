package br.gov.sp.fatec.springbootapp.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "per_personagem")
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "per_id")
    private long id;

    @Column(name = "per_nome")
    private String nome;

    @Column(name = "per_data_nascimento")
    private Date aniversario;
    
    @Column(name = "per_nivel")
    private int nivel;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "pha_personagem_habilidade",
        joinColumns = { @JoinColumn(name = "per_id") },
        inverseJoinColumns = { @JoinColumn(name = "hab_id") })
    private Set<Habilidade> habilidades;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getAniversario() {
        return aniversario;
    }

    public void setAniversario(Date aniversario) {
        this.aniversario = aniversario;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Set<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(Set<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    
}
