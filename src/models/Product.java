package models;

import models.Provider;
import models.Quantity;

public abstract class Product {
    public static final double IVA_PERCENTAGE = 0.19;

    protected double price;
    protected String nameProduct;
    protected int quantityAvailable;
    private double providerPrice;
    private Provider provider;
    private Quantity quantityPresentation;
    private String sanitaryLicense;

    public Product(double price, String nameProduct, int quantityAvailable, double providerPrice, Provider provider, Quantity quantityPresentation, String sanitaryLicense) {
        this.price = price;
        this.nameProduct = nameProduct;
        this.quantityAvailable = quantityAvailable;
        this.providerPrice = providerPrice;
        this.provider = provider;
        this.quantityPresentation = quantityPresentation;
        this.sanitaryLicense = sanitaryLicense;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Quantity getQuantityPresentation() {
        return quantityPresentation;
    }

    public void setQuantityPresentation(Quantity quantityPresentation) {
        this.quantityPresentation = quantityPresentation;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getSanitaryLicense() {
        return sanitaryLicense;
    }

    public void setSanitaryLicense(String sanitaryLicense) {
        this.sanitaryLicense = sanitaryLicense;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getProviderPrice() {
        return providerPrice;
    }

    public void setProviderPrice(double providerPrice) {
        this.providerPrice = providerPrice;
    }

    public String formatForBuy(){
        return nameProduct + " precio: " + price + " cantidad disponible :" + getQuantityPresentation().getAmount() + getQuantityPresentation().getProductDenomination();
    }
}
