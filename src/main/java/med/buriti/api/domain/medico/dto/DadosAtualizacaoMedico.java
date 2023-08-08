package med.buriti.api.domain.medico.dto;

import jakarta.validation.constraints.NotNull;
import med.buriti.api.domain.endereco.dto.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
