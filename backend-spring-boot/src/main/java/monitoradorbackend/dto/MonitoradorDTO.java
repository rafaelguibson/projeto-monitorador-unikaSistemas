package monitoradorbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import monitoradorbackend.entities.Endereco;
import monitoradorbackend.entities.Monitorador;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MonitoradorDTO {

    private Long id;
    private String tipoPessoa;
    private String cpfCnpj;
    private String nomeRazaoSocial;
    private String email;
    private String rg;
    private String orgaoExpedidor;
    private String inscricaoEstadual;
    private Date dataNascimento;
    private boolean ativo;
    private List<EnderecoDTO> enderecos;

    public Monitorador convertToEntity() {
        Monitorador monitorador = new Monitorador();
        BeanUtils.copyProperties(this, monitorador);

        // Copiar endereços manualmente se necessário
        if (enderecos != null) {
            List<Endereco> enderecoList = enderecos.stream()
                    .map(EnderecoDTO::convertToEntity)
                    .collect(Collectors.toList());
            monitorador.setEnderecos(enderecoList);
        }

        return monitorador;
    }

    public static MonitoradorDTO convertToDto(Monitorador monitorador) {
        MonitoradorDTO dto = new MonitoradorDTO();
        BeanUtils.copyProperties(monitorador, dto);

        // Copiar endereços manualmente se necessário
        if (monitorador.getEnderecos() != null) {
            List<EnderecoDTO> enderecoDTOList = monitorador.getEnderecos().stream()
                    .map(EnderecoDTO::convertToDto)
                    .collect(Collectors.toList());
            dto.setEnderecos(enderecoDTOList);
        }

        return dto;
    }
}
