package views.body;

import models.controller.Commands;
import models.controller.MyPresenter;
import views.Constants;

import javax.swing.*;
import java.awt.*;

public class JPLogin extends JPanel {
    JTextField jTextField;
    JPasswordField jPasswordField;


    public JPLogin(MyPresenter myPresenter) {
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        createLogin(myPresenter);

    }


    public void createLogin(MyPresenter myPresenter){
        JPanel loginPanel = new JPanel();
        this.jTextField = new JTextField(15);
        JLabel login = new JLabel("Ingrese su usuario ");
        loginPanel.add(jTextField);
        loginPanel.add(login);

        JPanel passPanel = new JPanel();
        this.jPasswordField = new JPasswordField();
        JLabel jLabel = new JLabel("Ingrese su contraseña: ");
        passPanel.add(jPasswordField);
        passPanel.add(jLabel);

        JButton jButton = new JButton("Login");
        jButton.setActionCommand(Commands.LOGIN_BUTTON.toString());
        jButton.addActionListener(myPresenter);

        this.add(loginPanel);
        this.add(passPanel);
        this.add(jButton);
    }



    public String obtainTextFromFieldPass(){
        return this.jTextField.getText();
    }

    public String obtainTextFromFieldUser(){
        return this.jPasswordField.getText();
    }



}
