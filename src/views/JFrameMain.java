package views;

import controllers.MyPresenter;
import models.shop.Client;
import models.shop.Product;
import utilities.HandlerLanguage;
import views.dialogs.DialogProduct;
import views.dialogs.DialogUser;

import javax.swing.*;
import java.awt.*;

public class JFrameMain extends JFrame {
    private JPMain mainPanel;
    private JScrollPane jScrollPane;
    private DialogUser dialogUser;
    private DialogProduct dialogProduct;

    public JFrameMain(MyPresenter myPresenter)  {
        initComponents(myPresenter);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setSize(1800,200);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
        this.setIconImage(new ImageIcon(getClass().getResource(ConstantGUI.ICON_FRAME)).getImage());
    }

    private void initComponents(MyPresenter myPresenter){
        this.mainPanel = new JPMain(myPresenter);
        this.jScrollPane = new JScrollPane(mainPanel);
        this.dialogUser = new DialogUser(myPresenter);
        this.dialogProduct = new DialogProduct(myPresenter);
        this.add(jScrollPane);
    }


    public void changeLanguage() {
        this.setTitle( HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_MAIN_WINDOW ));
        mainPanel.changeLanguage();
    }
    public void showDialogCreate(){
        dialogUser.setVisible(true);
    }

    public void closeDialogClient(){
        dialogUser.dispose();
    }

    public Client createClientFromDialog(){
        return dialogUser.createClient();
    }


    public void showProductDialog(){
        dialogProduct.setVisible(true);
    }

    public void closeDialogProduct(){
        dialogProduct.dispose();
    }

    public Product createProductFromDialog(){
        return dialogProduct.createProduct();
    }

    public void createUserWelcome(String name){
        this.mainPanel.welcomeUserText(name);
    }


    public void showTableProducts(){
        mainPanel.showTable();
    }


    public void createRow(Object [] data){
        this.mainPanel.createRow(data);
    }

    public void deleteRows(){
        this.mainPanel.eraseTable();
    }
}
