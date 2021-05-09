package models.shop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import models.shop.Product;


public class Bill {
    private LocalDate dateOfExpedition;
    private ArrayList<Product> productsBoughts;

    /**
     * Constructor que crea un recibo con una fecha entrante e instancia la lista de productos
     * @param date Fecha de la creacion del recibo
     */
    public Bill(LocalDate date) {
        this.dateOfExpedition=date;
        this.productsBoughts=new ArrayList();
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