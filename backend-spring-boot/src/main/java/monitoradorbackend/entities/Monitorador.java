package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Monitorador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String tipo;

    @Column(length = 255)
    private String nome;

    @Column(length = 255)
    private String email;

    private boolean ativo;

    @OneToOne(mappedBy = "monitorador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PessoaFisica pessoaFisica;

    @OneToOne(mappedBy = "monitorador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PessoaJuridica pessoaJuridica;

    @OneToMany(mappedBy = "monitorador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Telefone> telefones;

    @OneToMany(mappedBy = "monitorador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Endereco> enderecos;

    // getters and setters
}
