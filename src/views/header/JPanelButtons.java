package views.header;

import controllers.Commands;
import controllers.MyPresenter;
import utilities.HandlerLanguage;
import utilities.MyUtilities;
import views.ConstantGUI;


import javax.swing.*;

public class JPanelButtons extends JPanel{
        private JButton addProduct, listProducts, deleteProduct, organiceProducts, changeToEnglish, changeToSpanish ;
        private JMenu showGraphics;

    public JPanelButtons(MyPresenter myPresenter) {
        //this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        //  this.setBackground(Color.green);
        this.initComponents(myPresenter);
        this.setVisible(true);
    }

    public void initComponents(MyPresenter myPresenter){
        addProduct = new JButton();
        ImageIcon tempWorld = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.ICON_ADD_PRODUCT)).getImage());
        addProduct.setActionCommand(Commands.C_SHOW_DIALOG_PRODUCT.toString());
        addProduct.addActionListener(myPresenter);
        MyUtilities.setTextAndIconButtons(addProduct, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_ADD_PRODUCT),tempWorld,0,0,0,0);

        listProducts = new JButton("");
        listProducts.setActionCommand(Commands.C_LIST_PRODUCTS.toString());
        listProducts.addActionListener(myPresenter);
        tempWorld = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.ICON_LIST)).getImage());
        MyUtilities.setTextAndIconButtons(listProducts, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_LIST_PRODUCTS),tempWorld,0,0,0,0);

        deleteProduct = new JButton("");
        deleteProduct.setActionCommand(Commands.C_DELETE_PRODUCT.toString());
        deleteProduct.addActionListener(myPresenter);
        tempWorld = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.ICON_DELETE_PRODUCT2)).getImage());
        MyUtilities.setTextAndIconButtons(deleteProduct, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_DELETE_PRODUCT),tempWorld,0,0,0,0);

        organiceProducts = new JButton("");
        organiceProducts.setActionCommand(Commands.C_ORGANICE_PRODUCTS.toString());
        organiceProducts.addActionListener(myPresenter);
        tempWorld = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.ICON_ORGANIZE)).getImage());
        MyUtilities.setTextAndIconButtons(organiceProducts, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_ORGANIZE),tempWorld,0,0,0,0);

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


        this.add(addProduct);
        this.add(listProducts);
        this.add(deleteProduct);
        this.add(organiceProducts);
        this.add(changeToSpanish);
        this.add(changeToEnglish);



    }
    public void changeLanguage(){
        addProduct.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_ADD_PRODUCT));
        deleteProduct.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_DELETE_PRODUCT));
        listProducts.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_LIST_PRODUCTS));
        organiceProducts.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_ORGANIZE));

    }


}


