package views.dialogs.graphs;

import controllers.MyPresenter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GraphUtility extends JDialog {

    private ArrayList<Integer> data;
    private String nameProductOne, nameProductTwo,nameProductThree;
    private ArrayList<String> stringArrayList;

    public GraphUtility(ArrayList<Integer> data,ArrayList<String> stringArrayList) {
        this.data = data;
        this.stringArrayList = stringArrayList;
        this.setSize(800,300);
        this.setPreferredSize(new Dimension(900,900));
    }


    public void initComponents(MyPresenter myPresenter){

    }

    public void paint(Graphics graphics){
        super.paint(graphics);

        int longOne = (this.data.get(1)*500)/this.getBigger();
        int longTwo = (this.data.get(2)*500)/this.getBigger();
        //int longThree = (this.data.get(3)*500)/this.getBigger();




        graphics.setColor(new Color(32,124,255));
        graphics.fillRect(50,100,longOne,30);
        graphics.drawString("Producto: " + stringArrayList.get(1) +", con utilidad de: " + this.data.get(1)+"$",50,90);

        graphics.setColor(new Color(148, 41, 41));
        graphics.fillRect(50,150,longTwo,30);
        graphics.drawString("Producto:"+ stringArrayList.get(2)+", con utilidad de: " + this.data.get(2)+"$",50,150);

        /*+graphics.setColor(new Color(132, 193, 27));
        graphics.fillRect(50,200,longThree,30);
        graphics.drawString("Producto:"+ stringArrayList.get(3) ,50,200);*/








    }
    /** public void getLengths(){
     lengths = new ArrayList<>();
     int major = getMajor();
     for (int i = 0; i < values.size(); i++) {
     lengths.add(values.get(i)*200/major);
     }
     }*/

    public int getBigger(){
        int major = data.get(0);
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i) >= major){
                major = data.get(i);
            }
        }
        return major;
    }
}
