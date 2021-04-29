package persistence;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ShopWriter {

    public void writeFile(String text){
        try(FileWriter fw = new FileWriter("Result.shop", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(text);
        } catch (IOException e) {
        }
    }
}