package dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class PessoaFisicaDTO {

    private String cpf;
    private String rg;
    private Date dataNascimento;
}

