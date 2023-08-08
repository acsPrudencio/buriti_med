package med.buriti.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.buriti.api.domain.medico.dto.DadosAtualizacaoMedico;
import med.buriti.api.domain.medico.dto.DadosCadastroMedico;
import med.buriti.api.domain.medico.dto.DadosDetalhamentoMedico;
import med.buriti.api.domain.medico.dto.DadosListagemMedico;
import med.buriti.api.service.medico.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService service;

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listarMedicos(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao){
        return ResponseEntity.ok(service.listarMedicos(paginacao));
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriBuilder) {
        DadosDetalhamentoMedico medico = service.cadastrar(dados);
        URI uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.id()).toUri();
        return ResponseEntity.created(uri).body(medico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        DadosDetalhamentoMedico medico = service.atualizar(dados);
        return ResponseEntity.ok(medico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir (@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity detalhar (@PathVariable Long id) {
        DadosDetalhamentoMedico medico = service.detalhar(id);
        return ResponseEntity.ok(medico);
    }
}
