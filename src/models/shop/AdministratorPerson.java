package models.shop;

import java.time.LocalDate;

public class AdministratorPerson extends Person{


    public AdministratorPerson(String name, String document, String age, String gender, LocalDate birthDate, String occupation) {
        super(name, document, age, gender, birthDate, occupation);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
