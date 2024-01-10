package monitoradorbackend.repository;

import monitoradorbackend.entities.Monitorador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitoradorRepository extends JpaRepository<Monitorador, Long> {
    // TODO  - IMPLEMENTAR METODOS ESPECIFICOS NAS VERSÕES SEGUINTES
}

