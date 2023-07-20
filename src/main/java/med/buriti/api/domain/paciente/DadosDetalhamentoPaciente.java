package med.buriti.api.domain.paciente;

import med.buriti.api.domain.endereco.Endereco;
public record DadosDetalhamentoPaciente(Long id, Integer idade,String nome, String email, String cpf, String telefone, Endereco endereco) {
    public DadosDetalhamentoPaciente (Paciente paciente) {
        this(paciente.getId(), paciente.getIdade(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco());
    }
}
