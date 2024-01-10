package monitoradorbackend.controller;

import monitoradorbackend.entities.Monitorador;
import monitoradorbackend.services.MonitoradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monitoradores")
public class MonitoradorController {

    private final MonitoradorService monitoradorService;

    @Autowired
    public MonitoradorController(MonitoradorService monitoradorService) {
        this.monitoradorService = monitoradorService;
    }

    @PostMapping
    public ResponseEntity<Monitorador> createMonitorador(@RequestBody Monitorador monitorador) {
        Monitorador createdMonitorador = monitoradorService.saveMonitorador(monitorador);
        return ResponseEntity.ok(createdMonitorador);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monitorador> getMonitoradorById(@PathVariable Long id) {
        return monitoradorService.getMonitoradorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Monitorador>> getAllMonitoradores() {
        List<Monitorador> monitoradores = monitoradorService.getAllMonitoradores();
        return ResponseEntity.ok(monitoradores);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMonitorador(@PathVariable Long id) {
        monitoradorService.deleteMonitorador(id);
        return ResponseEntity.noContent().build();
    }
}
