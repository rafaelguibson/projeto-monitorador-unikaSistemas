package entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PessoaJuridica {

    @Id
    private Long monitoradorId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "monitorador_id")
    private Monitorador monitorador;

    @Column(length = 255)
    private String razaoSocial;

    @Column(length = 18)
    private String cnpj;

    @Column(length = 20)
    private String inscricaoEstadual;

}
