package cl.aduanaenlinea.mstramites.service;

import cl.aduanaenlinea.mstramites.dto.CrearTramiteRequest;
import cl.aduanaenlinea.mstramites.dto.MenorDTO;
import cl.aduanaenlinea.mstramites.model.Menor;
import cl.aduanaenlinea.mstramites.model.Tramite;
import cl.aduanaenlinea.mstramites.repository.TramiteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;
import java.util.UUID;

/**
 * Logica de negocio de tramites: crear la declaracion, generar el identificador
 * unico (equivalente al codigo QR del prototipo) y consultar su estado.
 */
@Service
public class TramiteService {

    // Horas de vigencia del comprobante, igual que en el prototipo React (ver ConfirmationScreen)
    private static final long HORAS_VIGENCIA = 72;

    private final TramiteRepository tramiteRepository;

    public TramiteService(TramiteRepository tramiteRepository) {
        this.tramiteRepository = tramiteRepository;
    }

    public Tramite crearTramite(CrearTramiteRequest datos) {
        Tramite tramite = new Tramite();
        tramite.setTramiteId(generarTramiteId());
        tramite.setProcessType(datos.getProcessType());
        tramite.setDocType(datos.getDocType());
        tramite.setDocNumber(datos.getDocNumber());
        tramite.setFullName(datos.getFullName());
        tramite.setNationality(datos.getNationality());
        tramite.setBirthDate(datos.getBirthDate());
        tramite.setHasMinors(datos.isHasMinors());
        tramite.setSagProducts(String.join(",", datos.getSagProducts()));
        tramite.setNoProducts(datos.isNoProducts());
        tramite.setHasVehicle(datos.isHasVehicle());
        tramite.setVehiclePlate(datos.getVehiclePlate());
        tramite.setVehicleBrand(datos.getVehicleBrand());
        tramite.setVehicleModel(datos.getVehicleModel());
        tramite.setVehicleYear(datos.getVehicleYear());
        tramite.setVehicleColor(datos.getVehicleColor());
        tramite.setVehicleCountry(datos.getVehicleCountry());
        tramite.setUserEmail(datos.getUserEmail());
        tramite.setCreatedAt(LocalDateTime.now());
        tramite.setExpiresAt(LocalDateTime.now().plusHours(HORAS_VIGENCIA));

        for (MenorDTO menorDTO : datos.getMinors()) {
            Menor menor = new Menor();
            menor.setName(menorDTO.getName());
            menor.setDocType(menorDTO.getDocType());
            menor.setDocNumber(menorDTO.getDocNumber());
            menor.setBirthDate(menorDTO.getBirthDate());
            menor.setHasAuthorization(menorDTO.isHasAuthorization());
            tramite.addMenor(menor);
        }

        return tramiteRepository.save(tramite);
    }

    public Tramite buscarPorTramiteId(String tramiteId) {
        return tramiteRepository.findByTramiteId(tramiteId)
                .orElseThrow(() -> new NegocioException("No se encontro ningun tramite con ese identificador"));
    }

    public Tramite buscarPorDocumento(String docNumber) {
        return tramiteRepository.findByDocNumber(docNumber)
                .orElseThrow(() -> new NegocioException("No se encontro ningun tramite para ese documento"));
    }

    public List<Tramite> listarPorUsuario(String userEmail) {
        return tramiteRepository.findByUserEmail(userEmail);
    }

    /**
     * Genera un identificador de tramite unico, con el mismo formato que usaba
     * el prototipo en localStorage: ADN-{anio}-{8 caracteres}. Ejemplo: ADN-2026-A1B2C3D4
     */
    private String generarTramiteId() {
        String anio = String.valueOf(Year.now().getValue());
        String sufijo = UUID.randomUUID().toString().replace("-", "").substring(0, 8).toUpperCase();
        return "ADN-" + anio + "-" + sufijo;
    }
}
