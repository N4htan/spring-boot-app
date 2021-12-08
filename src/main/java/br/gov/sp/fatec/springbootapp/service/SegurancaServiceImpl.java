package br.gov.sp.fatec.springbootapp.service;

import java.util.HashSet;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.gov.sp.fatec.springbootapp.entity.Autorizacao;
import br.gov.sp.fatec.springbootapp.entity.Usuario;
import br.gov.sp.fatec.springbootapp.entity.Habilidade;
import br.gov.sp.fatec.springbootapp.entity.Personagem;
import br.gov.sp.fatec.springbootapp.repository.AutorizacaoRepository;
import br.gov.sp.fatec.springbootapp.repository.HabilidadeRepository;
import br.gov.sp.fatec.springbootapp.repository.PersonagemRepository;
import br.gov.sp.fatec.springbootapp.repository.UsuarioRepository;

@Service
public class SegurancaServiceImpl implements SegurancaService{

    @Autowired
    PersonagemRepository personagemRepo;

    @Autowired
    HabilidadeRepository habilidadeRepo;

    @Autowired
    UsuarioRepository usuarioRepo;

    @Autowired
    AutorizacaoRepository autorizacaoRepo;

    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Override
    
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
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
        personagem.setHabilidades(new HashSet<Habilidade>());
        personagem.getHabilidades().add(habilidade);
        personagemRepo.save(personagem);

        return personagem;

    }

    @Override
    @PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
    public List<Personagem> buscarTodosPersonagens(){
        return personagemRepo.findAll();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    public Usuario novoUsuario(String nome, String email, String senha, String autorizacao) {
        
        Autorizacao aut = autorizacaoRepo.findByNome(autorizacao);
        if(aut == null) {
            aut = new Autorizacao();
            aut.setNome(autorizacao);
            autorizacaoRepo.save(aut);
        }

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(passwordEncoder.encode(senha));
        usuario.setAutorizacoes(new HashSet<Autorizacao>());
        usuario.getAutorizacoes().add(aut);
        usuarioRepo.save(usuario);

        return usuario;
    }

    @Override
    @PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
    public List<Usuario> buscarTodosUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepo.findByNome(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário " + username + " não encontrado!");
        }
        return User.builder().username(username).password(usuario.getSenha())
            .authorities(usuario.getAutorizacoes().stream()
                .map(Autorizacao::getNome).collect(Collectors.toList())
                .toArray(new String[usuario.getAutorizacoes().size()]))
            .build();
    }
    
}
