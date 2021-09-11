package br.gov.sp.fatec.springbootapp;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import br.gov.sp.fatec.springbootapp.entity.Biografia;
import br.gov.sp.fatec.springbootapp.entity.Habilidade;
import br.gov.sp.fatec.springbootapp.entity.Personagem;
import br.gov.sp.fatec.springbootapp.repository.BiografiaRepository;
import br.gov.sp.fatec.springbootapp.repository.HabilidadeRepository;
import br.gov.sp.fatec.springbootapp.repository.PersonagemRepository;

@SpringBootTest
@Transactional
@Rollback
class SpringBootAppApplicationTests {

	@Autowired
	private PersonagemRepository personagemRepo;

	@Autowired
	private HabilidadeRepository habilidadeRepo;

	@Autowired
	private BiografiaRepository biografiaRepo;

	@Test
	void contextLoads() {
	}
	
	@Test
	void findByNomePerTest() throws ParseException{
		Personagem personagem = new Personagem();
		personagem.setNome("Mago");
		personagem.setAniversario(new SimpleDateFormat("dd/MM/yyyy").parse("12/16/2015"));
		personagem.setNivel(1);
		personagemRepo.save(personagem);
		
		assertNotNull(personagemRepo.findByNome("Mago"));
	}

	@Test
	void findByNomeContainsOrNivelContainsPerTest() throws ParseException{
		Personagem personagem = new Personagem();
		personagem.setNome("Mago"); 
		personagem.setAniversario(new SimpleDateFormat("dd/MM/yyyy").parse("12/16/2015"));
		personagem.setNivel(1);
		personagemRepo.save(personagem);
		
		assertFalse(personagemRepo.findByNomeContainsOrNivel("go", 1).isEmpty());
	}

	@Test
	void findByHabilidadesElementoTest() throws ParseException{
		Habilidade habilidade = new Habilidade();
		habilidade.setNome("Fireball");
		habilidade.setDescricao("Uma faixa brilhante passa de seu dedo indicador até um ponto que você escolhe dentro do alcance e então floresce com um rugido baixo em uma explosão de chamas.");
		habilidade.setElemento("Fogo");
		habilidadeRepo.save(habilidade);

		Personagem personagem = new Personagem();
		personagem.setNome("Mago"); 
		personagem.setAniversario(new SimpleDateFormat("dd/MM/yyyy").parse("12/16/2015"));
		personagem.setNivel(1);
		personagem.setHabilidades(new HashSet<Habilidade>());
		personagem.getHabilidades().add(habilidade);
		personagemRepo.save(personagem);
		
		assertFalse(personagemRepo.findByHabilidadesElemento("Fogo").isEmpty());
	}

	@Test
	void findByPersonagensNomeTest() throws ParseException{
		Habilidade habilidade = new Habilidade();
		habilidade.setNome("Fireball");
		habilidade.setDescricao("Uma faixa brilhante passa de seu dedo indicador até um ponto que você escolhe dentro do alcance e então floresce com um rugido baixo em uma explosão de chamas.");
		habilidade.setElemento("Fogo");
		habilidadeRepo.save(habilidade);

		Personagem personagem = new Personagem();
		personagem.setNome("Mago"); 
		personagem.setAniversario(new SimpleDateFormat("dd/MM/yyyy").parse("12/16/2015"));
		personagem.setNivel(1);
		personagem.setHabilidades(new HashSet<Habilidade>());
		personagem.getHabilidades().add(habilidade);
		personagemRepo.save(personagem);
		
		assertFalse(habilidadeRepo.findByPersonagensNome("Mago").isEmpty());
	}

	@Test
	void findByJogadorNomeTest() throws ParseException{
		Habilidade habilidade = new Habilidade();
		habilidade.setNome("Fireball");
		habilidade.setDescricao("Uma faixa brilhante passa de seu dedo indicador até um ponto que você escolhe dentro do alcance e então floresce com um rugido baixo em uma explosão de chamas.");
		habilidade.setElemento("Fogo");
		habilidadeRepo.save(habilidade);

		Personagem personagem = new Personagem();
		personagem.setNome("Mago"); 
		personagem.setAniversario(new SimpleDateFormat("dd/MM/yyyy").parse("12/16/2015"));
		personagem.setNivel(1);
		personagem.setHabilidades(new HashSet<Habilidade>());
		personagem.getHabilidades().add(habilidade);
		personagemRepo.save(personagem);

		Biografia biografia = new Biografia();
		biografia.setDataBio(new SimpleDateFormat("dd/MM/yyyy").parse("12/16/2015"));
		biografia.setEntrada("Uma faixa brilhante passa de seu dedo indicador até um ponto que você escolhe.");
		biografia.setJogador(personagem);
		biografiaRepo.save(biografia);

		assertFalse(biografiaRepo.findByJogadorNome("Mago").isEmpty());
	}

	@Test
	void findBiografiasEntradaTest() throws ParseException{
		Habilidade habilidade = new Habilidade();
		habilidade.setNome("Fireball");
		habilidade.setDescricao("Uma faixa brilhante passa de seu dedo indicador até um ponto que você escolhe dentro do alcance e então floresce com um rugido baixo em uma explosão de chamas.");
		habilidade.setElemento("Fogo");
		habilidadeRepo.save(habilidade);

		Personagem personagem = new Personagem();
		personagem.setNome("Mago"); 
		personagem.setAniversario(new SimpleDateFormat("dd/MM/yyyy").parse("12/16/2015"));
		personagem.setNivel(1);
		personagem.setHabilidades(new HashSet<Habilidade>());
		personagem.getHabilidades().add(habilidade);
		personagemRepo.save(personagem);

		Biografia biografia = new Biografia();
		biografia.setDataBio(new SimpleDateFormat("dd/MM/yyyy").parse("12/16/2015"));
		biografia.setEntrada("Uma faixa brilhante.");
		biografia.setJogador(personagem);
		biografiaRepo.save(biografia);

		assertFalse(personagemRepo.findByBiografiasEntrada("Uma faixa brilhante.").isEmpty());
	}
}
