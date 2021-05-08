package models.shop;

public enum Gender {
    M("Masculino"), F("Femenino");

    private String gender;

    Gender(String gender) {
        this.gender=gender;
    }

    public String getGender() {
        return gender;
    }
}
