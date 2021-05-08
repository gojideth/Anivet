package views;

import models.controller.MyPresenter;
import models.shop.Client;
import views.body.JPLogin;
import views.dialogs.DialogUser;

import javax.swing.*;
import java.awt.*;

public class JFrameMain extends JFrame {
    private JPMain mainPanel;
    private JScrollPane jScrollPane;
    private DialogUser dialogUser;

    public JFrameMain(MyPresenter myPresenter, String nameUser)  {
        initComponents(myPresenter, nameUser);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
        this.setIconImage(new ImageIcon(getClass().getResource(ConstantGUI.ICON_FRAME)).getImage());
    }

    private void initComponents(MyPresenter myPresenter,String nameUser){
        this.mainPanel = new JPMain(myPresenter,nameUser);
        this.jScrollPane = new JScrollPane(mainPanel);
        this.dialogUser = new DialogUser(myPresenter);
        this.add(jScrollPane);
    }

    public void showDialogCreate(){
        dialogUser.setVisible(true);
    }

    public Client createCyclist(){
        return dialogUser.createCyclist();
    }



}
