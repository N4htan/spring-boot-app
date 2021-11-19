package br.gov.sp.fatec.springbootapp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springbootapp.entity.Personagem;
import br.gov.sp.fatec.springbootapp.service.SegurancaService;

@RestController
@CrossOrigin
@RequestMapping(value = "/personagem")
public class PersonagemController {
    
    @Autowired
    private SegurancaService segurancaService;

    @GetMapping
    @JsonView(View.PersonagemSimplificado.class)
    public List<Personagem> buscarTodosPersonagens() {
        return segurancaService.buscarTodosPersonagens();        
    }

    @PostMapping
    @JsonView(View.PersonagemCompleto.class)
    public Personagem novoPersonagem(@RequestBody Personagem personagem) throws ParseException{
        return segurancaService.novoPersonagem(personagem.getNome(), personagem.getNivel(), new SimpleDateFormat("dd/MM/yyyy").parse("12/16/2015"), "HABILIDADE PADRAO", "PADRAO", "PADRAO");
    }
}
