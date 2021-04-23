package models.products;

import models.shop.Product;
import models.shop.Quantity;

public class Fertilizer extends Product {
    private String typeFertilizer;

    public Fertilizer(double price, String nameProduct, int quantityAvailable, double providerPrice, Provider provider, Quantity quantityPresentation, String sanitaryLicense, String typeFertilizer) {
        super(price, nameProduct, quantityAvailable, providerPrice, provider, quantityPresentation, sanitaryLicense);
        this.typeFertilizer = typeFertilizer;
    }

    @Override
    public String getIdentifier() {
        return null;
    }
}
