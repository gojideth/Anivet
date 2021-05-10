package models.administration;

import models.shop.*;

import java.time.LocalDate;

public class Administrator {

    private Market market;
    private AdministratorPerson administratorPerson;
    private Client client;





    public Administrator(Market market) {
        this.market = market;

    }

    public AdministratorPerson getAdministratorPerson() {
        return administratorPerson;
    }

    public void setAdministratorPerson(AdministratorPerson administratorPerson) {
        this.administratorPerson = administratorPerson;
    }

    public void createAdmin(AdministratorPerson administratorPerson){
        this.administratorPerson = new AdministratorPerson(administratorPerson.getName(),administratorPerson.getDocument(),administratorPerson.getAge(),
                administratorPerson.getGender(),administratorPerson.getBirthDate(),administratorPerson.getOccupation());
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
        if (!(this.market.getProductArrayList().contains(product))){
            this.market.addProduct(product);
        }else {
            for (Product product1 : this.market.getProductArrayList()) {
                if (product1.getNameProduct().equals(product.getNameProduct())) {
                    product1.addQuantAvailable();
                } else {
                    this.market.getProductArrayList().add(product);
                }
            }
        }
    }



    public void deleteProduct(String productName){
        this.market.deleteProduct(productName);
    }

    public void checkIventory(Product product){

    }

}
