package med.buriti.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import med.buriti.api.domain.endereco.DadosEnderecoDto;

public record DadosCadastroMedicoDto(
        @NotEmpty
        String nome,
        @NotEmpty
        @Email
        String email,
        @NotEmpty
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull @Valid DadosEnderecoDto endereco,
        @NotBlank
        String telefone
){}
