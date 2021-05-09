package models.shop;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Market {
    private String name;
    private List<Product> productArrayList;
    private List<Product> filters;

    public Market(String name) {
        this.name = name;
        this.productArrayList = new ArrayList<>();
        this.filters = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductArrayList() {
        return productArrayList;
    }

    public void setProductArrayList(List<Product> productArrayList) {
        this.productArrayList = productArrayList;
    }

    public void setFilters(List<Product> filters) {
        this.filters = filters;
    }

    public void deleteProduct(String product){
        productArrayList.removeIf(products -> products.getNameProduct().equals(product));
    }

    public void addProduct(Product product){
        this.productArrayList.add(product);
    }


    private void filterListAlphabet(){
        filters.clear();
        filters.addAll(productArrayList);
        filters.sort(new Comparator<Product>() {
                         @Override
                         public int compare(Product o1, Product o2) {
                             return o1.nameProduct.compareTo(o2.nameProduct);
                         }
                     }
        );
    }
    public void filterName(String name){
        filters.clear();
        for (int i = 0; i < productArrayList.size(); i++) {
            if (productArrayList.get(i).nameProduct.contains(name)){
                filters.add(productArrayList.get(i));
            }
        }
    }

    /**
     * Metodo que permite filtrar por un tipo de producto
     * @param type tipo de producto
     */
    public void filterType(String type){
        filters.clear();
        for (int i = 0; i < productArrayList.size(); i++) {
            if (productArrayList.get(i).getNameProduct().equalsIgnoreCase(type.toUpperCase())){
                filters.add(productArrayList.get(i));
            }
        }
    }

    /**
     * Metodo que permite filtrar la lista por un precio masximo a pagar
     * @param maxPrice precio maximo a pagar
     */
    public void filterLowerPrice(double maxPrice){
        filters.clear();
        for (int i = 0; i < productArrayList.size(); i++) {
            if (productArrayList.get(i).getPrice() <= maxPrice){
                filters.add(productArrayList.get(i));
            }
        }
    }

    /**
     * Metodo que permite filtrar por un precio maximo a pagar y por un tipo de producto
     * @param maxPrice Precio maximo elegido
     * @param typeProduct Tipo de producto a filtrar
     */
    public void filterLowerPrice(double maxPrice, String typeProduct){
        filters.clear();
        for (int i = 0; i < productArrayList.size(); i++) {
            Product productTemporal = productArrayList.get(i);
            if (productTemporal.getPrice() <= maxPrice && productTemporal.getNameProduct().equalsIgnoreCase(typeProduct)){
                filters.add(productTemporal);
            }
        }
    }

    /**
     * Metodo que permite filtrar los productos por un precio minimo
     * @param minPrice minimo precio
     */
    public void filterMaxPrice(double minPrice){
        filters.clear();
        for (int i = 0; i < productArrayList.size(); i++) {
            if (productArrayList.get(i).getPrice() >= minPrice){
                filters.add(productArrayList.get(i));
            }
        }
    }

    /**
     * Metodo que permite filtrar por un precio minimo y un tipo de producto
     * @param minPrice minimo precio a pagar
     * @param typeProduct tipo de producto
     */
    public void filterMaxPrice(double minPrice, String typeProduct){
        filters.clear();
        for (int i = 0; i < productArrayList.size(); i++) {
            Product productTemporal = productArrayList.get(i);
            if (productTemporal.getPrice() >= minPrice && productTemporal.getNameProduct().contains(typeProduct.toUpperCase())){
                filters.add(productTemporal);
            }
        }
    }

    /**
     * Metodo que permite filtrar por un rango de precios
     * @param minPrice precio minimo que se desea pagar
     * @param maxPrice precio maximo que se desea pagar
     */
    public void filterRangePrices(double minPrice, double maxPrice){
        filters.clear();
        for (int i = 0; i < productArrayList.size(); i++) {
            Product productTemporal = productArrayList.get(i);
            if (productTemporal.getPrice() >= minPrice && productTemporal.getPrice() <= maxPrice){
                filters.add(productTemporal);
            }
        }
    }

    /**
     * metodo que muestra la lista de productos
     */
    public void show(){
        for (int i=0; i<this.productArrayList.size(); i++){
            System.out.println(productArrayList.get(i).nameProduct);
        }
    }

    /**
     * Metodo que retorna lista de filtros
     * @return lista de filtrados
     */
    public List<Product> getFilters(){
        return filters;
    }

    /**
     * Metdo que imprime lista de filtrados
     */
    public void showFilters(){
        for (int i=0; i<this.filters.size(); i++){
            System.out.println(filters.get(i).nameProduct);
        }
    }
}
