package models.shop;

import java.time.LocalDate;

public abstract class Person {
    private java.lang.String name;
    private java.lang.String document;
    private int age;
    private String gender;
    private LocalDate birthDate;
    private String occupation;

    public Person(java.lang.String name, java.lang.String document, int age, String gender, LocalDate birthDate, String occupation) {
        this.name = name;
        this.document = document;
        this.age = age;
        this.gender = gender;
        this.birthDate = birthDate;
        this.occupation = occupation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getDocument() {
        return document;
    }

    public void setDocument(java.lang.String document) {
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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }


}

