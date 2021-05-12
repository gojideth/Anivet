package controllers;

import models.administration.Administrator;
import models.shop.*;
import org.json.simple.DeserializationException;
import persistence.BillWriter;
import persistence.JSonManager;
import utilities.BeautifulBill;
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
import java.util.Collections;
import java.util.Comparator;

public class MyPresenter implements ActionListener {
    private static final String SPANISH_PATH = "./resources/languages/languageES.properties";
    private static final String NAME_FILE_CONFIG = "resources/config/config.init";
    private static final String ENGLISH_PATH = "./resources/languages/languageUS.properties";

    private JFrameMain mainFrame;
    private Administrator administrator;
    private HandlerLanguage config;
    private Bill bill;
    private JSonManager jSonManager;
    private BillWriter billWriter;

    public MyPresenter() throws IOException, DeserializationException {
        loadConfiguration();
        this.administrator = new Administrator(new Market("Anivet"));
        this.mainFrame = new JFrameMain(this);
        this.bill = new Bill(LocalDate.now());
        this.jSonManager = new JSonManager();
        this.billWriter = new BillWriter();
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
        while (this.administrator.getAdministratorPerson() == null && this.administrator.getClient() == null) {
            this.mainFrame.showAdminDialog();
            this.createAdminInAdministration(this.bringAdminFromDialog());
            JOptionPane.showMessageDialog(null, "Por favor agregue a un cliente");
            this.showDialogCreate();
            this.setText();
            this.setId();

        }
        System.out.println(this.administrator.getAdministratorPerson().toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int aux[] = this.createNumberBelowPrice();
        int auxSecond[] = this.createDataForQuantities();
        switch (Commands.valueOf(e.getActionCommand())) {
            case C_SHOW_HOMEPAGE:
                System.out.println("FUNCIONA");
                break;
            case I_CHANGE_TO_ENGLISH:
                manageChangeLenguageUS();
                // this.printAnyArraylist(this.administrator.getMarket().removeDuplicates(this.administrator.getMarket().getProductArrayList()));
                break;
            case I_CHANGE_TO_SPANISH:
                manageChangeLanguageES();


                break;
            case C_SHOW_PANEL_GRAPHICS_BUTTONS:
                this.mainFrame.showGraphicsButtons();
                break;
            case C_SHOW_PANEL_TABLES:
                this.mainFrame.showTableButtons();
                break;
            case C_SHOW_DIALOG_CLIENT:
                this.showDialogCreate();
                break;
            case CREATE_CLIENT_DIALOG:
                this.createClientInAdmin(this.bringClientFromDialog());
                this.setText();
                this.setId();
                break;
            case LOGOUT:
                this.administrator.makeNull();
                this.showDialogCreate();
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
                this.writeBillFile();
                JOptionPane.showMessageDialog(null, "Factura generada en: " + this.billWriter.getMyObj().getPath());
                break;

            case CREATE_PRODUCT_DIALOG_AND_CLOSE:
                this.receiveProductAndAddIt();

                this.showTableData();
                this.closeProductDialog();
                //this.printAnyArraylist(this.administrator.getMarket().getProductArrayList());

                break;
            case C_SHOW_FILTER_TYPE:
                this.mainFrame.deleteRowsFilterType();
                this.mainFrame.showDialogFilterType();
                break;

            case C_SHOW_FILTER_QUANTITY_AVAILABLE:
                this.mainFrame.showDialogFilterQuantity();
                break;
            case C_SHOW_FILTER_PRESENTATION:
                this.mainFrame.showDialogDenomination();

                break;
            case C_SHOW_FILTER_PRICE:
                this.mainFrame.showPricesDialog();
                break;

            case C_SHOW_TABLE:
                mainFrame.showTableProducts();
                break;
            case C_DELETE_PRODUCT:
                this.deleteProduct(JOptionPane.showInputDialog(null));
                this.showTableData();
                break;
            case C_RETURN_SELECTED_TYPE_PRODUCT:
                showFilteredTypedProducts(this.mainFrame.returnSelectedItem());
                this.mainFrame.fireTableDataChange();
                break;

            case C_RETURN_SELECTED_QUANTITY_PRODUCT:
                this.showFilteredQuantityProducts(this.mainFrame.returnSelectedItemQuantity());
                this.mainFrame.fireTableDataQuantityChange();
                break;
            case C_RETURN_SELECTED_DENOMINATION:
                this.showFilteredDenomination(this.mainFrame.returnSelectedDenominationItem());
                this.mainFrame.fireTableDataDenomination();
                break;
            case C_RETURN_SELECTED_RANGES:
                this.showFilteredRangePrice(this.mainFrame.returnRanges());
                this.mainFrame.fireTablePrices();
                break;
            case C_CLOSE_DIALOG_TYPE:
                this.mainFrame.closeFilterType();
                break;
            case C_CLOSE_DIALOG_QUANTITY:
                this.mainFrame.closeQuantityDialog();
                break;
            case C_CLOSE_DIALOG_DENOMINATION:
                this.mainFrame.closeDialogDenomination();
                break;
            case C_CLOSE_DIALOG_PRICES:
                this.mainFrame.closeDialogPrices();
                break;
            case C_SHOW_GRAPHIC_DENOMINATION:
                this.mainFrame.createGraphByDenominations(this.createNumberDenominationGrams(), this.createNumberDenominationUnits());
                break;
            case C_SHOW_GRAPHIC_RANGED_PRICES:
                this.mainFrame.createGraphByRangedPrice(aux[0], aux[1]);
                break;
            case C_SHOW_GRAPHIC_QUANTITIES:
                this.mainFrame.createGraphByQuantityPresentationForSelling(auxSecond);
                break;
            case C_SHOW_UTILITIES:

               this.mainFrame.createGraphByUtility(this.takeHigherValues(this.createArrayUtility()),this.extractNames(this.createArrayUtilityProduct()));
                break;

            default:
                break;

        }
    }

    //DialogCart
    public ArrayList<Integer> createArrayUtility(){
        ArrayList <Integer> out= new ArrayList<>();
        for (Product product:this.administrator.getMarket().getProductArrayList()) {
            out.add(product.obtainUtility());
        }
        Collections.sort(out);
        return out;
    }
    public ArrayList<Product> createArrayUtilityProduct(){
        ArrayList<Product> productArrayList = new ArrayList<>(this.administrator.getMarket().getProductArrayList());
        productArrayList.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.obtainUtility()- o2.obtainUtility();
            }
        });
        return productArrayList;
    }

    public ArrayList<String> extractNames(ArrayList<Product> productArrayList){
        ArrayList <String> outAux = new ArrayList<>();
        for (int i = productArrayList.size()-3; i < productArrayList.size(); i++) {
            outAux.add(productArrayList.get(i).getNameProduct());
        }
        return outAux;
    }

    public void extractTestNames(){
        for (String s:this.extractNames(this.createArrayUtilityProduct())) {
            System.out.println(s);
        }
    }

    public ArrayList<Integer> takeHigherValues(ArrayList <Integer> arrayList){
        ArrayList <Integer> out= new ArrayList<>();
        for (int i = (arrayList.size()-3); i <arrayList.size() ; i++) {
            out.add(arrayList.get(i));
        }
        //this.printAnyArraylistObj(out);
        return out;
    }

    public int[] createDataForQuantities() {
        int outOne = 0, outTwo = 0, outThree = 0, outFourth = 0, outFive = 0;
        for (Product product : this.administrator.getMarket().getProductArrayList()) {
            switch (product.getQuantityPresentationForSelling()) {
                case 1:
                    outOne++;
                    break;
                case 2:
                    outTwo++;
                    break;
                case 3:
                    outThree++;
                    break;
                case 4:
                    outFourth++;
                    break;
                case 5:
                    outFive++;
                    break;

            }
        }
        return new int[]{
                outOne, outTwo, outThree, outFourth, outFive
        };
    }


    public int[] createNumberBelowPrice() {
        int out = 0;
        int secondCounter = 0;
        for (Product product : this.administrator.getMarket().getProductArrayList()) {
            if (product.getPrice() > 50000) {
                out++;
            } else {
                secondCounter++;
            }
        }
        return new int[]{
                out, secondCounter
        };
    }


    public int createNumberDenominationGrams() {
        int out = 0;
        for (Product product : this.administrator.getMarket().getProductArrayList()) {
            if (product.getQuantityPresentation().getProductDenomination().equalsIgnoreCase("UNITS")) {
                out++;
            }
        }
        return out;
    }

    public int createNumberDenominationUnits() {
        int out = 0;
        for (Product product : this.administrator.getMarket().getProductArrayList()) {
            if (product.getQuantityPresentation().getProductDenomination().equalsIgnoreCase("GRAMS")) {
                out++;
            }
        }
        return out;
    }

    public void showCartDialog() {
        this.mainFrame.showDialogCart();
        this.fillCartTable();
        testDataIFadd();
    }

    public void showFilteredRangePrice(double[] data) {
        this.mainFrame.eraseColumnPricesTable();
        for (Product product : this.administrator.getMarket().getProductArrayList()) {
            if (product.getPrice() >= data[0] && product.getPrice() <= data[1]) {
                this.mainFrame.addObjectToTablePrices(this.fromProductToArray(product));
            }
        }
    }


    public void showFilteredDenomination(String denominationDesired) {
        this.mainFrame.eraseColumnDenominationTable();
        for (Product product : this.administrator.getMarket().getProductArrayList()) {
            if (product.getQuantityPresentation().getProductDenomination().equalsIgnoreCase(denominationDesired)) {
                this.mainFrame.addObjectToTableDenomination(this.fromProductToArray(product));
            }

        }
    }

    public void showFilteredTypedProducts(String typeProduct) {
        this.mainFrame.deleteRowsFilterType();
        for (Product product : this.administrator.getMarket().getProductArrayList()) {
            if (typeProduct.equalsIgnoreCase(product.getTypeProduct())) {
                this.mainFrame.addColumnFilterType(this.fromProductToArray(product));
            }
        }

    }

    public void showFilteredQuantityProducts(int quantityDesired) {
        this.mainFrame.eraseColumnQuantityRows();
        for (Product product : this.administrator.getMarket().getProductArrayList()) {
            if ((quantityDesired) == product.getQuantityPresentation().getAmount()) {
                this.mainFrame.addColumnToQuantityTable(this.fromProductToArray(product));
            }
        }
    }


    public void addFromJsonToMarket() throws IOException, DeserializationException {
        this.administrator.getMarket().myMarketFill(this.jSonManager.getProductList());
        //this.printAnyArraylist(this.administrator.getMarket().getProductArrayList());
    }

    public void writeBillFile() {
        this.billWriter.createBilLFile();
        this.billWriter.writeExistingFile(this.returnAllBillInfo());

    }

    public String returnAllBillInfo() {
        return BeautifulBill.createBeautifullBill(this.printBeautifullArrays(this.bill.getProductsBoughts()),
                this.bill.getAdministratorPerson().getName(),
                this.bill.getClient().getName(),
                this.bill.returnAllPrices(),
                LocalDate.now());
    }


    public StringBuilder printBeautifullArrays(ArrayList<Product> productArrayList) {
        StringBuilder out = new StringBuilder();
        for (Product product : productArrayList) {
            out.append("Nombre del producto: ").append(product.getNameProduct()).append(", Precio individual: ").append(product.getPrice()).append("\n");
        }
        return out;
    }

    public void brindProductsAndSetThem(ArrayList<Product> productArrayList) {
        for (Product product : productArrayList) {
            this.administrator.getMarket().addProduct(product);
        }
    }

    public String generateBill() {
        String aux = "";
        aux = "Nombre del cliente: " + this.bill.getClient().getName() + "\nProductos comprados: " + this.printBeautifullArrays(this.bill.getProductsBoughts())
                + "\nTe atendió: " + this.bill.getAdministratorPerson().getName() + "\nQue tengas un gran dia :3";
        return aux;
    }


    public void closeDialogCart() {
        this.mainFrame.closeDialogCart();
    }

    public void fillCartTable() {
        this.mainFrame.eraseBillTableData();
        for (Product product : this.administrator.getMarket().getItemsBoughts()) {
            this.mainFrame.createBillTableData(this.fromProductToBill(product));
            this.bill.getProductsBoughts().add(product);
        }
        this.setClientAdmin();
    }

    public void showTableData() {
        mainFrame.deleteRows();
        for (Product product : this.administrator.getMarket().getProductArrayList()) {
            mainFrame.createRow(this.fromProductToArray(product));
        }
    }

    public void setClientAdmin() {
        this.bill.createClient(this.administrator.getClient());
        this.bill.createAdmin(this.administrator.getAdministratorPerson());
    }

    public void testDataIFadd() {
        this.mainFrame.createBillTableData(new Object[]{
                "hola"
        });
    }

    //DialogCLIENT

    public void showDialogCreate() {
        mainFrame.showDialogCreate();
    }
    //DialogAdmin

    public void showAdminDialog() {
        mainFrame.showAdminDialog();
    }

    private AdministratorPerson bringAdminFromDialog() {
        return this.mainFrame.createAdminFromDialog();
    }

    public void closeDialogAdmin() {
        this.mainFrame.closeAdminDialog();
    }

    public void createAdminInAdministration(AdministratorPerson administratorPerson) {
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
        for (int i = 0; i < this.administrator.getMarket().getProductArrayList().size(); i++) {
            if (product.getNameProduct().equalsIgnoreCase(this.administrator.getMarket().getProductArrayList().get(i).getNameProduct())) {
                System.out.println("ENTRO AL IF" + product.toString());
                this.administrator.getMarket().getProductArrayList().get(i).addQuantAvailable();
            }

        }
        System.out.println("acá pasó el bucle");
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

    public Object[] fromProductToBill(Product product) {
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

    public void printAnyArraylist(ArrayList<Product> arrayList) {
        for (Product o : arrayList) {
            System.out.println(Arrays.toString(o.getObjectVector()));
        }
    }
    public void printAnyArraylistObj(ArrayList<Integer> arrayList) {
        for (Object o : arrayList) {
            System.out.println(o);
        }
    }

    public String obtainSelectedData() {
        return mainFrame.obtainSelectedData();
    }

    public void buyProducts() {
        Product productAux;
        for (int i = 0; i < this.administrator.getMarket().getProductArrayList().size(); i++) {
            if (this.obtainSelectedData().equalsIgnoreCase(this.administrator.getMarket().getProductArrayList().get(i).getNameProduct())) {
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

    public void setId() {
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
