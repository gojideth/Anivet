package models.products;

import models.administration.Administrator;
import models.shop.Client;
import models.shop.Market;

public class Manager {

    private Market market;
    private Client client;
    private Administrator administrator;


    public Manager(Market market, Client client) {
        this.market = market;
        this.client = null;

    }

    public void addProduct(){

    }
}
