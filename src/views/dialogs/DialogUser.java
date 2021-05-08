package views.dialogs;

import com.toedter.calendar.JDateChooser;
import models.controller.Commands;
import models.controller.MyPresenter;
import models.shop.ChargeType;
import models.shop.Client;
import models.shop.Gender;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.ZoneId;

public class DialogUser extends JDialog {

    private JPanel panelContainer; //Panel que va a contender el dialog
    private JTextField name;
    private JTextField document;
    private JTextField age;
    private JComboBox <Gender> genderJComboBox;
    private JDateChooser jDateChooser;
    private JComboBox <ChargeType> chargeTypeJComboBox;
    private JToggleButton jToggleButton;
    public  int dorsals = 0;

    public DialogUser(MyPresenter myPresenter) {
        setModal(true);
        setSize(500,600);
        getContentPane().setBackground(new Color(229, 220, 220));
        setLocationRelativeTo(null);
        initComponents(myPresenter);

    }

    private void initComponents(MyPresenter myPresenter) {
        panelContainer = new JPanel();
        panelContainer.setLayout(new GridLayout(7,1,10,10));
        panelContainer.setBackground(Color.lightGray);

        name = new JTextField();
        name.setBorder(BorderFactory.createTitledBorder("Ingresa tu nombre "));
        panelContainer.add(name);

        document = new JTextField();
        document.setBorder(BorderFactory.createTitledBorder("Ingresa tu documento "));
        panelContainer.add(document);

        age = new JTextField();
        age.setBorder(BorderFactory.createTitledBorder("Ingresa tu edad "));
        panelContainer.add(age);

        genderJComboBox = new JComboBox<>(Gender.values());
        genderJComboBox.setBorder(BorderFactory.createTitledBorder("Género"));
        panelContainer.add(genderJComboBox);

        jDateChooser = new JDateChooser();
        jDateChooser.setBorder(BorderFactory.createTitledBorder("Fecha de nacimmiento "));
        panelContainer.add(jDateChooser);


        chargeTypeJComboBox = new JComboBox<>(ChargeType.values());
        chargeTypeJComboBox.setBorder(BorderFactory.createTitledBorder("Equipo"));
        panelContainer.add(chargeTypeJComboBox);




        jToggleButton = new JToggleButton("AGREGAR");
        jToggleButton.setActionCommand(Commands.CREATE_CLIENT_DIALOG.toString());
        jToggleButton.setBorder(new EmptyBorder(10,10,10,10));

        jToggleButton.addActionListener(myPresenter);
        panelContainer.add(jToggleButton);

        this.add(panelContainer);
    }

    public Client createCyclist(){
        return new Client(this.name.getText(),this.document.getText(),Integer.parseInt(this.age.getText()),String.valueOf( genderJComboBox.getSelectedItem()),jDateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                String.valueOf(chargeTypeJComboBox.getSelectedItem()));
    }


}
