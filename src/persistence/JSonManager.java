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






}
