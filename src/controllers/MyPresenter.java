package controllers;

import models.administration.Administrator;
import models.shop.*;
import org.json.simple.DeserializationException;
import persistence.JSonManager;
import utilities.HandlerLanguage;
import views.ConstantGUI;
import views.JFrameMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class MyPresenter implements ActionListener {
    private static final String SPANISH_PATH = "./resources/languages/languageES.properties";
    private static final String NAME_FILE_CONFIG = "./resources/config/config.init";
    private static final String ENGLISH_PATH = "./resources/languages/languageUS.properties";

    private JFrameMain mainFrame;
    private Administrator administrator;
    private HandlerLanguage config;
    private Bill bill;
    private JSonManager jSonManager;


    public MyPresenter() throws IOException, DeserializationException {
        loadConfiguration();
        this.administrator = new Administrator(new Market("Anivet"));
        this.mainFrame = new JFrameMain(this);
        this.bill = new Bill(LocalDate.now());
        this.jSonManager = new JSonManager();
        try {
            this.administrator.getMarket().myMarketFill(this.jSonManager.getProductList());
            addFromJsonToMarket();
            this.showTableData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DeserializationException e) {
            e.printStackTrace();
        }

        this.initComponents();
    }

    private void initComponents() {
        JOptionPane.showMessageDialog(null, "Por favor agregue a un administrador para continuar");
        while(this.administrator.getAdministratorPerson()== null){
            this.mainFrame.showAdminDialog();
            this.createAdminInAdministration(this.bringAdminFromDialog());

        }
        JOptionPane.showMessageDialog(null, "De tener cliente, agreguelo al sistema en el botón superior derecho ");
        System.out.println(this.administrator.getAdministratorPerson().toString());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Commands.valueOf(e.getActionCommand())) {
            case C_SHOW_HOMEPAGE:
                System.out.println("FUNCIONA");
                break;
            case I_CHANGE_TO_ENGLISH:
                manageChangeLenguageUS();
                this.printAnyArraylist(this.administrator.getMarket().removeDuplicates(this.administrator.getMarket().getProductArrayList()));
                break;
            case I_CHANGE_TO_SPANISH:
                manageChangeLanguageES();


                break;
            case C_SHOW_DIALOG_CLIENT:
                this.showDialogCreate();
                break;
            case CREATE_CLIENT_DIALOG:
                this.createClientInAdmin(this.bringClientFromDialog());
                this.setText();
                this.setId();
                break;
            case CREAT_ADMIN_DIALOG:
                this.mainFrame.closeAdminDialog();
                break;
            case C_SHOW_DIALOG_PRODUCT:
                this.showProductDialog();
                break;
            case C_LIST_PRODUCTS:
                this.showTableData();
                break;
            case C_ADD_TO_CART:
                this.buyProducts();
                this.printAnyArraylist(this.administrator.getMarket().getItemsBoughts());
                JOptionPane.showMessageDialog(null, "Agregado con éxito", "Shopping Cart", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.GIF_CHECK)).getImage()));

                break;
            case C_SHOW_CART:
                this.mainFrame.showDialogCart();
                this.fillCartTable();

                break;
            case C_PROCEED_BUY:
                this.closeDialogCart();

                //JOptionPane.showMessageDialog(null,this.generateBill() );
                JOptionPane.showMessageDialog(null, this.generateBill(), "Anivet Factura", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.GIF)).getImage()));
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

    //DialogCart

    public void showCartDialog(){
        this.mainFrame.showDialogCart();
        this.fillCartTable();
        testDataIFadd();


    }

    public void addFromJsonToMarket() throws IOException, DeserializationException {
        this.administrator.getMarket().myMarketFill(this.jSonManager.getProductList());
        this.printAnyArraylist(this.administrator.getMarket().getProductArrayList());
    }


    public StringBuilder printBeautifullArrays(ArrayList <Product> productArrayList){
        StringBuilder out = new StringBuilder();
        for (Product product: productArrayList) {
            out.append("Nombre del producto: ").append(product.getNameProduct()).append(", Precio individual: ").append(product.getPrice()).append("\n");
        }
        return out;
    }

    public void brindProductsAndSetThem(ArrayList <Product>productArrayList){
        for (Product product: productArrayList) {
            this.administrator.getMarket().addProduct(product);
        }
    }

    public String generateBill(){
        String aux = "";
        aux = "Nombre del cliente: " + this.bill.getClient().getName() + "\nProductos comprados: "  + this.printBeautifullArrays(this.bill.getProductsBoughts())
                + "\nTe atendió: " + this.bill.getAdministratorPerson().getName() + "\nQue tengas un gran dia :3";
        return aux;
    }

    public void closeDialogCart(){
        this.mainFrame.closeDialogCart();
    }

    public void fillCartTable(){
        this.mainFrame.eraseBillTableData();
        for (Product product: this.administrator.getMarket().getItemsBoughts()) {
            this.mainFrame.createBillTableData(this.fromProductToBill(product));
            this.bill.getProductsBoughts().add(product);
        }
        this.setClientAdmin();
    }

    public void showTableData(){
        mainFrame.deleteRows();
        for (Product product: this.administrator.getMarket().getProductArrayList()) {
            mainFrame.createRow(this.fromProductToArray(product));
        }
    }

    public void setClientAdmin(){
        this.bill.createClient(this.administrator.getClient());
        this.bill.createAdmin(this.administrator.getAdministratorPerson());
    }

    public void testDataIFadd(){
        this.mainFrame.createBillTableData(new Object[]{
                "hola"
        });
    }

    //DialogCLIENT

    public void showDialogCreate() {
        mainFrame.showDialogCreate();
    }
    //DialogAdmin

    public void showAdminDialog(){
        mainFrame.showAdminDialog();
    }

    private AdministratorPerson bringAdminFromDialog(){
        return this.mainFrame.createAdminFromDialog();
    }

    public void closeDialogAdmin(){
        this.mainFrame.closeAdminDialog();
    }

    public void createAdminInAdministration(AdministratorPerson administratorPerson){
        this.administrator.createAdmin(administratorPerson);
        this.mainFrame.closeAdminDialog();
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
        mainFrame.blankDialogProduct();
        mainFrame.closeDialogProduct();
    }

    public Product bringProductFromDialog() {
        return mainFrame.createProductFromDialog();
    }

    public void receiveProductAndAddIt() {
        this.addProductValidater(this.bringProductFromDialog());
    }

    public void addProductValidater(Product product) {
        for (int i = 0; i<this.administrator.getMarket().getProductArrayList().size();i++) {
            if (product.getNameProduct().equalsIgnoreCase(this.administrator.getMarket().getProductArrayList().get(i).getNameProduct())) {
                this.administrator.getMarket().getProductArrayList().get(i).addQuantAvailable();
            }

        }
        this.administrator.getMarket().getProductArrayList().add(product);
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
                String.valueOf(product.getQuantityPresentationForSelling()),
                String.valueOf(product.getProviderPrice()),
                String.valueOf(product.getProvider()),
                String.valueOf(product.getQuantityPresentation().getProductDenomination()),
                String.valueOf(product.getQuantityPresentation().getAmount()),
                String.valueOf(product.getSanitaryLicense()),
                String.valueOf(product.getTypeProduct()),
        };
    }

    public Object[] fromProductToBill(Product product){
        return new Object[]{
                String.valueOf(product.getNameProduct()),
                String.valueOf(product.getPrice()),
                String.valueOf(product.getQuantityPresentation().getAmount()),
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

    public static void main(String[] args) throws IOException, DeserializationException {
        new MyPresenter();
    }
}
