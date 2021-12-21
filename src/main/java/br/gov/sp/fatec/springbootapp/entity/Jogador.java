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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.springbootapp.controller.View;

@Entity
@Table(name = "jog_jogador")
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jog_id")
    @JsonView(View.PersonagemCompleto.class)
    private long id;

    @Column(name = "jog_nome")
    @JsonView(View.PersonagemSimplificado.class)
    private String nome;

    @Column(name = "jog_idade")
    @JsonView(View.PersonagemCompleto.class)
    private int idade;
    
    @Column(name = "jog_funcao")
    @JsonView(View.PersonagemSimplificado.class)
    private String funcao;

    @Column(name = "jog_tempoJogando")
    @JsonView(View.PersonagemSimplificado.class)
    private int tempo;

}