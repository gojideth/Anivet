package views.body;

import controllers.Commands;
import controllers.MyPresenter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class JPLogin extends JPanel {
    JTextField jTextField;
    JPasswordField jPasswordField;


    public JPLogin(MyPresenter myPresenter) {
       // this.setLayout(new BorderLayout());
        this.setBackground(Color.BLUE);
        createLogin(myPresenter);

    }


    public void createLogin(MyPresenter myPresenter){
        JPanel panelAux = new JPanel();

        //panelAux.setLayout(new BoxLayout(panelAux,BoxLayout.Y_AXIS));
        panelAux.setPreferredSize(new Dimension(400,200));
        panelAux.setBorder(new EmptyBorder(0,200,0,200));
        panelAux.setBackground(Color.green);



        this.jTextField = new JTextField(15);
        JLabel login = new JLabel("Ingrese su usuario ");


        this.jPasswordField = new JPasswordField(15);
        JLabel jLabel = new JLabel("Ingrese su contraseña: ");

        JButton jButton = new JButton("Login");
        jButton.setActionCommand(Commands.LOGIN_BUTTON.toString());
        jButton.addActionListener(myPresenter);

        panelAux.add(login);
        panelAux.add(jTextField);
        panelAux.add(jLabel);
        panelAux.add(jPasswordField);
        panelAux.add(jButton);

        this.add(panelAux,BorderLayout.CENTER);

    }



    public String obtainTextFromFieldPass(){
        return this.jTextField.getText();
    }

    public String obtainTextFromFieldUser(){
        return this.jPasswordField.getText();
    }



}
