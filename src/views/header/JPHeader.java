package views.header;

import models.controller.Commands;
import models.controller.MyPresenter;
import utilities.MyUtilities;
import views.ConstantGUI;
import views.Constants;

import javax.swing.*;
import java.awt.*;

public class JPHeader extends JPanel {
    JButton logoButton;
    JLabel welcomeUser;
    JButton logOut;

    public JPHeader(MyPresenter myPresenter, String nameUser) {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setAlignmentX(LEFT_ALIGNMENT);
        this.setBackground(Color.BLUE);
        this.setPreferredSize(new Dimension(this.returnWidth(this.obtainScreenSize()), 100));
        initComponents(myPresenter);
        createWelcomeUser(nameUser,myPresenter);
    }

    public Dimension obtainScreenSize() {
        return Toolkit.getDefaultToolkit().getScreenSize();
        // width will store the width of the screen
    }

    public int returnWidth(Dimension dimension) {
        return (int) dimension.getWidth();
    }


    public void initComponents(MyPresenter myPresenter) {
        logoButton = new JButton();
        ImageIcon temp = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.LOGO_ANIVET)).getImage().getScaledInstance(250, 100, Image.SCALE_SMOOTH));
        MyUtilities.setMainElementsButton(logoButton, temp, 0, 50, 20, 10);
        logoButton.addActionListener(myPresenter);
        logoButton.setActionCommand(Commands.C_SHOW_HOMEPAGE.toString());
        this.add(logoButton);


    }

    public void createWelcomeUser(String userName, MyPresenter myPresenter) {
        JPanel welcomePanel = new JPanel();
        welcomePanel.setVisible(true);
        welcomePanel.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.welcomeUser = new JLabel("Bienvenido: " + userName);

        this.logOut = new JButton(Constants.LOGOUT);
        this.logOut.setActionCommand(Commands.LOGOUT.toString());
        this.logOut.addActionListener(myPresenter);

        welcomePanel.add(welcomeUser);
        welcomePanel.add(logOut);
        this.add(welcomePanel,RIGHT_ALIGNMENT);


    }


}
