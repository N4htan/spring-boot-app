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
@Table(name = "jog_jogador")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jog_id")
    @JsonView(View.JogadorCompleto.class)
    private long id;

    @Column(name = "jog_nome")
    @JsonView(View.JogadorSimplificado.class)
    private String nome;

    @Column(name = "jog_idade")
    @JsonView(View.JogadorCompleto.class)
    private int idade;
    
    @Column(name = "jog_funcao")
    @JsonView(View.JogadorSimplificado.class)
    private String funcao;

    @Column(name = "jog_nickname")
    @JsonView(View.JogadorSimplificado.class)
    private String nick;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "jogadores")
    private Set<Personagem> personagens;

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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    
}