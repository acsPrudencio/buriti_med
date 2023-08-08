package med.buriti.api.controller;

import jakarta.transaction.Transactional;
import med.buriti.api.domain.medico.dto.DadosAtualizacaoMedico;
import med.buriti.api.domain.paciente.dto.DadosCadastroPaciente;
import med.buriti.api.domain.paciente.dto.DadosDetalhamentoPaciente;
import med.buriti.api.domain.paciente.dto.DadosListagemPaciente;
import med.buriti.api.service.paciente.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteService service;
    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listarMedicos(@PageableDefault(size = 10, sort = {"nome"}, direction = Sort.Direction.ASC) Pageable paginacao){
        return ResponseEntity.ok(service.listarMedicos(paginacao));
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody DadosCadastroPaciente dados, UriComponentsBuilder uriBuilder){
        DadosDetalhamentoPaciente paciente = service.cadastrar(dados);
        URI uri = uriBuilder.path("/paciente/{id}").buildAndExpand(paciente.id()).toUri();
        return ResponseEntity.created(uri).body(paciente);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody DadosAtualizacaoMedico dados){
        return ResponseEntity.ok(service.atualizar(dados));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar (@PathVariable Long id) {
        return ResponseEntity.ok(service.detalhar(id));
    }
}
