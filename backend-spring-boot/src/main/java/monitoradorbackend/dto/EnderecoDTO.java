package monitoradorbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import monitoradorbackend.entities.Endereco;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {

    private Long id;
    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String telefone;
    private String cidade;
    private String estado;
    private String uf;
    private boolean principal;

    public Endereco convertToEntity() {
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(this, endereco);
        return endereco;
    }

    public static EnderecoDTO convertToDto(Endereco endereco) {
        EnderecoDTO dto = new EnderecoDTO();
        BeanUtils.copyProperties(endereco, dto);
        return dto;
    }
}



