package DesenvolvimentoAPIConsulta.MedicalConsulta.consulta.resources;


import DesenvolvimentoAPIConsulta.MedicalConsulta.consulta.domain.Consulta;
import DesenvolvimentoAPIConsulta.MedicalConsulta.consulta.service.ConsultaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RequestMapping(value = "/consultas")
@RestController
public class ConsultaResource {

    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<Consulta> cadastrarConsulta(@RequestBody Consulta consulta){
        Consulta novaConsulta = consultaService.cadastrarConsulta(consulta);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri().path("/id")
                .buildAndExpand(novaConsulta.getIdConsulta()).toUri();
        return ResponseEntity.created(uri).body(novaConsulta);
    }

    @GetMapping
    public ResponseEntity<List<Consulta>> listarUsuarios(){
        return ResponseEntity.ok().body(consultaService.listarConsultas());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Consulta> buscarConsulta(@PathVariable Long id) {
        Consulta consulta = consultaService.buscarConsulta(id);
        return ResponseEntity.ok().body(consulta);
    }

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<Consulta> atualizarConsulta(@RequestBody Consulta consulta, @PathVariable Long id) {
        consulta.setIdConsulta(id);
        Consulta consultaAtualizada = consultaService.atualizarConsulta(consulta);
        return ResponseEntity.ok().body(consultaAtualizada);
    }



    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarConsulta(@PathVariable Long id) {
        consultaService.deletarConsulta(id);
        return ResponseEntity.noContent().build();
    }

}