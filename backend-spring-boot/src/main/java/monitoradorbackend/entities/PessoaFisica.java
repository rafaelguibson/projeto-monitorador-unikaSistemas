package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class PessoaFisica {

    @Id
    private Long monitoradorId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "monitorador_id")
    private Monitorador monitorador;

    @Column(length = 14)
    private String cpf;

    @Column(length = 20)
    private String rg;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

}
