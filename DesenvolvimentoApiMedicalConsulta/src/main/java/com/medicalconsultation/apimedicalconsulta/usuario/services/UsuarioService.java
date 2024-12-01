package com.medicalconsultation.apimedicalconsulta.usuario.services;

import com.medicalconsultation.apimedicalconsulta.usuario.domain.Permissao;
import com.medicalconsultation.apimedicalconsulta.usuario.domain.Usuario;
import com.medicalconsultation.apimedicalconsulta.usuario.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarUsuario(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado! ID: ", id));
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public void deletarUsuario(Long id){
        Usuario usuario = buscarUsuario(id);
        usuarioRepository.delete(usuario);
    }

    public Usuario atualizarUsuario(Usuario usuario, Long id) {
        Usuario upUsuario = buscarUsuario(id);
        upUsuario.setNomeUsuario(usuario.getNomeUsuario());
        upUsuario.setEmail(usuario.getEmail());
        upUsuario.setTelefone(usuario.getTelefone());
        upUsuario.setDataNascimento(usuario.getDataNascimento());
        upUsuario.setPermissao(usuario.getPermissao());
        return usuarioRepository.save(upUsuario);
    }

    @Transactional
    public Usuario criarUsuario(Usuario usuario) {
        // Garantir que o nome seja apenas o primeiro nome
        String primeiroNome = usuario.getNome().split(" ")[0];
        usuario.setNome(primeiroNome);

        // Configurar permissão como "admin"
        usuario.setPermissao(Permissao.valueOf("admin"));

        return usuarioRepository.save(usuario);
    }
}






