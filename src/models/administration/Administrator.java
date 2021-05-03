package models.administration;

import models.shop.Client;
import models.shop.Market;
import models.shop.Product;

public class Administrator {

    private Market market;


    public Administrator(Market market) {
        this.market = market;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }



    public void addProduct(Product product){
        this.market.addProduct(product);
    }

    public void deleteProduct(Product product){
        this.market.deleteProduct(product.getNameProduct());
    }

    public void checkIventory(Product product){

    }

}
