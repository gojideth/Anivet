package models.products;

import models.Product;
import models.Provider;
import models.Quantity;

public class WorkingSupplies extends Product {


    public WorkingSupplies(double price, String nameProduct, int quantityAvailable, double providerPrice, Provider provider, Quantity quantityPresentation, String sanitaryLicense) {
        super(price, nameProduct, quantityAvailable, providerPrice, provider, quantityPresentation, sanitaryLicense);
    }
}
