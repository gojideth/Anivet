package controllers;

import models.administration.Administrator;
import models.shop.Client;
import models.shop.Market;
import models.shop.Product;
import utilities.HandlerLanguage;
import views.JFrameMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MyPresenter implements ActionListener {
    private static final String SPANISH_PATH = "./resources/languages/languageES.properties";
    private static final String NAME_FILE_CONFIG = "./resources/config/config.init";
    private static final String ENGLISH_PATH = "./resources/languages/languageUS.properties";
    private JFrameMain mainFrame;
    private Administrator administrator;
    private HandlerLanguage config;

    public MyPresenter() {
        loadConfiguration();
        this.administrator = new Administrator(new Market("Anivet"));
        this.mainFrame = new JFrameMain(this);

    }

    private void initComponents() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Commands.valueOf(e.getActionCommand())) {
            case C_SHOW_HOMEPAGE:
                System.out.println("FUNCIONA");
                break;
            case I_CHANGE_TO_ENGLISH:
                manageChangeLenguageUS();
                break;
            case I_CHANGE_TO_SPANISH:
                manageChangeLanguageES();
                mainFrame.showTableProducts();
                this.printTestProducts();
                break;
            case C_SHOW_DIALOG_CLIENT:
                this.showDialogCreate();
                break;
            case CREATE_CLIENT_DIALOG:
                this.createClientInAdmin(this.bringClientFromDialog());

                this.setText();
                this.setId();
                break;
            case C_SHOW_DIALOG_PRODUCT:
                this.showProductDialog();
                break;
            case C_LIST_PRODUCTS:
                this.showTableData();
                break;
            case C_BUY_PRODUCTS:
                System.out.println("FUnciona al menos?");
                this.buyProducts();
                this.printAnyArraylist(this.administrator.getMarket().getItemsBoughts());
                break;

            case CREATE_PRODUCT_DIALOG_AND_CLOSE:
                this.receiveProductAndAddIt();
                this.showTableData();
                this.closeProductDialog();


            case C_SHOW_TABLE:
                mainFrame.showTableProducts();
                break;
            case C_DELETE_PRODUCT:
                this.deleteProduct(JOptionPane.showInputDialog(null));
                this.showTableData();
                break;
            default:

        }
    }

    //DialogCLIENT
    public void showDialogCreate() {
        mainFrame.showDialogCreate();
    }

    private Client bringClientFromDialog() {
        return mainFrame.createClientFromDialog();
    }

    public void closeDialogClient() {
        mainFrame.closeDialogClient();
    }

    public void createClientInAdmin(Client client) {
        this.administrator.createClient(client);
        this.mainFrame.closeDialogClient();
    }

    //DialogProduct
    public void showProductDialog() {
        mainFrame.showProductDialog();
    }

    public void closeProductDialog() {
        mainFrame.closeDialogProduct();
    }

    public Product bringProductFromDialog() {
        return mainFrame.createProductFromDialog();
    }

    public void receiveProductAndAddIt() {
        this.addProductValidater(this.bringProductFromDialog());
    }

    public void addProductValidater(Product product) {

        this.administrator.addProduct(product);
    }



    public void deleteProduct(String name) {
        this.administrator.deleteProduct(name);
    }

    public void addProductDataToTable(Object[] data) {
        this.mainFrame.createRow(data);
    }

    public Object[] fromProductToArray(Product product) {
        return new Object[]{
                String.valueOf(product.getNameProduct()),
                String.valueOf(product.getPrice()),
                String.valueOf(product.getQuantityAvailable()),
                String.valueOf(product.getProviderPrice()),
                String.valueOf(product.getProvider()),
                String.valueOf(product.getQuantityPresentation().getProductDenomination()),
                String.valueOf(product.getSanitaryLicense()),
                String.valueOf(product.getTypeProduct()),
        };
    }

    public Object[] getProductObject(Product product) {
        return product.getObjectVector();
    }


    public void addAllProductsToTable() {
        for (Product product : this.administrator.getMarket().getProductArrayList()) {
            this.addProductDataToTable(this.fromProductToArray(product));
            System.out.println(product.toString());
        }
    }

    public void printAnyArraylist(ArrayList<Product> arrayList){
        for (Product o: arrayList) {
            System.out.println(Arrays.toString(o.getObjectVector()));
        }
    }

    public void showTableData(){
        mainFrame.deleteRows();
        for (Product product: this.administrator.getMarket().getProductArrayList()) {
            mainFrame.createRow(this.fromProductToArray(product));
        }
    }

    public String obtainSelectedData(){
        return mainFrame.obtainSelectedData();
    }

    public void buyProducts(){

        Product productAux;
        for (int i = 0;i<this.administrator.getMarket().getProductArrayList().size();i++) {
            if (this.obtainSelectedData().equalsIgnoreCase(this.administrator.getMarket().getProductArrayList().get(i).getNameProduct())){
                productAux = this.administrator.getMarket().getProductArrayList().get(i);
                this.administrator.getMarket().getItemsBoughts().add(productAux);
            }
        }


    }

    public void printTestClient(Client client) {
        System.out.println(this.bringClientFromDialog().toString());
    }

    public void printTestProducts() {
        System.out.println(this.administrator.getMarket().getProductArrayList().toString());
    }

    public void setText() {
        mainFrame.createUserWelcome(this.bringClientFromDialog().getName());

    }

    public void setId(){
        mainFrame.createUserID(this.bringClientFromDialog().getDocument());
    }


    private void loadConfiguration() {
        if (config == null) {
            config = new HandlerLanguage(NAME_FILE_CONFIG);
        }
        try {
            config.loadLanguage();
        } catch (IOException e) {
            //JOptionPane.showMessageDialog(jfMainWindow, e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    private void loadLanguage() {
        try {
            config.loadLanguage();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(mainFrame, e.getMessage());
        }
    }

    private void saveConfig() {
        try {
            new HandlerLanguage(NAME_FILE_CONFIG).saveLanguage();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(mainFrame, e.getMessage());
        }
    }

    private void manageChangeLenguageUS() {
        try {
            changeToEnglish();
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(mainFrame, e1.getMessage());
        }
        manageChangeLanguage();
    }

    private void manageChangeLanguageES() {
        try {
            changeToSpanish();
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(mainFrame, e1.getMessage());
        }
        manageChangeLanguage();
    }

    public void changeToEnglish() throws IOException {
        HandlerLanguage.language = ENGLISH_PATH;
        saveConfig();
        loadLanguage();
    }

    public void changeToSpanish() throws IOException {
        HandlerLanguage.language = SPANISH_PATH;
        saveConfig();
        loadLanguage();
    }

    private void manageChangeLanguage() {
        mainFrame.changeLanguage();
    }

    public static void main(String[] args) {
        new MyPresenter();
    }
}
