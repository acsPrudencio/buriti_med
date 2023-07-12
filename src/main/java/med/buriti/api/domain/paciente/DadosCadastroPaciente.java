package med.buriti.api.domain.paciente;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import med.buriti.api.domain.endereco.DadosEndereco;
import org.hibernate.validator.constraints.br.CPF;

public record DadosCadastroPaciente(
        @NotEmpty
        String nome,
        @NotEmpty
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotEmpty
        @CPF
        String cpf,
        @NotNull @Valid DadosEndereco endereco
){}
