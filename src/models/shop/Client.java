package models.shop;

import java.time.LocalDate;

public class Client extends Person {


    public Client(String name, String document, String age, String gender, LocalDate birthDate, String occupation) {
        super(name, document, age, gender, birthDate, occupation);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
