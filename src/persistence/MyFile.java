package persistence;


import java.io.*;

public class MyFile {
    File f;
    FileWriter fw;
    FileReader fr;
    BufferedWriter bw = null;
    BufferedReader br = null;

    public MyFile(String nameFile) {
        f = new File(nameFile);
    }

    public void myOpen(char modo)	{
        try {
            //modo escritura "w" crea el archivo
            if (modo=='w'){
                fw = new FileWriter(f);
                bw = new BufferedWriter(fw);
            }
            else{
                //modo lectura "r" abre el archivo
                fr = new FileReader(f);
                br = new BufferedReader(fr);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //Almacena la cadena ingresada por parametro
    public void record(String cad){
        if (bw!=null){
            try {
                bw.write(cad);
                bw.newLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    // Lee una linea del archivo
    public String myRead(){
        String cad="";
        try {
            cad= br.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cad;
    }
    // cierra archivo modo R/W
    public void myClose(){
        try {
            if (br!=null)
                br.close();
            if (bw!=null)
                bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}