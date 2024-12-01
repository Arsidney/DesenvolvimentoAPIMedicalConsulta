package com.medicalconsultation.apimedicalconsulta.usuario.repository;

import com.medicalconsultation.apimedicalconsulta.usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}