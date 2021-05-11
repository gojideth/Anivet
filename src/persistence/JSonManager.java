package persistence;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.gson.Gson;
import models.administration.Administrator;
import models.shop.Market;
import models.shop.Product;
import models.shop.Quantity;
import org.json.simple.DeserializationException;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;

import java.io.*;
import java.util.ArrayList;
import java.util.Queue;

public class JSonManager {
    private ArrayList<Product> productArrayList;
    private Market market;
    public JSonManager() {
        this.productArrayList = new ArrayList<>();

    }

    private  JsonArray jsonArrayObject;


    public Market getProductList() throws IOException, DeserializationException {
        FileReader fileReader = new FileReader("./data/data.json");


        //Gson gson = new Gson();
        Gson gson = new Gson();

        Market market = gson.fromJson(fileReader,Market.class);

        return market;


    }




   /** public void readJsonComponents() throws IOException {
        JsonParser jsonParser = new JsonFactory().createParser(new File("./data/data.json"));
        while (jsonParser.nextToken() != JsonToken.END_ARRAY){
            Product product = new Product("",0,0,0,"",new Quantity(0,""),"","");
            while (jsonParser.nextToken() != JsonToken.END_OBJECT){
                String name = jsonParser.getCurrentName();
                if (name != null){
                    switch (name){
                        case "name_product":
                            jsonParser.nextToken();
                            product.setNameProduct(jsonParser.getValueAsString());
                            break;
                        case "price":
                            jsonParser.nextToken();
                            product.setPrice(jsonParser.getValueAsDouble());
                            break;
                        case "quantity_presentation":
                            jsonParser.nextToken();
                            product.setQuantityPresentationForSelling(jsonParser.getValueAsInt());
                            break;
                        case "provider_price":
                            jsonParser.nextToken();
                            product.setProviderPrice(jsonParser.getValueAsDouble());
                            break;
                        case "provider":
                            jsonParser.nextToken();
                            product.setProvider(jsonParser.getValueAsString());
                            break;
                        case "quantity":
                            jsonParser.nextToken();
                            while (jsonParser.nextToken()!=JsonToken.END_ARRAY){
                                switch (jsonParser.getCurrentName()){
                                    case "amount":
                                        jsonParser.nextToken();
                                        product.getQuantityPresentation().setAmount(jsonParser.getValueAsInt());
                                        break;
                                    case "productDenomination":
                                        jsonParser.nextToken();
                                        product.getQuantityPresentation().setProductDenomination(jsonParser.getValueAsString());
                                    break;
                                }
                            }

                            break;
                        case "sanitary_license":
                            jsonParser.nextToken();
                            product.setSanitaryLicense(jsonParser.getText());
                            break;
                        case "type_product":
                            jsonParser.nextToken();
                            product.setTypeProduct(jsonParser.getValueAsString());
                            break;

                    }
                }
            }
            productArrayList.add(product);
        }
        jsonParser.close();

    }*/




}
