package med.buriti.api.domain.medico.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.buriti.api.domain.endereco.dto.DadosEndereco;
import med.buriti.api.domain.medico.enums.Especialidade;

public record DadosCadastroMedico(
        @NotBlank(message = "{nome.obrigatorio}")
        String nome,
        @NotBlank(message = "{email.obrigatorio}")
        @Email(message = "{email.invalido}")
        String email,
        @NotBlank(message = "{crm.obrigatorio}")
        @Pattern(regexp = "\\d{4,6}", message = "{crm.invalido}")
        String crm,
        @NotNull(message = "{especialidade.obrigatoria}")
        Especialidade especialidade,
        @NotNull(message = "{endereco.obrigatorio}")
        @Valid DadosEndereco endereco,
        @NotBlank(message = "{telefone.obrigatorio}")
        String telefone
) {
}
