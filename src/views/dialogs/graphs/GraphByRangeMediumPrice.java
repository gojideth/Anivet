package views.dialogs.graphs;

import controllers.MyPresenter;

import javax.swing.*;
import java.awt.*;

public class GraphByRangeMediumPrice extends JDialog {
    int valueOne;
    int valueTwo;


    public GraphByRangeMediumPrice(int value1, int value2) {
        this.valueOne = value1;
        this.valueTwo = value2;
        this.setPreferredSize(new Dimension(500,300));
        setSize(600,350);
        this.setVisible(true);
    }


    public void initComponents(MyPresenter myPresenter){

    }

    public void paint(Graphics graphics){
        super.paint(graphics);


        int longOne = (this.valueOne *500)/this.obtainHighest();
        int longSecond = (this.valueTwo*500)/this.obtainHighest();


        int sumTotal = this.valueOne+this.valueTwo;

        graphics.setColor(new Color(32,124,255));
        graphics.fillRect(50,100,longOne,30);
        graphics.drawString("Productos menores a 50.000$ " + ", en total: " + this.valueOne,50,90);
        //graphics.drawString("Numero de productos: " + this.valueOne,30,100);

        graphics.setColor(new Color(255,74,122));
        graphics.fillRect(50,170,longSecond,30);
        graphics.drawString("Productos mayores a 50.000$"+ ", en total: " + this.valueTwo,50,165);
        //graphics.drawString("Numero de productos: " + this.valueTwo,30,100);


    }

    public double obtainPercentage(int value, int total){
        return (value*100)/total;
    }

    public int obtainHighest(){
        if (this.valueOne >this.valueTwo)
            return this.valueOne;
        else
            return this.valueTwo;
    }
}
