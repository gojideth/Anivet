package views.body;

import controllers.Commands;
import controllers.MyPresenter;
import utilities.HandlerLanguage;
import utilities.MyUtilities;
import views.ConstantGUI;

import javax.swing.*;
import java.awt.*;

public class JPGraphicsButtonPanel extends JPanel {
    JButton gUtility, gPresentationSelling, gQuantitiesDenomination, filterByPrice;


    public JPGraphicsButtonPanel(MyPresenter myPresenter) {
        this.setLayout(new GridLayout(2, 2));
        this.setBackground(new Color(131,255,212));
        this.setPreferredSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),200));
        this.initComponents(myPresenter);
        this.setVisible(true);

    }


    public void initComponents(MyPresenter myPresenter) {
        gUtility = new JButton();
        ImageIcon tempWorld = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.ICON_GRAPH)).getImage());
        gUtility.setActionCommand(Commands.C_SHOW_UTILITIES.toString());
        gUtility.addActionListener(myPresenter);
        MyUtilities.setTextAndIconButtons(gUtility, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SHOW_GRAPH_UTILITIES), tempWorld, 0, 0, 0, 0);

        gPresentationSelling = new JButton();
        gPresentationSelling.setActionCommand(Commands.C_SHOW_GRAPHIC_QUANTITIES.toString());
        gPresentationSelling.addActionListener(myPresenter);
        tempWorld = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.ICON_GRAPH)).getImage());
        MyUtilities.setTextAndIconButtons(gPresentationSelling, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SHOW_GRAPH_MOST_SELLED), tempWorld, 0, 0, 0, 0);

        gQuantitiesDenomination = new JButton();
        gQuantitiesDenomination.setActionCommand(Commands.C_SHOW_GRAPHIC_DENOMINATION.toString());
        gQuantitiesDenomination.addActionListener(myPresenter);
        tempWorld = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.ICON_GRAPH)).getImage());
        MyUtilities.setTextAndIconButtons(gQuantitiesDenomination, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SHOW_GRAPH_DENOMINATION), tempWorld, 0, 0, 0, 0);

        filterByPrice = new JButton("");
        filterByPrice.setActionCommand(Commands.C_SHOW_GRAPHIC_RANGED_PRICES.toString());
        filterByPrice.addActionListener(myPresenter);
        MyUtilities.setTextAndIconButtons(filterByPrice, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SHOW_GRAPH_RANGED_PRICE),
                new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.ICON_GRAPH)).getImage()), 0, 0, 0, 0);

        this.add(gUtility);
        this.add(gPresentationSelling);
        this.add(gQuantitiesDenomination);
        this.add(filterByPrice);

    }

    public void changeLanguage() {
        gUtility.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SHOW_GRAPH_UTILITIES));
        gPresentationSelling.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SHOW_GRAPH_MOST_SELLED));
        gQuantitiesDenomination.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SHOW_GRAPH_DENOMINATION));
        filterByPrice.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SHOW_GRAPH_RANGED_PRICE));

    }
}