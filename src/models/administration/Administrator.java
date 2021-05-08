package models.administration;

import models.shop.*;

import java.time.LocalDate;

public class Administrator {

    private Market market;
    private Client client;


    public Administrator(Market market, Client client) {
        this.market = market;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void createClient(Client client){
        this.client = new Client(client.getName(),client.getDocument(),client.getAge(),client.getGender(),client.getBirthDate(),client.getOccupation());

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
