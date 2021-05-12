package utilities;

import java.time.LocalDate;

public class BeautifulBill {



    public static String createBeautifullBill(StringBuilder arrayProducts, String nameAdmin, String nameClient, double totalCost, LocalDate timeNow){

        return "----------------------------------------------------------------------------------------" +
                "\n                           ANIVET LA 33 - Cadena de suministros agricolas " +
                "\n                                  Para el campo lo mejor    "
                + "\n----------------------------------------------------------------------------------------"
                + "\n         Fecha de generación de la factura: "
                + timeNow
                + "\n         Atendido por: "
                + nameAdmin
                + "\n         Cliente: "
                + nameClient
                + "\n----------------------------------------------------------------------------------------"
                + "\n         Lista de Productos comprados: \n\n"
                + arrayProducts.toString()
                + "----------------------------------------------------------------------------------------"
                +"\n          Total de la factura: " + totalCost
                + "\n----------------------------------------------------------------------------------------"
                + "\nVuelva pronto, gracias a su compra podemos patrocinar al mejor equipo, Boyacá Chico F.C ";

    }


    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("Nombre del producto: Oil - Margarine, Precio individual: 43817.0\n" +
                "Nombre del producto: Pork - Liver, Precio individual: 16075.0\n");
        System.out.println(BeautifulBill.createBeautifullBill(builder, "Martin", "Dani",45.000,LocalDate.now()));
    }
}
