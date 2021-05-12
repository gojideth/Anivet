package views.dialogs.graphs;

import controllers.MyPresenter;

import javax.swing.*;
import java.awt.*;

public class GraphQuantityPresentionSelled extends JDialog {
    private int data[];



    public GraphQuantityPresentionSelled(int data[]) {
        this.data = data;
        this.setPreferredSize(new Dimension(900,900));
        this.setSize(600,350);
        this.setVisible(true);
    }


    public void initComponents(MyPresenter myPresenter){

    }

    public void paint(Graphics graphics){
        super.paint(graphics);

        int longOne = (data[0]*500)/this.getBiggerNumber();
        int longTwo = (data[1]*500)/this.getBiggerNumber();
        int longThree = (data[2]*500)/this.getBiggerNumber();
        int longFourth = (data[3]*500)/this.getBiggerNumber();
        int longFive = (data[4]*500)/this.getBiggerNumber();
       /**int longSix= (data[5]*500)/this.getBiggerNumber();
        int longSeven = (data[6]*500)/this.getBiggerNumber();
        int longEight = (data[7]*500)/this.getBiggerNumber();
        int longNine = (data[8]*500)/this.getBiggerNumber();
        int longTen = (data[9]*500)/this.getBiggerNumber();*/




        graphics.setColor(new Color(32,124,255));
        graphics.fillRect(50,100,longOne,30);
        graphics.drawString("Disponibles para la venta de 1 producto: " + this.data[0],50,90);

        graphics.setColor(new Color(148, 41, 41));
        graphics.fillRect(50,150,longTwo,30);
        graphics.drawString("Disponibles para la venta de 2 productos:"+ this.data[1] ,50,150);

        graphics.setColor(new Color(132, 193, 27));
        graphics.fillRect(50,200,longThree,30);
        graphics.drawString("Disponibles para la venta de 3 productos:"+ this.data[2] ,50,200);

        graphics.setColor(new Color(172, 156, 38));
        graphics.fillRect(50,250,longFourth,30);
        graphics.drawString("Disponibles para la venta de 4 productos:"+ this.data[3] ,50,250);

        graphics.setColor(new Color(255,144,60));
        graphics.fillRect(50,300,longFive,30);
        graphics.drawString("Disponibles para la venta de 5 productos:"+ this.data[4] ,50,300);

        /**graphics.setColor(new Color(255,82,74));
        graphics.fillRect(50,350,longSix,30);
        graphics.drawString("Valor 6",20,350);

        graphics.setColor(new Color(255,60,136));
        graphics.fillRect(50,400,longSeven,30);
        graphics.drawString("Valor 7",20,400);

        graphics.setColor(new Color(174,25,255));
        graphics.fillRect(50,400,longEight,30);
        graphics.drawString("Valor 8",20,400);

        graphics.setColor(new Color(87,34,255));
        graphics.fillRect(50,450,longNine,30);
        graphics.drawString("Valor 9",20,450);

        graphics.setColor(new Color(203,220,255));
        graphics.fillRect(50,500,longTen,30);
        graphics.drawString("Valor 10",20,500);
        **/












    }
   /** public void getLengths(){
        lengths = new ArrayList<>();
        int major = getMajor();
        for (int i = 0; i < values.size(); i++) {
            lengths.add(values.get(i)*200/major);
        }
    }*/

   public int getBiggerNumber( ){
        int major = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] >= major){
                major = data[i];
            }
        }
        return major;
   }


}
