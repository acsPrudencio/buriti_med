package med.buriti.api.domain.paciente.dto;

import med.buriti.api.domain.endereco.Endereco;
import med.buriti.api.domain.paciente.Paciente;

public record DadosDetalhamentoPaciente(Long id, Integer idade,String nome, String email, String cpf, String telefone, Endereco endereco) {
    public DadosDetalhamentoPaciente (Paciente paciente) {
        this(paciente.getId(), paciente.getIdade(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco());
    }
}
