package models.shop;

public  class Product {
    public static final double IVA_PERCENTAGE = 0.19;

    protected String nameProduct;
    protected double price;
    protected int quantityPresentationForSelling = 0;
    private double providerPrice;
    private String provider;
    private Quantity quantityPresentation;
    private String sanitaryLicense;
    private String typeProduct;

    public Product(String typeProduct, double price, String nameProduct, int quantityAvailable, double providerPrice, String provider, Quantity quantityPresentation, String sanitaryLicense) {
        this.typeProduct = typeProduct;
        this.price = price;
        this.nameProduct = nameProduct;
        this.quantityPresentationForSelling = quantityAvailable;
        this.providerPrice = providerPrice;
        this.provider = provider;
        this.quantityPresentation = quantityPresentation;
        this.sanitaryLicense = sanitaryLicense;
    }

    public Product(String nameProduct, double price, int quantityAvailable, double providerPrice, String provider, Quantity quantityPresentation, String sanitaryLicense, String typeProduct) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantityPresentationForSelling = quantityAvailable;
        this.providerPrice = providerPrice;
        this.provider = provider;
        this.quantityPresentation = quantityPresentation;
        this.sanitaryLicense = sanitaryLicense;
        this.typeProduct = typeProduct;
    }



    public void addQuantAvailable(){
        this.setQuantityPresentationForSelling(this.getQuantityPresentationForSelling()+1);
    }
    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public int getQuantityPresentationForSelling() {
        return quantityPresentationForSelling;
    }

    public void setQuantityPresentationForSelling(int quantityPresentationForSelling) {
        this.quantityPresentationForSelling = quantityPresentationForSelling;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
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



    public Object[ ] getObjectVector(){
        return new Object[]{
                this.nameProduct,
                this.price,
                this.quantityPresentationForSelling,
                this.getQuantityPresentation(),
                this.provider,
                this.providerPrice,
                this.sanitaryLicense,

        };
    }

    @Override
    public String toString() {
        return "Product{" +
                "nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", quantityPresentationForSelling=" + quantityPresentationForSelling +
                ", providerPrice=" + providerPrice +
                ", provider='" + provider + '\'' +
                ", quantityPresentation=" + quantityPresentation +
                ", sanitaryLicense='" + sanitaryLicense + '\'' +
                ", typeProduct='" + typeProduct + '\'' +
                '}';
    }
}
