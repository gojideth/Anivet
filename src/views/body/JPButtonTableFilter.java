package views.body;

import controllers.Commands;
import controllers.MyPresenter;
import utilities.HandlerLanguage;
import utilities.MyUtilities;
import views.ConstantGUI;

import javax.swing.*;
import java.awt.*;

public class JPButtonTableFilter extends JPanel {
    JButton filterByTypeProduct, filterByPresentation, filterByQuantityAvailable, filterByPrice;


    public JPButtonTableFilter(MyPresenter myPresenter) {
        this.setLayout(new GridLayout(2, 2));
        //this.setBackground(Color.lightGray);
        this.setBackground(Color.green);
        this.setPreferredSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),200));
        this.initComponents(myPresenter);
        this.setVisible(true);

    }


    public void initComponents(MyPresenter myPresenter) {
        filterByTypeProduct = new JButton();
        ImageIcon tempWorld = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.ICON_TABLE)).getImage());
        filterByTypeProduct.setActionCommand(Commands.C_SHOW_FILTER_TYPE.toString());
        filterByTypeProduct.addActionListener(myPresenter);
        MyUtilities.setTextAndIconButtons(filterByTypeProduct, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SHOW_FILTER_TYPE_PRODUCT), tempWorld, 0, 0, 0, 0);

        filterByPresentation = new JButton();
        filterByPresentation.setActionCommand(Commands.C_SHOW_FILTER_PRESENTATION.toString());
        filterByPresentation.addActionListener(myPresenter);
        tempWorld = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.ICON_TABLE)).getImage());
        MyUtilities.setTextAndIconButtons(filterByPresentation, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SHOW_FILTER_BY_PRESENTATION), tempWorld, 0, 0, 0, 0);

        filterByQuantityAvailable = new JButton();
        filterByQuantityAvailable.setActionCommand(Commands.C_SHOW_FILTER_QUANTITY_AVAILABLE.toString());
        filterByQuantityAvailable.addActionListener(myPresenter);
        tempWorld = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.ICON_TABLE)).getImage());
        MyUtilities.setTextAndIconButtons(filterByQuantityAvailable, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SHOW_FILTER_BY_QUANTITY), tempWorld, 0, 0, 0, 0);

        filterByPrice = new JButton("");
        filterByPrice.setActionCommand(Commands.C_SHOW_FILTER_PRICE.toString());
        filterByPrice.addActionListener(myPresenter);
        MyUtilities.setTextAndIconButtons(filterByPrice, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SHOW_FILTER_BY_PRICE),
                new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.ICON_TABLE)).getImage()), 0, 0, 0, 0);

        this.add(filterByTypeProduct);
        this.add(filterByPresentation);
        this.add(filterByQuantityAvailable);
        this.add(filterByPrice);

    }

    public void changeLanguage() {
        filterByTypeProduct.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SHOW_FILTER_TYPE_PRODUCT));
        filterByPresentation.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SHOW_FILTER_BY_PRESENTATION));
        filterByQuantityAvailable.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SHOW_FILTER_BY_QUANTITY));
        filterByPrice.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SHOW_FILTER_BY_PRICE));

    }
}
