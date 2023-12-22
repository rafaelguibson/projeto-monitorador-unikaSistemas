package controller;

import dto.MonitoradorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.MonitoradorService;

import java.util.List;

@RestController
@RequestMapping("/api/monitoradores")
public class MonitoradorController {

    @Autowired
    private MonitoradorService monitoradorService;

    @PostMapping
    public ResponseEntity<MonitoradorDTO> cadastrarMonitorador(@RequestBody MonitoradorDTO monitoradorDTO) {
        MonitoradorDTO novoMonitorador = monitoradorService.cadastrarMonitorador(monitoradorDTO);
        return new ResponseEntity<>(novoMonitorador, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonitoradorDTO> alterarMonitorador(@PathVariable Long id, @RequestBody MonitoradorDTO monitoradorDTO) {
        MonitoradorDTO monitoradorAlterado = monitoradorService.alterarMonitorador(id, monitoradorDTO);
        if (monitoradorAlterado != null) {
            return new ResponseEntity<>(monitoradorAlterado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirMonitorador(@PathVariable Long id) {
        monitoradorService.excluirMonitorador(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonitoradorDTO> listarPorId(@PathVariable Long id) {
        MonitoradorDTO monitoradorDTO = monitoradorService.listarPorId(id);
        if (monitoradorDTO != null) {
            return new ResponseEntity<>(monitoradorDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<MonitoradorDTO>> listarTodos() {
        List<MonitoradorDTO> monitoradoresDTO = monitoradorService.listarTodos();
        return new ResponseEntity<>(monitoradoresDTO, HttpStatus.OK);
    }
}
