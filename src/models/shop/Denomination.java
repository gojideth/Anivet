package models.shop;

public enum Denomination {
    GRAMS("Gramos"), UNITS("Unidades");

    private  String denomination;
    Denomination(String denominacion){
        this.denomination = denominacion;
    }

}
