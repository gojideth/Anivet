package views.body;

import controllers.Commands;
import controllers.MyPresenter;
import utilities.HandlerLanguage;
import utilities.MyUtilities;
import views.ConstantGUI;

import javax.swing.*;
import java.awt.*;

public class JPGraphicsButtonPanel extends JPanel {
    JButton gMinorToHighestPrice, gMostSelled, gQuantities, filterByPrice;


    public JPGraphicsButtonPanel(MyPresenter myPresenter) {
        this.setLayout(new GridLayout(2, 2));
        //this.setBackground(Color.lightGray);
        this.setBackground(Color.green);
        this.setPreferredSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),200));
        this.initComponents(myPresenter);
        this.setVisible(true);

    }


    public void initComponents(MyPresenter myPresenter) {
        gMinorToHighestPrice = new JButton();
        ImageIcon tempWorld = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.ICON_GRAPH)).getImage());
        gMinorToHighestPrice.setActionCommand(Commands.C_SHOW_GRAPHIC_MINOR_TO_HIGH.toString());
        gMinorToHighestPrice.addActionListener(myPresenter);
        MyUtilities.setTextAndIconButtons(gMinorToHighestPrice, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SHOW_GRAPH_MINOR_TO_HIGHEST), tempWorld, 0, 0, 0, 0);

        gMostSelled = new JButton();
        gMostSelled.setActionCommand(Commands.C_SHOW_GRAPHIC_MOST_SELLED.toString());
        gMostSelled.addActionListener(myPresenter);
        tempWorld = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.ICON_GRAPH)).getImage());
        MyUtilities.setTextAndIconButtons(gMostSelled, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SHOW_GRAPH_MOST_SELLED), tempWorld, 0, 0, 0, 0);

        gQuantities = new JButton();
        gQuantities.setActionCommand(Commands.C_SHOW_GRAPHIC_MOST_SELLED.toString());
        gQuantities.addActionListener(myPresenter);
        tempWorld = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.ICON_GRAPH)).getImage());
        MyUtilities.setTextAndIconButtons(gQuantities, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SHOW_GRAPH_QUANTITIES), tempWorld, 0, 0, 0, 0);

        filterByPrice = new JButton("");
        filterByPrice.setActionCommand(Commands.C_SHOW_GRAPHIC_NIIDEA_QUANTITIES.toString());
        filterByPrice.addActionListener(myPresenter);
        MyUtilities.setTextAndIconButtons(filterByPrice, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SHOW_GRAPH_NOIDEA),
                new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.ICON_GRAPH)).getImage()), 0, 0, 0, 0);

        this.add(gMinorToHighestPrice);
        this.add(gMostSelled);
        this.add(gQuantities);
        this.add(filterByPrice);

    }

    public void changeLanguage() {
        gMinorToHighestPrice.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SHOW_GRAPH_MINOR_TO_HIGHEST));
        gMostSelled.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SHOW_GRAPH_MOST_SELLED));
        gQuantities.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SHOW_FILTER_BY_QUANTITY));
        filterByPrice.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SHOW_GRAPH_NOIDEA));

    }
}