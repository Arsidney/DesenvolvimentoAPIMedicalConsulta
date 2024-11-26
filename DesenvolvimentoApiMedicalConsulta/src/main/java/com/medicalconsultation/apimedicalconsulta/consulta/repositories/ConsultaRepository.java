package com.medicalconsultation.apimedicalconsulta.consulta.repositories;

import com.medicalconsultation.apimedicalconsulta.consulta.domain.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta,Long> {
}