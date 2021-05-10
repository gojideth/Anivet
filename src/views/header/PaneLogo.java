package views.header;

import controllers.Commands;
import controllers.MyPresenter;
import utilities.HandlerLanguage;
import utilities.MyUtilities;
import views.ConstantGUI;
import views.Constants;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PaneLogo extends JPanel {
    private JButton logoButton;
    private  JLabel welcomeUser, userID;
    private JButton logOut;
    private  JButton signIn;
    private JButton changeToSpanish, changeToEnglish;
    private ImageIcon tempWorld;

    public PaneLogo(MyPresenter myPresenter) {
        this.setLayout(new BorderLayout());

        this.setBackground(Color.WHITE);

        this.setPreferredSize(new Dimension(this.returnWidth(this.obtainScreenSize()), 160));
        initComponents(myPresenter);
        createWelcomeUser(myPresenter);
        //this.addIdiomsButtons(myPresenter);
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
        ImageIcon temp = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.LOGO_ANIVET)).getImage().getScaledInstance(350, 180, Image.SCALE_SMOOTH));
        MyUtilities.setMainElementsButton(logoButton, temp, 0, 50, 20, 10);
        logoButton.addActionListener(myPresenter);
        logoButton.setActionCommand(Commands.C_SHOW_HOMEPAGE.toString());
        Border emptyBorder = BorderFactory.createEmptyBorder();
        logoButton.setBorder(emptyBorder);
        this.add(logoButton,BorderLayout.WEST);


    }

    public void createWelcomeUser( MyPresenter myPresenter) {
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BoxLayout(welcomePanel,BoxLayout.Y_AXIS));
        Border border = new EmptyBorder(10,10,10,6000);
       // welcomePanel.setBorder(border);
        welcomePanel.setVisible(true);
        welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
        welcomePanel.setBackground(Color.white);
        //welcomePanel.setPreferredSize(new Dimension(150,20));
        this.welcomeUser = new JLabel("Por favor agrega a un cliente primero");

        this.userID = new JLabel(" ");

        this.logOut = new JButton(Constants.LOGOUT);
        this.logOut.setActionCommand(Commands.LOGOUT.toString());
        this.logOut.addActionListener(myPresenter);

        this.signIn = new JButton("Agrega a un nuevo cliente");
        this.signIn.setActionCommand(Commands.C_SHOW_DIALOG_CLIENT.toString());
        this.signIn.addActionListener(myPresenter);

        welcomePanel.add(welcomeUser);
        welcomePanel.add(userID);
        welcomePanel.add(signIn);
        welcomePanel.add(logOut);
        welcomePanel.add(Box.createRigidArea(new Dimension(100,0)));
        changeToSpanish = new JButton("");
        changeToSpanish.setActionCommand(Commands.I_CHANGE_TO_SPANISH.toString());
        changeToSpanish.addActionListener(myPresenter);
        tempWorld = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.ICON_SPANISH)).getImage());
        MyUtilities.setTextAndIconButtons(changeToSpanish, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SPANISH),tempWorld,0,0,0,0);

        changeToEnglish = new JButton("");
        changeToEnglish.setActionCommand(Commands.I_CHANGE_TO_ENGLISH.toString());
        changeToEnglish.addActionListener(myPresenter);
        tempWorld = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.ICON_ENGLISH)).getImage());
        MyUtilities.setTextAndIconButtons(changeToEnglish, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_ENGLISH),tempWorld,0,0,0,0);

        welcomePanel.add(changeToSpanish);
        welcomePanel.add(changeToEnglish);
        this.add(welcomePanel,BorderLayout.EAST);


    }

    public void changeLanguage(){
        changeToEnglish.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_ENGLISH));
        changeToSpanish.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SPANISH));


    }


    public void setNameToLabel(String name){
        this.welcomeUser.setText("Bienvenido: " + name);
    }
    public void setNameToLabelID(String id){
        this.userID.setText("Número de documento: " + id);
    }


}
