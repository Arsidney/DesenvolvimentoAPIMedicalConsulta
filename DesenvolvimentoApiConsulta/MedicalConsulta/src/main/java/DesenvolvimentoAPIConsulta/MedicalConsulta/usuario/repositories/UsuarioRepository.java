package DesenvolvimentoAPIConsulta.MedicalConsulta.usuario.repositories;

import DesenvolvimentoAPIConsulta.MedicalConsulta.usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Object findByNomeUsuario(String nome);
}

