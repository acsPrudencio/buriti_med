package med.buriti.api.domain.paciente;


import jakarta.persistence.*;
import lombok.*;
import med.buriti.api.domain.endereco.Endereco;
import med.buriti.api.domain.medico.dto.DadosAtualizacaoMedico;
import med.buriti.api.domain.paciente.dto.DadosCadastroPaciente;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;

    @Embedded
    private Endereco endereco;


    private Boolean ativo;


    public Paciente(DadosCadastroPaciente dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.endereco = new Endereco(dados.endereco());
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.dataNascimento = dados.dataNascimento();
    }

    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }

    }

    public void excluir() {
        this.ativo = false;
    }

    public Integer getIdade(){
        return Objects.nonNull(dataNascimento)?Period.between(dataNascimento, LocalDate.now()).getYears():null;
    }
}

