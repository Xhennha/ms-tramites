package cl.aduanaenlinea.mstramites.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entidad que representa a un menor de edad que viaja junto al titular de un tramite.
 * Equivale a la clase "Minor" del diagrama de clases del encargo.
 * Cada Menor pertenece a un unico Tramite (relacion muchos a uno).
 */
@Entity
@Table(name = "menores")
public class Menor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "doc_type")
    private String docType;

    @Column(name = "doc_number")
    private String docNumber;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "has_authorization")
    private boolean hasAuthorization;

    // Lado "dueño" de la relacion: esta es la tabla que guarda la llave foranea tramite_id
    @ManyToOne
    @JoinColumn(name = "tramite_id")
    @JsonBackReference
    private Tramite tramite;

    public Menor() {
        // Constructor vacio requerido por JPA
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isHasAuthorization() {
        return hasAuthorization;
    }

    public void setHasAuthorization(boolean hasAuthorization) {
        this.hasAuthorization = hasAuthorization;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }
}
