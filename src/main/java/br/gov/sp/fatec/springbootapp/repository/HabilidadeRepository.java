package br.gov.sp.fatec.springbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootapp.entity.Habilidade;

public interface HabilidadeRepository extends JpaRepository<Habilidade, Long>{

    public List<Habilidade> findByPersonagensNome(String nome);
    
}
