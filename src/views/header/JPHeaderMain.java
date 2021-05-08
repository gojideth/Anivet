package views.header;

import models.controller.MyPresenter;

import javax.swing.*;

public class JPHeaderMain extends JPanel{
    JPHeader jpHeader;
    JToolsBar jToolsBar;

    public JPHeaderMain(MyPresenter myPresenter,String name) {
        this.initComponents(myPresenter,name);
    }

    public void initComponents(MyPresenter myPresenter, String name){
        this.jpHeader = new JPHeader(myPresenter,name);
        this.jToolsBar = new JToolsBar(myPresenter);
    }
}
