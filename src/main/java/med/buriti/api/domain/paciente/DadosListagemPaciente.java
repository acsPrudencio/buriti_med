package med.buriti.api.domain.paciente;

public record DadosListagemPaciente(String nome, Integer idade, String email, String telefone) {

    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getNome(), paciente.getIdade(), paciente.getEmail(), paciente.getTelefone());
    }
}
