package persistence;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import models.shop.Product;
import models.shop.Quantity;
import org.json.simple.DeserializationException;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class JSonManager {

    private  JsonArray jsonArrayObject;
    public ArrayList<Product> getProductList() throws IOException, DeserializationException {

        ArrayList<Product>medicinesList = new ArrayList<>();

        String webService = "https://www.datos.gov.co/api/views/w877-w4d7/rows.json?accessType=DOWNLOAD";

        BufferedReader br = new BufferedReader(new InputStreamReader(getInputStream(false,webService)));
        System.out.println("output is -----------");

        JsonObject jsonObject;

        jsonObject = (JsonObject) Jsoner.deserialize(br);
        JsonArray jsonMed = (JsonArray) jsonObject.get("data");

        for (Object arrayData : jsonMed) {
            jsonArrayObject = (JsonArray) arrayData;

            //System.out.println(jsonArrayObject.get(10));
            //String temp [] = jsonArrayDatas.get(i).toString().split(", (?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

            medicinesList.add(new Medicine(jsonArrayObject.get(8).toString(),
                    jsonArrayObject.get(9).toString(),
                    jsonArrayObject.get(10).toString(),
                    jsonArrayObject.get(11).toString()));

            for (int i = 0; i < medicinesList.size(); i++) {
                //System.out.println(medicinesList.get(i).toString() + "\n");
            }
        }
        //System.out.println(medicinesList.size() + "\n");
        return medicinesList;
    }

    public void readJsonComponents() throws IOException {
        JsonParser jsonParser = new JsonFactory().createParser(new File("src/main/java/files/components.json"));
        while (jsonParser.nextToken() != JsonToken.END_OBJECT){
            Product product = new Product("",0,0,0,"",new Quantity(0,""),"","");
            while (jsonParser.nextToken() != JsonToken.END_OBJECT){
                String name = jsonParser.getCurrentName();
                if (name != null){
                    switch (name){
                        case "name_product":
                            jsonParser.nextToken();
                            product.setPrice(jsonParser.getValueAsDouble());
                            break;
                        case "Brand":
                            jsonParser.nextToken();
                            product.setBrand(jsonParser.getText());
                            break;
                        case "Rank":
                            jsonParser.nextToken();
                            product.setRank(jsonParser.getValueAsInt());
                            break;
                        case "Type":
                            jsonParser.nextToken();
                            product.setType(jsonParser.getText());
                            break;
                        case "Model":
                            jsonParser.nextToken();
                            product.setModel(jsonParser.getText());
                            break;
                        case "Benchmark":
                            jsonParser.nextToken();
                            product.setBenchmark(jsonParser.getValueAsDouble());
                            break;
                        case "Stock":
                            jsonParser.nextToken();
                            product.setStock(jsonParser.getValueAsInt());
                            break;
                        case "PartNumber":
                            jsonParser.nextToken();
                            product.setPartNum(jsonParser.getText());
                            break;
                        case "Samples":
                            jsonParser.nextToken();
                            product.setSamples(jsonParser.getValueAsDouble());
                            break;
                        case "URL":
                            jsonParser.nextToken();
                            product.setUrl(jsonParser.getText());
                            break;
                    }
                }
            }
            comps.add(pro);
        }
        jsonParser.close();
        shop.setComponents(comps);
    }


}
