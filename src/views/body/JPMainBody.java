package views.body;

import controllers.Commands;
import controllers.MyPresenter;
import utilities.HandlerLanguage;
import utilities.MyUtilities;
import views.ConstantGUI;

import javax.swing.*;
import java.awt.*;

public class JPMainBody extends JPanel {
    private JProductTable jProductTable;
    private JPButtonTableFilter jpButtonTableFilter;
    private JPGraphicsButtonPanel jpGraphicsButtonPanel;
    JButton jButtonShowGraphs;
    JButton jButtonTables;
    public JPMainBody(MyPresenter myPresenter) {

        this.setBackground(new Color(131,255,212));
        initComponents(myPresenter);
    }

    public void initComponents(MyPresenter myPresenter) {
        this.jProductTable = new JProductTable();
        this.jpButtonTableFilter = new JPButtonTableFilter(myPresenter);
        this.jpGraphicsButtonPanel = new JPGraphicsButtonPanel(myPresenter);
        this.showTableProducts();

        jButtonShowGraphs = new JButton("");
        ImageIcon temp = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.ICON_GRAPH)).getImage());
        jButtonShowGraphs.setActionCommand(Commands.C_SHOW_PANEL_GRAPHICS_BUTTONS.toString());
        jButtonShowGraphs.addActionListener(myPresenter);
        MyUtilities.setTextAndIconButtons(jButtonShowGraphs, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_SHOW_GRAPHS), temp, 0, 0, 0, 0);



        jButtonTables = new JButton("");
        temp = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.ICON_TABLE)).getImage());
        jButtonTables.setActionCommand(Commands.C_SHOW_PANEL_TABLES.toString());
        jButtonTables.addActionListener(myPresenter);
        MyUtilities.setTextAndIconButtons(jButtonTables, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_SHOW_TABLES), temp, 0, 0, 0, 0);


        this.add(jButtonShowGraphs);
        this.add(jButtonTables);
        this.add(jpButtonTableFilter);
    }

    public void changeIdiom(){
        jpButtonTableFilter.changeLanguage();
        jpGraphicsButtonPanel.changeLanguage();
        jButtonShowGraphs.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_SHOW_GRAPHS));
        jButtonTables.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_SHOW_TABLES));
    }

    public void showGraphicsButtons(){
        this.jpButtonTableFilter.setVisible(false);
        this.jpGraphicsButtonPanel.setVisible(true);
        this.add(jpGraphicsButtonPanel);

    }

    public void showTableButtons(){
        this.jpGraphicsButtonPanel.setVisible(false);
        this.jpButtonTableFilter.setVisible(true);
        this.add(jpButtonTableFilter);
    }
    public void showTableProducts() {

        this.add(jProductTable);

        revalidate();
    }



    public String obtainSelectedData(){
        return jProductTable.tryBuy();
    }

    public void createRow(Object [] data){
        this.jProductTable.createRow(data);
    }

    public void deleteRows(){
        jProductTable.eraseTable();
    }
}
