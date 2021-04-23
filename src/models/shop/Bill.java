package models.shop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import models.shop.Product;


public class Bill {
    private LocalDate dateOfExpedition;
    private List<Product> products;

    /**
     * Constructor que crea un recibo con una fecha entrante e instancia la lista de productos
     * @param date Fecha de la creacion del recibo
     */
    public Bill(LocalDate date) {
        this.dateOfExpedition=date;
        this.products=new ArrayList();
    }

    /**
     * Constructor por default
     * @param products Productos a ingresar
     */
    public Bill(List<Product> products){
        this.products = products;
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
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Metodo que calcula el total que debe pagar la persona
     * @return total a pagar
     */
    public double calculateTotal(){
        double acum = 0;
        for (int i=0; i<products.size(); i++){
            acum += products.get(i).getPrice() * products.get(i).getQuantityPresentation().getAmount();
        }
        return acum;
    }
}