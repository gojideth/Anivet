package models.shop;

public enum TypeProduct {
    Medicine("Medicinas"), Grain("Granos"), Wardrobe("Ropa"),
    Beauty("Belleza"), Music("Musica"),Outdoors("Exteriores"),
    Grocery("Dulces"), Shoes("Calzado"), Tools("Herramientas"),
    Toys("Juguetes"), Movies("Peliculas"), Kids("Productos para niños"),
    Jewelry("Joyería"), Health("Salud"), Games("Juegos"), Electronics("Electricos"),
    ;
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
