package cl.aduanaenlinea.mstramites.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

/**
 * Datos que llegan desde el frontend al terminar el flujo de declaracion
 * (equivale al objeto "AppFormData" del prototipo React).
 * Los nombres de los campos coinciden a proposito con los de types.ts
 * para que el frontend pueda enviar el formData tal cual, sin transformarlo.
 */
public class CrearTramiteRequest {

    @NotBlank(message = "processType es obligatorio (entry o exit)")
    private String processType;

    private String docType;
    private String docNumber;
    private String fullName;
    private String nationality;
    private String birthDate;
    private boolean hasMinors;
    private List<MenorDTO> minors = new ArrayList<>();

    private List<String> sagProducts = new ArrayList<>();
    private boolean noProducts;

    private boolean hasVehicle;
    private String vehiclePlate;
    private String vehicleBrand;
    private String vehicleModel;
    private String vehicleYear;
    private String vehicleColor;
    private String vehicleCountry;

    // Correo del usuario logueado, o null si es un invitado
    private String userEmail;

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

    public List<MenorDTO> getMinors() {
        return minors;
    }

    public void setMinors(List<MenorDTO> minors) {
        this.minors = minors;
    }

    public List<String> getSagProducts() {
        return sagProducts;
    }

    public void setSagProducts(List<String> sagProducts) {
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
}
