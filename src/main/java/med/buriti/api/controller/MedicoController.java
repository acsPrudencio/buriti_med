package med.buriti.api.controller;

import jakarta.transaction.Transactional;
import med.buriti.api.Repository.MedicoRepository;
import med.buriti.api.domain.medico.DadosAtualizacaoMedicoDto;
import med.buriti.api.domain.medico.DadosCadastroMedicoDto;
import med.buriti.api.domain.medico.DadosListagemMedico;
import med.buriti.api.domain.medico.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping
    public Page<DadosListagemMedico> listarMedicos(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao){
        return medicoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PostMapping
    @Transactional
    public Medico cadastrar(@RequestBody DadosCadastroMedicoDto dados){
        return medicoRepository.save(new Medico(dados));
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosAtualizacaoMedicoDto dados){
        Medico medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
    }
}
