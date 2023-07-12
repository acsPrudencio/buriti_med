package med.buriti.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import med.buriti.api.domain.endereco.DadosEndereco;

public record DadosCadastroMedico(
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
        @NotNull @Valid DadosEndereco endereco,
        @NotBlank
        String telefone
){}
