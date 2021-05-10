package views.header;

import controllers.Commands;
import controllers.MyPresenter;
import utilities.HandlerLanguage;
import utilities.MyUtilities;
import views.ConstantGUI;


import javax.swing.*;
import java.awt.*;

public class JPanelButtons extends JPanel{
        private JButton addProduct, listProducts, deleteProduct, addToCart, proceedToBuy ;
        private JMenu showGraphics;
        private JButton addCart;

    public JPanelButtons(MyPresenter myPresenter) {
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        this.setBackground(Color.lightGray);
        //this.setBackground(Color.green);
        this.initComponents(myPresenter);
        this.setVisible(true);
    }

    public void initComponents(MyPresenter myPresenter){
        addProduct = new JButton();
        ImageIcon tempWorld = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.ICON_ADD_PRODUCT)).getImage());
        addProduct.setActionCommand(Commands.C_SHOW_DIALOG_PRODUCT.toString());
        addProduct.addActionListener(myPresenter);
        MyUtilities.setTextAndIconButtons(addProduct, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_ADD_PRODUCT),tempWorld,0,0,0,0);

        listProducts = new JButton();
        listProducts.setActionCommand(Commands.C_LIST_PRODUCTS.toString());
        listProducts.addActionListener(myPresenter);
        tempWorld = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.ICON_LIST)).getImage());
        MyUtilities.setTextAndIconButtons(listProducts, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_LIST_PRODUCTS),tempWorld,0,0,0,0);

        deleteProduct = new JButton();
        deleteProduct.setActionCommand(Commands.C_DELETE_PRODUCT.toString());
        deleteProduct.addActionListener(myPresenter);
        tempWorld = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.ICON_DELETE_PRODUCT2)).getImage());
        MyUtilities.setTextAndIconButtons(deleteProduct, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_DELETE_PRODUCT),tempWorld,0,0,0,0);

        addCart  =  new JButton("");
        addCart.setActionCommand(Commands.C_ADD_TO_CART.toString());
        addCart.addActionListener(myPresenter);
        MyUtilities.setTextAndIconButtons(addCart,HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUY),
                new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.ICON_ADD_CART)).getImage()),0,0,0,0);



        proceedToBuy = new JButton();
        proceedToBuy.setActionCommand(Commands.C_SHOW_CART.toString());
        proceedToBuy.addActionListener(myPresenter);
        tempWorld = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.ICON_PROCEED_BUY)).getImage());
        MyUtilities.setTextAndIconButtons(proceedToBuy, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SHOW_CART),tempWorld,0,0,0,0);




        this.add(addProduct);
        this.add(listProducts);
        this.add(deleteProduct);

        this.add(addCart);
        this.add(proceedToBuy);
        //this.add(changeToEnglish);



    }
    public void changeLanguage(){
        addProduct.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_ADD_PRODUCT));
        deleteProduct.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_DELETE_PRODUCT));
        listProducts.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_LIST_PRODUCTS));
        this.addCart.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_ADD_PRODUCT_TO_CART));
        proceedToBuy.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SHOW_CART));

    }


}


