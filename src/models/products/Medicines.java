package models.products;

import models.shop.Product;
import models.shop.Quantity;

public class Medicines extends Product {
    public Medicines(double price, String nameProduct, int quantityAvailable, double providerPrice, Provider provider, Quantity quantityPresentation, String sanitaryLicense) {
        super(price, nameProduct, quantityAvailable, providerPrice, provider, quantityPresentation, sanitaryLicense);
    }

    @Override
    public String getIdentifier() {
        return null;
    }
}
