package br.gov.sp.fatec.springbootapp;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import br.gov.sp.fatec.springbootapp.entity.Personagem;
import br.gov.sp.fatec.springbootapp.repository.PersonagemRepository;

@SpringBootTest
@Transactional
@Rollback
class SpringBootAppApplicationTests {

	@Autowired
	private PersonagemRepository personagemRepo;

	@Test
	void contextLoads() {
	}
	
	@Test
	void findByNomePerTest() throws ParseException{
		Personagem personagem = new Personagem();
		personagem.setNome("Produto");
		personagem.setAniversario(new SimpleDateFormat("dd/MM/yyyy").parse("12/16/2015"));
		personagem.setNivel(1);
		personagemRepo.save(personagem);
		
		assertNotNull(personagemRepo.findByNome("Produto"));
	}

	@Test
	void findByNomeContainsOrNivelContainsPerTest() throws ParseException{
		Personagem personagem = new Personagem();
		personagem.setNome("Produto2"); 
		personagem.setAniversario(new SimpleDateFormat("dd/MM/yyyy").parse("12/16/2015"));
		personagem.setNivel(1);
		personagemRepo.save(personagem);
		
		assertFalse(personagemRepo.findByNomeContainsOrNivel("pro", 1).isEmpty());
	}
}
