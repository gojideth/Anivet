package models.shop;

/**
 * Clase que maneja la cantidad de cada producto en el inventario
 * @author Martin Santiago Chiquillo Castro
          */
public class Quantity {
    private int amount;
    private String productDenomination;

    public Quantity(int amount, String productDenomination) {
        this.amount = amount;
        this.productDenomination = productDenomination;
    }

    /**
     * Metodo que permite acceder a la cantidad de cada producto en inventario
     *
     * @return entero con la disponibilidad
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Metodo que retorna la denominacion por que se venden dichos productos
     *
     * @return denominacion del producto
     */
    public String getProductDenomination() {
        return productDenomination;
    }

    /**
     * Metodo que permite agragar a la cantidad disponible una cantidad de productos que llegan por pedido
     *
     * @param amount cantidad a agregarle al inventario
     */
    public void addAmount(int amount) {
        this.amount += amount;
    }

    /**
     * Metodo que resta a la cantidad disponible, otra cantidad, cada vez que se realiza una compra
     *
     * @param quantity cantidad a restar
     */
    public void restToAmount(int quantity) {
        if (amount - quantity >= 0) {
            this.amount -= quantity;
        }
    }

    public void setProductDenomination(String productDenomination) {
        this.productDenomination = productDenomination;
    }

    /**
     * Metodo que cambia el valor de la cantidad
     *
     * @param amount cantidad a setear
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "Quantity{" +
                "amount=" + amount +
                ", productDenomination='" + productDenomination + '\'' +
                '}';
    }
}
