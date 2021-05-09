package models.shop;

public enum TypeProduct {
    MEDICINE("Medicinas"), GRAINS("Granos"), WARDROBE("Ropa");
    public String typeoF;
    TypeProduct(String typeOf){
        this.typeoF = typeOf;
    }

    public String getTypeoF() {
        return typeoF;
    }

    public void setTypeoF(String typeoF) {
        this.typeoF = typeoF;
    }
}
