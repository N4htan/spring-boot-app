package br.gov.sp.fatec.springbootapp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootapp.entity.Habilidade;
import br.gov.sp.fatec.springbootapp.entity.Personagem;
import br.gov.sp.fatec.springbootapp.repository.HabilidadeRepository;
import br.gov.sp.fatec.springbootapp.repository.PersonagemRepository;

@Service
public class RPGServiceImpl implements RPGService{

    @Autowired
    PersonagemRepository personagemRepo;

    @Autowired
    HabilidadeRepository habilidadeRepo;
    
    @Transactional
    public Personagem novoPersonagem(String nome, int nivel, Date aniversario, String descricao, String nomeHab, String elemento){
        Habilidade habilidade = habilidadeRepo.findByNome(nomeHab);
        if(habilidade == null) {
            habilidade = new Habilidade();
            habilidade.setNome(nomeHab);
            habilidade.setDescricao(descricao);
            habilidade.setElemento(elemento);
            habilidadeRepo.save(habilidade);
        }
        

        Personagem personagem = new Personagem();
        personagem.setNome(nome);
        personagem.setAniversario(aniversario);
        personagem.setNivel(nivel);
        personagemRepo.save(personagem);

        return personagem;

    }

    public List<Personagem> buscarTodosPersonagens(){
        return personagemRepo.findAll();
    }
    
}
