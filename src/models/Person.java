package models;

import java.time.LocalDate;

public abstract class Person {
    private String name;
    private String document;
    private int age;
    private LocalDate birthDate;
    private ChargeType occupation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public ChargeType getOccupation() {
        return occupation;
    }

    public void setOccupation(ChargeType occupation) {
        this.occupation = occupation;
    }


}

