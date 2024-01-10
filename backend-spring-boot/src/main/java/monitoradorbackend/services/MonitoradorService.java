package monitoradorbackend.services;

import monitoradorbackend.entities.Monitorador;
import monitoradorbackend.repository.MonitoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MonitoradorService {

    private final MonitoradorRepository monitoradorRepository;

    @Autowired
    public MonitoradorService(MonitoradorRepository monitoradorRepository) {
        this.monitoradorRepository = monitoradorRepository;
    }

    public Monitorador saveMonitorador(Monitorador monitorador) {
        return monitoradorRepository.save(monitorador);
    }

    public Optional<Monitorador> getMonitoradorById(Long id) {
        return monitoradorRepository.findById(id);
    }

    public List<Monitorador> getAllMonitoradores() {
        return monitoradorRepository.findAll();
    }

    public void deleteMonitorador(Long id) {
        monitoradorRepository.deleteById(id);
    }
}
