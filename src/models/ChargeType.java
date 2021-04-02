package models;

public enum ChargeType {
    WORKER("Trabajador"),USER("Usuario")    ;
    private String occupation;

    ChargeType(String occupation) {
        this.occupation = occupation;
    }

    public String getOccupation() {
        return occupation;
    }
}
