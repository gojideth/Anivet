package views;

import controllers.MyPresenter;
import models.shop.AdministratorPerson;
import models.shop.Client;
import models.shop.Product;
import utilities.HandlerLanguage;
import views.dialogs.DialogAdmin;
import views.dialogs.DialogCartShopping;
import views.dialogs.DialogProduct;
import views.dialogs.DialogUser;

import javax.swing.*;
import java.awt.*;

public class JFrameMain extends JFrame {
    private JPMain mainPanel;
    private JScrollPane jScrollPane;
    private DialogUser dialogUser;
    private DialogProduct dialogProduct;
    private DialogAdmin dialogAdmin;
    private DialogCartShopping dialogCartShopping;

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
        this.dialogAdmin = new DialogAdmin(myPresenter);
        this.dialogCartShopping = new DialogCartShopping( myPresenter);
        this.add(jScrollPane);
    }

    public void changeLanguage() {
        this.setTitle( HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_MAIN_WINDOW ));
        mainPanel.changeLanguage();
        mainPanel.changeButtonsIdiom();
    }

    public void showGraphicsButtons(){
        this.mainPanel.showGraphicsButtons();
        this.validate();
    }

    public void showTableButtons(){
        this.mainPanel.showTablesButtons();
        this.validate();
    }

    //Bill
    public void createBillTableData(Object [] data){
        this.dialogCartShopping.createRow(data);
    }

    public void eraseBillTableData(){
        this.dialogCartShopping.eraseTable();
    }

    //CartDialog
    public void showDialogCart(){
        this.dialogCartShopping.setVisible(true);
    }

    public void closeDialogCart(){
        this.dialogCartShopping.dispose();
    }



    public void showAdminDialog(){
        this.dialogAdmin.setVisible(true);
    }

    public void closeAdminDialog(){
        this.dialogAdmin.dispose();
    }

    public AdministratorPerson createAdminFromDialog(){
        return dialogAdmin.createAdmin();
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

    public void blankDialogProduct(){
        dialogProduct.validate();
    }

    public void createUserWelcome(String name){
        this.mainPanel.welcomeUserText(name);
    }

    public void createUserID(String id){
        this.mainPanel.welcomeUserId(id);
    }

    public void showTableProducts(){
        mainPanel.showTable();
    }

    public String obtainSelectedData(){
        return mainPanel.obtainSelectedData();
    }

    public void createRow(Object [] data){
        this.mainPanel.createRow(data);
    }

    public void deleteRows(){
        this.mainPanel.eraseTable();
    }
}
