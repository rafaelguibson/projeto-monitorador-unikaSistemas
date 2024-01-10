package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Monitorador implements Serializable {
    @Setter
    private Long id;
    private String tipoPessoa;
    private String cpfCnpj;
    private String nomeRazaoSocial;
    private String email;
    private String orgaoExpedidor;
    private String inscricaoEstadual;
    private Date dataNascimento;
    private boolean ativo;

    private final List<Endereco> enderecos= new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monitorador that = (Monitorador) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
