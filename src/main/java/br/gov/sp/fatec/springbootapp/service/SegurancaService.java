package br.gov.sp.fatec.springbootapp.service;

import java.util.Date;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.gov.sp.fatec.springbootapp.entity.Jogador;
import br.gov.sp.fatec.springbootapp.entity.Personagem;
import br.gov.sp.fatec.springbootapp.entity.Usuario;

public interface SegurancaService extends UserDetailsService {
    public Personagem novoPersonagem(String nome, int nivel, Date aniversario, String descricao, String nomeHab, String elemento);

    public List<Personagem> buscarTodosPersonagens();

    public Usuario novoUsuario(String nome, String email, String senha, String autorizacao);
    
    public List<Usuario> buscarTodosUsuarios();

    public Jogador novoJogador(String nome, int idade, String funcao, String nick, String nome_per, int nivel, Date aniversario, String descricao, String nomeHab, String elemento);

    public List<Jogador> buscarTodosJogadores();
}