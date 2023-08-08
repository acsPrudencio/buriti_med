package med.buriti.api.service.medico.impl;

import lombok.RequiredArgsConstructor;
import med.buriti.api.Repository.medico.MedicoRepository;
import med.buriti.api.domain.medico.*;
import med.buriti.api.domain.medico.dto.DadosAtualizacaoMedico;
import med.buriti.api.domain.medico.dto.DadosCadastroMedico;
import med.buriti.api.domain.medico.dto.DadosDetalhamentoMedico;
import med.buriti.api.domain.medico.dto.DadosListagemMedico;
import med.buriti.api.service.medico.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MedicoServiceImpl implements MedicoService {


    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public Page<DadosListagemMedico> listarMedicos(Pageable paginacao) {
        return medicoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @Override
    public DadosDetalhamentoMedico cadastrar(DadosCadastroMedico dados) {
        Medico medico = new Medico(dados);
        medicoRepository.save(medico);
        return new DadosDetalhamentoMedico(medico);
    }

    @Override
    public DadosDetalhamentoMedico atualizar(DadosAtualizacaoMedico dados) {
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
        return new DadosDetalhamentoMedico(medico);
    }

    @Override
    public DadosDetalhamentoMedico detalhar(Long id) {
        var medico = medicoRepository.getReferenceById(id);
        return new DadosDetalhamentoMedico(medico);
    }

    @Override
    public void excluir(Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
    }
}
