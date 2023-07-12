package med.buriti.api.domain.paciente;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import med.buriti.api.domain.endereco.DadosEnderecoDto;
import org.hibernate.validator.constraints.br.CPF;

public record DadosCadastroPacienteDto(
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
        @NotNull @Valid DadosEnderecoDto endereco
){}

