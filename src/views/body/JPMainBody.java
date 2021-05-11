package views.body;

import controllers.Commands;
import controllers.MyPresenter;

import javax.swing.*;
import java.awt.*;

public class JPMainBody extends JPanel {
    private JProductTable jProductTable;
    private JPButtonTableFilter jpButtonTableFilter;
    private JPGraphicsButtonPanel jpGraphicsButtonPanel;

    public JPMainBody(MyPresenter myPresenter) {
        //this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBackground(Color.white);
        initComponents(myPresenter);
    }

    public void initComponents(MyPresenter myPresenter) {
        this.jProductTable = new JProductTable();
        this.jpButtonTableFilter = new JPButtonTableFilter(myPresenter);
        this.jpGraphicsButtonPanel = new JPGraphicsButtonPanel(myPresenter);
        this.showTableProducts();
        JButton jButtonShowGraphs = new JButton("Reportes de graficos");
        jButtonShowGraphs.setActionCommand(Commands.C_SHOW_PANEL_GRAPHICS_BUTTONS.toString());
        jButtonShowGraphs.addActionListener(myPresenter);

        JButton jButtonTables = new JButton("Filtros en tablas");
        jButtonTables.setActionCommand(Commands.C_SHOW_PANEL_TABLES.toString());
        jButtonTables.addActionListener(myPresenter);


        this.add(jButtonShowGraphs);
        this.add(jButtonTables);
        this.add(jpButtonTableFilter);
    }

    public void changeIdiom(){
        jpButtonTableFilter.changeLanguage();
        jpGraphicsButtonPanel.changeLanguage();
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
        //this.removeAll();
        //this.repaint();
        //this.add(jProductTable,BorderLayout.PAGE_START);
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
