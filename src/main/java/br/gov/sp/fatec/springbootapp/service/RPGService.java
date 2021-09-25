package br.gov.sp.fatec.springbootapp.service;

import java.util.Date;
import java.util.List;

import br.gov.sp.fatec.springbootapp.entity.Personagem;

public interface RPGService {
    public Personagem novoPersonagem(String nome, Date aniversario, int nivel, String descricao, String nomeHab, String elemento);

    public List<Personagem> buscarTodosPersonagens();
}
