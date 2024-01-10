package monitoradorbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ESTAGIO_MONITORADOR")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Monitorador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_monitorador")
    private Long id;

    @Column(name = "tipo_pessoa", nullable = false)
    private String tipoPessoa;

    @Column(name = "cpf_cnpj", unique = true, nullable = false)
    private String cpfCnpj;

    @Column(name = "nome_razao_social", nullable = false)
    private String nomeRazaoSocial;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "rg", nullable = false)
    private String rg;

    @Column(name = "orgao_expedidor", nullable = false)
    private String orgaoExpedidor;

    @Column(name = "inscricao_estadual", nullable = false)
    private String inscricaoEstadual;

    @Column(name = "data_nascimento", nullable = false)
    private Date dataNascimento;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    // Relacionamento 1:N com Enderecos
    @OneToMany(mappedBy = "monitorador", cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

    // Getters e Setters
}
