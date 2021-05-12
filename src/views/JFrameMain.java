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
import views.dialogs.filters.DialogFilterByPresentation;
import views.dialogs.filters.DialogFilterByQuantity;
import views.dialogs.filters.DialogFilterByRangePrice;
import views.dialogs.filters.DialogFilterType;
import views.dialogs.graphs.GraphByDenomination;
import views.dialogs.graphs.GraphByRangeMediumPrice;
import views.dialogs.graphs.GraphQuantityPresentionSelled;
import views.dialogs.graphs.GraphUtility;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JFrameMain extends JFrame {
    private JPMain mainPanel;
    private JScrollPane jScrollPane;
    private DialogUser dialogUser;
    private DialogProduct dialogProduct;
    private DialogAdmin dialogAdmin;
    private DialogCartShopping dialogCartShopping;

    //Dialogs filters table
    private DialogFilterType dialogFilterType;
    private DialogFilterByQuantity dialogFilterByQuantity;
    private DialogFilterByPresentation dialogFilterByPresentation;
    private DialogFilterByRangePrice dialogFilterByRangePrice;

    //Dialog Graphic
    private GraphByDenomination graphByDenomination;
    private GraphByRangeMediumPrice graphByRangeMediumPrice;
    private GraphQuantityPresentionSelled graphQuantityPresentionSelled;
    private GraphUtility graphUtility;

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

        this.dialogFilterType = new DialogFilterType(myPresenter);
        this.dialogFilterByQuantity = new DialogFilterByQuantity(myPresenter);
        this.dialogFilterByPresentation = new DialogFilterByPresentation(myPresenter);
        this.dialogFilterByRangePrice = new DialogFilterByRangePrice(myPresenter);




        this.add(jScrollPane);
    }

    public void changeLanguage() {
        this.setTitle( HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_MAIN_WINDOW ));
        mainPanel.changeLanguage();
        mainPanel.changeButtonsIdiom();
    }

    public void createGraphByDenominations(int value1, int value2){
        this.graphByDenomination = new GraphByDenomination(value1,value2);
        this.graphByDenomination.setVisible(true);
    }

    public void closeDialogDenominationGraph(){
        this.graphByDenomination.dispose();
    }

    public void createGraphByRangedPrice(int valueOne,int valueTwo){
        this.graphByRangeMediumPrice = new GraphByRangeMediumPrice(valueOne,valueTwo);
        this.graphByRangeMediumPrice.setVisible(true);
    }

    public void closeDialogGraphRangedPrice(){
        this.graphByRangeMediumPrice.dispose();
    }

    public void createGraphByQuantityPresentationForSelling(int[] data){
        this.graphQuantityPresentionSelled = new GraphQuantityPresentionSelled(data);
        this.graphQuantityPresentionSelled.setVisible(true);
    }

    public void createGraphByUtility(ArrayList<Integer> arrayList, ArrayList<String> stringArrayList){
        this.graphUtility = new GraphUtility(arrayList,stringArrayList);
        this.graphUtility.setVisible(true);
    }



    public void fireTablePrices(){
        this.dialogFilterByRangePrice.fireData();
    }

    public void showPricesDialog(){
        this.dialogFilterByRangePrice.showDialog();
    }

    public double[] returnRanges(){
        return this.dialogFilterByRangePrice.returnChosenType();
    }

    public void addObjectToTablePrices(Object [] data){
        this.dialogFilterByRangePrice.createRow(data);
    }

    public void eraseColumnPricesTable(){
        this.dialogFilterByRangePrice.eraseTable();
    }

    public void closeDialogPrices(){
        this.dialogFilterByRangePrice.dispose();
    }

    ///////////////////////////////////////////////////////////////////
    public void fireTableDataDenomination(){
        this.dialogFilterByPresentation.fireData();
    }

    public void showDialogDenomination(){
        this.dialogFilterByPresentation.setVisible(true);
    }

    public String returnSelectedDenominationItem(){
        return this.dialogFilterByPresentation.returnChosenType();
    }

    public void addObjectToTableDenomination(Object[] data){
        this.dialogFilterByPresentation.createRow(data);
    }

    public void eraseColumnDenominationTable(){
        this.dialogFilterByPresentation.eraseTable();
    }

    public void closeDialogDenomination(){
        this.dialogFilterByPresentation.dispose();
    }

    /////////////////////////////////////////////////////
    public void fireTableDataQuantityChange(){
        this.dialogFilterByQuantity.fireData();
    }

    public void showDialogFilterQuantity(){
        this.dialogFilterByQuantity.setVisible(true);
    }

    public int returnSelectedItemQuantity(){
        return this.dialogFilterByQuantity.returnChosenType();
    }

    public void addColumnToQuantityTable(Object[]data){
        this.dialogFilterByQuantity.createRow(data);
    }

    public void eraseColumnQuantityRows(){
        this.dialogFilterByQuantity.eraseTable();
    }

    public void closeQuantityDialog(){
        this.dialogFilterByQuantity.dispose();
    }


//////////////////////////////////////////////





    public void fireTableDataChange(){
        this.dialogFilterType.fireData();
    }
    public void showDialogFilterType(){
        this.dialogFilterType.setVisible(true);
    }

    public String returnSelectedItem(){
        return this.dialogFilterType.returnChosenType();
    }

    public void addColumnFilterType(Object [] data){
        this.dialogFilterType.createRow(data);

    }
    public void deleteRowsFilterType(){
        this.dialogFilterType.eraseTable();
    }

    public void closeFilterType(){
        this.dialogFilterType.dispose();
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
