package views.header;

import controllers.MyPresenter;

import javax.swing.*;
import java.awt.*;

public class JPHeaderMain extends JPanel{
    PaneLogo jpHeader;
    JPanelButtons jToolsBar;

    public JPHeaderMain(MyPresenter myPresenter) {
        this.setBackground(Color.CYAN);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        //this.setPreferredSize(new Dimension(19000,200));
        this.initComponents(myPresenter);
        //this.setSize(1800000,20);
    }

    public void initComponents(MyPresenter myPresenter){
        this.jpHeader = new PaneLogo(myPresenter);
        this.jToolsBar = new JPanelButtons(myPresenter);
        this.add(jpHeader);
        this.add(jToolsBar);
    }

    public void setTextWelcom(String name){
        jpHeader.setNameToLabel(name);
    }
    public void setTextID(String id){
        jpHeader.setNameToLabelID(id);
    }

    public void changeLanguage(){
        jToolsBar.changeLanguage();
    }
}
