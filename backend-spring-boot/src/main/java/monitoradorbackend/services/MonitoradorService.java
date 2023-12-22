package services;

import dto.EnderecoDTO;
import dto.MonitoradorDTO;
import dto.TelefoneDTO;
import entities.Endereco;
import entities.Monitorador;
import entities.Telefone;
import mapper.EnderecoMapper;
import mapper.MonitoradorMapper;
import mapper.TelefoneMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EnderecoRepository;
import repository.MonitoradorRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;
import repository.TelefoneRepository;

@Service
public class MonitoradorService {

    @Autowired
    private MonitoradorRepository monitoradorRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional
    public MonitoradorDTO cadastrarMonitorador(MonitoradorDTO monitoradorDTO) {
        if (!validarCampos(monitoradorDTO)) {
            // Lógica de tratamento de erro, lançar exceção, etc.
        }

        Monitorador monitorador = new Monitorador();
        BeanUtils.copyProperties(monitoradorDTO, monitorador);

        preencherTelefones(monitoradorDTO.getTelefones(), monitorador);
        preencherEnderecos(monitoradorDTO.getEnderecos(), monitorador);

        monitorador = monitoradorRepository.save(monitorador);

        return MonitoradorMapper.INSTANCE.toDTO(monitorador);
    }

    private void preencherTelefones(List<TelefoneDTO> telefoneDTOs, Monitorador monitorador) {
        if (telefoneDTOs != null) {
            List<Telefone> telefones = telefoneDTOs.stream()
                    .map(telefoneDTO -> {
                        Telefone telefone = TelefoneMapper.INSTANCE.toEntity(telefoneDTO);
                        telefone.setMonitorador(monitorador);
                        return telefoneRepository.save(telefone);
                    })
                    .collect(Collectors.toList());

            monitorador.setTelefones(telefones);
        }
    }

    public MonitoradorDTO alterarMonitorador(Long monitoradorId, MonitoradorDTO monitoradorDTO) {
        Optional<Monitorador> optionalMonitorador = monitoradorRepository.findById(monitoradorId);
        if (optionalMonitorador.isPresent()) {
            Monitorador monitoradorExistente = optionalMonitorador.get();

            BeanUtils.copyProperties(monitoradorDTO, monitoradorExistente);

            preencherTelefones(monitoradorDTO.getTelefones(), monitoradorExistente);
            preencherEnderecos(monitoradorDTO.getEnderecos(), monitoradorExistente);

            monitoradorExistente = monitoradorRepository.save(monitoradorExistente);

            return MonitoradorMapper.INSTANCE.toDTO(monitoradorExistente);
        } else {
            // Lógica de tratamento de erro, lançar exceção, etc.
            return null;
        }
    }
    public void excluirMonitorador(Long monitoradorId) {
        monitoradorRepository.deleteById(monitoradorId);
    }
    public MonitoradorDTO listarPorId(Long monitoradorId) {
        Optional<Monitorador> optionalMonitorador = monitoradorRepository.findById(monitoradorId);
        return optionalMonitorador.map(MonitoradorMapper.INSTANCE::toDTO).orElse(null);
    }

    public List<MonitoradorDTO> listarTodos() {
        List<Monitorador> monitoradores = monitoradorRepository.findAll();
        return monitoradores.stream()
                .map(MonitoradorMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    private void preencherEnderecos(List<EnderecoDTO> enderecoDTOs, Monitorador monitorador) {
        if (enderecoDTOs != null) {
            List<Endereco> enderecos = enderecoDTOs.stream()
                    .map(enderecoDTO -> {
                        Endereco endereco = EnderecoMapper.INSTANCE.toEntity(enderecoDTO);
                        endereco.setMonitorador(monitorador);
                        return enderecoRepository.save(endereco);
                    })
                    .collect(Collectors.toList());

            monitorador.setEnderecos(enderecos);
        }
    }


    private boolean validarCampos(MonitoradorDTO monitoradorDTO) {
        return monitoradorDTO != null &&
                (monitoradorDTO.getTelefones() != null || monitoradorDTO.getEnderecos() != null);
    }
}