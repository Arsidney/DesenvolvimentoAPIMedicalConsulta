package DesenvolvimentoAPIConsulta.MedicalConsulta.usuario;


import DesenvolvimentoAPIConsulta.MedicalConsulta.usuario.domain.Usuario;
import DesenvolvimentoAPIConsulta.MedicalConsulta.usuario.repositories.UsuarioRepository;
import com.google.common.base.Verify;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {
    @InjectMocks
    private  UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Test
    void cadastrarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario("Pedro");
        // configuração do comportamento do Mock
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        // A execução do metodo a ser testado
        var resulto = usuarioService.cadastrarUsuario(usuario);

        //Validação do Teste
        assertNotNull(usuario);
        assertEquals("Arsidney", resulto.getNomeUsuario());

        verify(usuarioRepository, times(1)).save(usuario);

    }

    @Test
    void listarUsuarios(){
        // Criando o objeto Usuarios
        Usuario usuario1 = new Usuario();
        usuario1.setNomeUsuario("Arthur");
        Usuario usuario2 = new Usuario();
        usuario2.setNomeUsuario("Gabriel");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);

        // configuração do comportamento do Mock
        when(usuarioRepository.findAll()).thenReturn(usuarios);


        // A execução do metodo a ser testado
        var resultado = usuarioService.listarUsuarios();



        //Validação do Teste
        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("Arthur", resultado.get(0).getNomeUsuario(), "O nome do usuario 1 esta incorreto");
        assertEquals("Gabriel", resultado.get(1).getNomeUsuario(), "O nome do usuario 2 esta incorreto");
    }

}