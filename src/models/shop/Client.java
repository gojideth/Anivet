package models.shop;

import java.time.LocalDate;

public class Client extends Person {


    public Client(String name, String document, int age, String gender, LocalDate birthDate, String occupation) {
        super(name, document, age, gender, birthDate, occupation);
    }
}
