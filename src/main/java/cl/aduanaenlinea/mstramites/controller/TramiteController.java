package cl.aduanaenlinea.mstramites.controller;

import cl.aduanaenlinea.mstramites.dto.CrearTramiteRequest;
import cl.aduanaenlinea.mstramites.model.Tramite;
import cl.aduanaenlinea.mstramites.service.TramiteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Endpoints REST del microservicio de Tramites.
 * Base URL: http://localhost:8082/api/tramites
 * (CORS se configura de forma centralizada en config/CorsConfig.java)
 */
@RestController
public class TramiteController {

    private final TramiteService tramiteService;

    public TramiteController(TramiteService tramiteService) {
        this.tramiteService = tramiteService;
    }

    // GET http://localhost:8082/api/tramites/health
    @GetMapping("/api/tramites/health")
    public String health() {
        return "ms-tramites funcionando correctamente";
    }

    // POST http://localhost:8082/api/tramites  (se llama al terminar el paso 3: Vehiculo)
    @PostMapping("/api/tramites")
    @ResponseStatus(HttpStatus.CREATED)
    public Tramite crear(@Valid @RequestBody CrearTramiteRequest datos) {
        return tramiteService.crearTramite(datos);
    }

    // GET http://localhost:8082/api/tramites/ADN-2026-A1B2C3D4  (pantalla de Confirmacion / escaneo QR)
    @GetMapping("/api/tramites/{tramiteId}")
    public Tramite buscarPorId(@PathVariable String tramiteId) {
        return tramiteService.buscarPorTramiteId(tramiteId);
    }

    // GET http://localhost:8082/api/tramites/buscar?docNumber=AB123456  (pantalla de Estado de Solicitudes)
    @GetMapping("/api/tramites/buscar")
    public Tramite buscarPorDocumento(@RequestParam String docNumber) {
        return tramiteService.buscarPorDocumento(docNumber);
    }

    // GET http://localhost:8082/api/tramites/usuario/correo@ejemplo.cl  (historial del dashboard)
    @GetMapping("/api/tramites/usuario/{userEmail}")
    public List<Tramite> listarPorUsuario(@PathVariable String userEmail) {
        return tramiteService.listarPorUsuario(userEmail);
    }
}
