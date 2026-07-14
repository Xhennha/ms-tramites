package cl.aduanaenlinea.mstramites.dto;

/**
 * Representa a un menor de edad tal como lo envia/recibe el frontend (AppFormData.minors[]).
 */
public class MenorDTO {

    private String name;
    private String docType;
    private String docNumber;
    private String birthDate;
    private boolean hasAuthorization;

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
}
