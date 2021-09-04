package br.gov.sp.fatec.springbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootapp.entity.Personagem;

public interface PersonagemRepository extends JpaRepository<Personagem, Long>{

    public Personagem findByNome(String nome);

    public List<Personagem> findByNomeContainsOrNivel(String nome, Integer nivel);

    public List<Personagem> findByHabilidadesElemento(String elemento);
}