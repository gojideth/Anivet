package views;

import models.controller.MyPresenter;
import views.body.JPLogin;
import views.header.JPHeader;
import views.header.JPHeaderMain;

import javax.swing.*;
import java.awt.*;

public class JPMain extends JPanel {
    private JPLogin jpLogin;
    private JPHeaderMain jpHeaderMain;

    public JPMain(MyPresenter myPresenter,String nameUser) {
        this.setLayout(new BorderLayout());
        initComponents(myPresenter, nameUser);
        this.setBackground(Color.red);
    }

    public void initComponents(MyPresenter myPresenter, String nameUser){
        this.jpLogin = new JPLogin(myPresenter);
        this.jpHeaderMain = new JPHeaderMain(myPresenter,nameUser);
        this.add(jpLogin,BorderLayout.CENTER);
        this.add(jpHeaderMain,BorderLayout.NORTH);
        this.jpLogin.setVisible(false);
    }
}
