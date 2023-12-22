package dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MonitoradorDTO {

    private Long id;
    private String tipo;
    private String nome;
    private String email;
    private boolean ativo;

    private PessoaFisicaDTO pessoaFisica;
    private PessoaJuridicaDTO pessoaJuridica;
    private List<TelefoneDTO> telefones;
    private List<EnderecoDTO> enderecos;

}

