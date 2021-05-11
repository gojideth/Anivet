package models.shop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import models.shop.Product;


public class Bill {
    private LocalDate dateOfExpedition;
    private ArrayList<Product> productsBoughts;
    private Client client;
    private AdministratorPerson administratorPerson;
    /**
     * Constructor que crea un recibo con una fecha entrante e instancia la lista de productos
     * @param date Fecha de la creacion del recibo
     */
    public Bill(LocalDate date) {
        this.dateOfExpedition=date;
        this.productsBoughts=new ArrayList<Product>();
    }
    public void createAdmin(AdministratorPerson administratorPerson){
        this.administratorPerson = administratorPerson;

    }

    public Double returnAllPrices(){
        double sum = 0;
        for (Product product:this.productsBoughts) {
            sum+= product.getPrice();
        }
        return sum;
    }

    public void createClient(Client client){
        this.client = client;
    }
    public void setDateOfExpedition(LocalDate dateOfExpedition) {
        this.dateOfExpedition = dateOfExpedition;
    }

    public ArrayList<Product> getProductsBoughts() {
        return productsBoughts;
    }

    public void setProductsBoughts(ArrayList<Product> productsBoughts) {
        this.productsBoughts = productsBoughts;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public AdministratorPerson getAdministratorPerson() {
        return administratorPerson;
    }

    public void setAdministratorPerson(AdministratorPerson administratorPerson) {
        this.administratorPerson = administratorPerson;
    }

    /**
     * Constructor por default
     * @param products Productos a ingresar
     */
    public Bill(ArrayList<Product> products){
        this.productsBoughts = products;
    }

    /**
     * Metodo que arrjo la fecha de compra que se imprimira en la factura
     * @return fecha del dia actual
     */
    public LocalDate getDateOfExpedition() {
        return dateOfExpedition;
    }

    /**
     * Metodo que retornara la lista que contiene lo que el cliente comprara
     * @return arraylist con los productos que se compraran
     */
    public ArrayList<Product> getProducts() {
        return productsBoughts;
    }

    /**
     * Metodo que calcula el total que debe pagar la persona
     * @return total a pagar
     */
    public double calculateTotal(){
        double acum = 0;
        for (int i=0; i<productsBoughts.size(); i++){
            acum += productsBoughts.get(i).getPrice() * productsBoughts.get(i).getQuantityPresentation().getAmount();
        }
        return acum;
    }
}