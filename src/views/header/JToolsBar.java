package views.header;

import models.controller.Commands;
import models.controller.MyPresenter;
import views.Constants;

import javax.swing.*;
import java.awt.*;

public class JToolsBar extends JToolBar{
        private JButton createClient;


    public JToolsBar(MyPresenter myPresenter) {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(Color.darkGray);
        this.setFloatable(false);
        this.initComponents(myPresenter);
    }

    public void initComponents(MyPresenter myPresenter){
        createClient = new JButton("Borrar ususarios");
        createClient.setActionCommand(Commands.C_SHOW_DIALOG_CLIENT.toString());
       // createClient.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(Constants.ERASE)).getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)));
        createClient.addActionListener(myPresenter);
        this.add(createClient);
    }


}


