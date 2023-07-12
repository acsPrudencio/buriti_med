package med.buriti.api.domain.paciente;

import med.buriti.api.domain.medico.Especialidade;
import med.buriti.api.domain.medico.Medico;

public record DadosListagemPaciente(String nome, String email, String telefone) {

    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
