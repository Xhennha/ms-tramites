package cl.aduanaenlinea.mstramites.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad que representa un tramite (declaracion) de un viajero.
 * Equivale a la union de "AppFormData" + "StoredTramite" del diagrama de clases del encargo.
 * Se guarda todo en una sola tabla "tramites" y la lista de menores en una tabla aparte ("menores"),
 * relacionada 1 a muchos.
 */
@Entity
@Table(name = "tramites")
public class Tramite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Identificador de negocio, visible para el usuario y el funcionario de aduana (ej: ADN-2026-A1B2C3D4)
    @Column(name = "tramite_id", nullable = false, unique = true)
    private String tramiteId;

    @Column(name = "process_type")
    private String processType; // "entry" o "exit"

    @Column(name = "doc_type")
    private String docType;

    @Column(name = "doc_number")
    private String docNumber;

    @Column(name = "full_name")
    private String fullName;

    private String nationality;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "has_minors")
    private boolean hasMinors;

    // Lista de categorias SAG declaradas, guardadas separadas por coma (ej: "frutas,lacteos")
    // Simplificacion valida para el alcance de este prototipo academico.
    @Column(name = "sag_products")
    private String sagProducts;

    @Column(name = "no_products")
    private boolean noProducts;

    @Column(name = "has_vehicle")
    private boolean hasVehicle;

    @Column(name = "vehicle_plate")
    private String vehiclePlate;

    @Column(name = "vehicle_brand")
    private String vehicleBrand;

    @Column(name = "vehicle_model")
    private String vehicleModel;

    @Column(name = "vehicle_year")
    private String vehicleYear;

    @Column(name = "vehicle_color")
    private String vehicleColor;

    @Column(name = "vehicle_country")
    private String vehicleCountry;

    @Column(name = "user_email")
    private String userEmail; // null si el tramite lo hizo un invitado

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "expires_at", nullable = false)
    private LocalDateTime expiresAt;

    // Un tramite puede tener 0 o varios menores asociados.
    // cascade = ALL: al guardar/borrar el tramite, se guardan/borran sus menores automaticamente.
    @OneToMany(mappedBy = "tramite", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Menor> minors = new ArrayList<>();

    public Tramite() {
        // Constructor vacio requerido por JPA
    }

    // --- Getters y setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTramiteId() {
        return tramiteId;
    }

    public void setTramiteId(String tramiteId) {
        this.tramiteId = tramiteId;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isHasMinors() {
        return hasMinors;
    }

    public void setHasMinors(boolean hasMinors) {
        this.hasMinors = hasMinors;
    }

    public String getSagProducts() {
        return sagProducts;
    }

    public void setSagProducts(String sagProducts) {
        this.sagProducts = sagProducts;
    }

    public boolean isNoProducts() {
        return noProducts;
    }

    public void setNoProducts(boolean noProducts) {
        this.noProducts = noProducts;
    }

    public boolean isHasVehicle() {
        return hasVehicle;
    }

    public void setHasVehicle(boolean hasVehicle) {
        this.hasVehicle = hasVehicle;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(String vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getVehicleCountry() {
        return vehicleCountry;
    }

    public void setVehicleCountry(String vehicleCountry) {
        this.vehicleCountry = vehicleCountry;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public List<Menor> getMinors() {
        return minors;
    }

    public void setMinors(List<Menor> minors) {
        this.minors = minors;
    }

    /**
     * Metodo de conveniencia: agrega un menor y deja bien seteada
     * la relacion en ambos lados (buena practica con @OneToMany/@ManyToOne).
     */
    public void addMenor(Menor menor) {
        minors.add(menor);
        menor.setTramite(this);
    }
}
