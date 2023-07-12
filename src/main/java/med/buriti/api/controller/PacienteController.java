package med.buriti.api.controller;

import jakarta.transaction.Transactional;
import med.buriti.api.Repository.MedicoRepository;
import med.buriti.api.Repository.PacienteRepository;
import med.buriti.api.domain.medico.DadosAtualizacaoMedicoDto;
import med.buriti.api.domain.medico.DadosCadastroMedicoDto;
import med.buriti.api.domain.medico.DadosListagemMedico;
import med.buriti.api.domain.medico.Medico;
import med.buriti.api.domain.paciente.DadosAtualizacaoPacienteDto;
import med.buriti.api.domain.paciente.DadosCadastroPacienteDto;
import med.buriti.api.domain.paciente.DadosListagemPaciente;
import med.buriti.api.domain.paciente.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public Page<DadosListagemPaciente> listarMedicos(@PageableDefault(size = 10, sort = {"nome"}, direction = Sort.Direction.ASC) Pageable paginacao){
        return pacienteRepository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
    }

    @PostMapping
    @Transactional
    public Paciente cadastrar(@RequestBody DadosCadastroPacienteDto dados){
        return pacienteRepository.save(new Paciente(dados));
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosAtualizacaoMedicoDto dados){
        Paciente paciente = pacienteRepository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.excluir();
    }
}
