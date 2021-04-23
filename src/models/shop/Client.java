package models.shop;

import java.time.LocalDate;

public class Client extends Person {

    public Client(String name, String document, int age, LocalDate birthDate, ChargeType occupation) {
        super(name, document, age, birthDate, occupation);
    }



}
