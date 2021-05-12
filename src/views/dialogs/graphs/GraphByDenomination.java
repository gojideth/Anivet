package views.dialogs.graphs;

import controllers.MyPresenter;
import views.JFrameMain;

import javax.swing.*;
import java.awt.*;

public class GraphByDenomination extends JDialog {
    int valuOne;
    int valueTwo;


    public GraphByDenomination(int value1, int value2) {
        this.valuOne = value1;
        this.valueTwo = value2;
        this.setPreferredSize(new Dimension(500,300));
        setSize(500,350);
        this.setVisible(true);
    }


    public void initComponents(MyPresenter myPresenter){

    }

    public void paint(Graphics graphics){
        super.paint(graphics);

        int sumTotal = this.valuOne+this.valueTwo;


        int grado1 = (valuOne*360)/sumTotal;
        int grado2 = (valueTwo*360)/sumTotal;



        graphics.setColor(new Color(255,178,86));
        graphics.fillArc(50,100,200,200,0,grado1);
        graphics.fillRect(280,100,20,20);
        graphics.drawString("Units, " + this.obtainPercentage(this.valuOne,sumTotal)+"%" ,300,115);


        graphics.setColor(new Color(88,150,255));
        graphics.fillArc(50,100,200,200,grado1,grado2);
        graphics.fillRect(280,150,20,20);
        graphics.drawString("Grams, "+ this.obtainPercentage(this.valueTwo,sumTotal)+"%",300,159);

        /**graphics.setColor(Color.RED);
        graphics.fillArc(50,100,200,200,grado1+grado2,grado3);
        graphics.fillRect(200,150,20,20);
        graphics.drawString("Ventas mayores a 60",210,150);*/

        //this.add(graphics);


    }

    public double obtainPercentage(int value, int total){
        return (value*100)/total;
    }


}
