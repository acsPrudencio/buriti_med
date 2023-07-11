package med.buriti.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.buriti.api.domain.endereco.DadosEnderecoDto;

public record DadosAtualizacaoMedicoDto(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEnderecoDto endereco) {
}
