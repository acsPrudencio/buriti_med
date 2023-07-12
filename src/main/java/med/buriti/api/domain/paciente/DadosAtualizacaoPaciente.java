package med.buriti.api.domain.paciente;

import jakarta.validation.constraints.NotNull;
import med.buriti.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
