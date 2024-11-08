package DesenvolvimentoAPIConsulta.MedicalConsulta.consulta.service;


import DesenvolvimentoAPIConsulta.MedicalConsulta.consulta.domain.Consulta;
import DesenvolvimentoAPIConsulta.MedicalConsulta.consulta.repositories.ConsultaRepository;
import DesenvolvimentoAPIConsulta.MedicalConsulta.exceptions.ExceptionDataIntegrityViolation;
import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ConsultaService {


    private ConsultaRepository consultaRepository;


    public Consulta cadastrarConsulta(Consulta consulta){
        consulta.setIdConsulta(null);
        return consultaRepository.save(consulta);
    }

    public List<Consulta> listarConsultas() {
        return consultaRepository.findAll();
    }

    public Consulta buscarConsulta(Long id) {
        Optional<Consulta> consulta = consultaRepository.findById((id));
        return consulta.orElseThrow(() -> new ObjectNotFoundException("Consulta não encontrado! ID: ", id));
    }

    public void deletarConsulta(Long id){
        buscarConsulta(id);
        try{
            consultaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new ExceptionDataIntegrityViolation("Não é possível excluir, porque há entidades relacionadas.") ;
        }
    }

    public Consulta atualizarConsulta(Consulta consulta) {
        Consulta novaConsulta = buscarConsulta(consulta.getIdConsulta());
        updateData(novaConsulta, consulta);
        return consultaRepository.save(novaConsulta);
    }

    private void updateData(Consulta novaConsulta, Consulta consulta){
        novaConsulta.setProfissional(consulta.getProfissional());
        novaConsulta.setEspecialidade(consulta.getEspecialidade());
    }
}

