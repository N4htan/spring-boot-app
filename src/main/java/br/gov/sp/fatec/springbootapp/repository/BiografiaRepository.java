package br.gov.sp.fatec.springbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootapp.entity.Biografia;

public interface BiografiaRepository extends JpaRepository<Biografia, Long>{

    public List<Biografia> findByJogadorNome(String nome);
    
}
