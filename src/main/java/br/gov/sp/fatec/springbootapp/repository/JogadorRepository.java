package br.gov.sp.fatec.springbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootapp.entity.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Long>{

    public Jogador findByNick(String nick);

    public List<Jogador> findByNickContainsOrFuncao(String nick, String funcao);
}