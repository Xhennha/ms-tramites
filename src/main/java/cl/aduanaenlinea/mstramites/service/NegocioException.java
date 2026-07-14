package cl.aduanaenlinea.mstramites.service;

/**
 * Excepcion simple para errores de reglas de negocio
 * (ej: tramite no encontrado, tramite vencido).
 */
public class NegocioException extends RuntimeException {

    public NegocioException(String mensaje) {
        super(mensaje);
    }
}
