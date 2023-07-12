package med.buriti.api.domain.paciente;

import jakarta.validation.constraints.NotNull;
import med.buriti.api.domain.endereco.DadosEnderecoDto;

public record DadosAtualizacaoPacienteDto(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEnderecoDto endereco) {
}
