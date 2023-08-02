package med.buriti.api.service.medico;

import med.buriti.api.domain.medico.DadosAtualizacaoMedico;
import med.buriti.api.domain.medico.DadosCadastroMedico;
import med.buriti.api.domain.medico.DadosDetalhamentoMedico;
import med.buriti.api.domain.medico.DadosListagemMedico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MedicoService {
    Page<DadosListagemMedico> listarMedicos(Pageable paginacao);
    DadosDetalhamentoMedico cadastrar(DadosCadastroMedico dados);
    DadosDetalhamentoMedico atualizar(DadosAtualizacaoMedico dados);
    DadosDetalhamentoMedico detalhar(Long idMedico);
    void excluir(Long idMedico);
}
