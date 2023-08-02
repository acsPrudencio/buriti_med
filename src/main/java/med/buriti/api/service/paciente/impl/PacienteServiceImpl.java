package med.buriti.api.service.paciente.impl;

import jakarta.transaction.Transactional;
import med.buriti.api.Repository.PacienteRepository;
import med.buriti.api.domain.medico.DadosAtualizacaoMedico;
import med.buriti.api.domain.paciente.DadosCadastroPaciente;
import med.buriti.api.domain.paciente.DadosDetalhamentoPaciente;
import med.buriti.api.domain.paciente.DadosListagemPaciente;
import med.buriti.api.domain.paciente.Paciente;
import med.buriti.api.service.paciente.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Page<DadosListagemPaciente> listarMedicos(Pageable paginacao) {
        return pacienteRepository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
    }

    @Override
    public DadosDetalhamentoPaciente cadastrar(DadosCadastroPaciente dados) {
        Paciente paciente = pacienteRepository.save(new Paciente(dados));
        return new DadosDetalhamentoPaciente(paciente);
    }

    @Override
    public DadosDetalhamentoPaciente atualizar(DadosAtualizacaoMedico dados) {
        Paciente paciente = pacienteRepository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
        return new DadosDetalhamentoPaciente(paciente);
    }

    @Override
    public DadosDetalhamentoPaciente detalhar(Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        return new DadosDetalhamentoPaciente(paciente);
    }

    @Override
    public void excluir(Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.excluir();
    }
}
