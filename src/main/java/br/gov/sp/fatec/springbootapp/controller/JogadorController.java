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

import br.gov.sp.fatec.springbootapp.entity.Jogador;
import br.gov.sp.fatec.springbootapp.service.SegurancaService;

@RestController
@CrossOrigin
@RequestMapping(value = "/jogador")
public class JogadorController {
    
    @Autowired
    private SegurancaService segurancaService;

    @GetMapping(value = "/buscar")
    @JsonView(View.JogadorSimplificado.class)
    public List<Jogador> buscarTodosJogadores() {
        return segurancaService.buscarTodosJogadores();        
    }

    @PostMapping(value = "/novo")
    @JsonView(View.JogadorCompleto.class)
    public Jogador novoJogador(@RequestBody Jogador jogador) throws ParseException{
        return segurancaService.novoJogador(jogador.getNome(), jogador.getIdade(), jogador.getFuncao(), jogador.getNick(), "PERSONAGEM", 1, new SimpleDateFormat("dd/MM/yyyy").parse("12/16/2015"), "HABILIDADE PADRAO", "PADRAO", "PADRAO");
    }
}
