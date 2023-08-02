package med.buriti.api.service.paciente;

import med.buriti.api.domain.medico.DadosAtualizacaoMedico;
import med.buriti.api.domain.paciente.DadosCadastroPaciente;
import med.buriti.api.domain.paciente.DadosDetalhamentoPaciente;
import med.buriti.api.domain.paciente.DadosListagemPaciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PacienteService {
    Page<DadosListagemPaciente> listarMedicos(Pageable paginacao);
    DadosDetalhamentoPaciente cadastrar(DadosCadastroPaciente dados);
    DadosDetalhamentoPaciente atualizar(DadosAtualizacaoMedico dados);
    DadosDetalhamentoPaciente detalhar (Long id);
    void excluir(Long id);
}
