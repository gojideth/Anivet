package views.dialogs.filters;

import controllers.Commands;
import controllers.MyPresenter;
import models.shop.Denomination;
import views.Constants;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DialogFilterByPresentation extends JDialog {
    private DefaultTableModel defaultTableModel;
    private JTable jTable;
    private JScrollPane jScrollPane;
    private JButton jButtonSelected,jCloseButton;
    private JPanel panelConainter;
    private JComboBox<Denomination> comboDenominationProduct;


    public DialogFilterByPresentation (MyPresenter myPresenter) {
        panelConainter = new JPanel();
        panelConainter.setLayout(new BoxLayout(panelConainter,BoxLayout.Y_AXIS));
        setSize(700,600);
        this.initComponents(myPresenter);

        this.add(panelConainter);
        this.setVisible(false);



    }

    public void fireData(){
        defaultTableModel.fireTableDataChanged();
    }

    public void initComponents(MyPresenter myPresenter){
        String[] rowNames = {Constants.NAME_PRODUCT, Constants.PRICE, Constants.QUANTITY_AVAILABLE, Constants.PROVIDER_PRICE, Constants.PROVIDER, Constants.QUANTITY_PRESENTATION,Constants.AVAILABLE_PRODUCTS, Constants.LICENSE, Constants.TYPE_PRODUCT };
        defaultTableModel = new DefaultTableModel();


        defaultTableModel.setColumnIdentifiers(rowNames);


        jTable = new JTable();

        jTable.setModel(defaultTableModel); //Le agrego a mi cascarón la tabla que contendrá la información
        jTable.setAutoCreateRowSorter(true);
        //Modifico el header de mi tabla
        jTable.getTableHeader().setReorderingAllowed(false);  //--> El usuario no pueda re organizar columnas
        jTable.getTableHeader().setBackground(Color.gray); //--> Modifico color de fuente y color de fondo de header
        jTable.getTableHeader().setForeground(Color.white);

        //Ahora modifico el contenido de la tabla
        jTable.setBackground(Color.lightGray);
        jTable.setFillsViewportHeight(false); //En pocas palabras que no se achiquite la tabla mas que la vista del frame
        jTable.setRowHeight(30);

        this.jButtonSelected = new JButton("BUSCAR");
        this.jButtonSelected.setActionCommand(Commands.C_RETURN_SELECTED_DENOMINATION.toString());
        this.jButtonSelected.addActionListener(myPresenter);

        this.jCloseButton = new JButton("CERRAR");
        this.jCloseButton.setActionCommand(Commands.C_CLOSE_DIALOG_DENOMINATION.toString());
        this.jCloseButton.addActionListener(myPresenter);

        this.jScrollPane = new JScrollPane(jTable);

        comboDenominationProduct = new JComboBox<>(Denomination.values());
        comboDenominationProduct.setBorder(BorderFactory.createTitledBorder("Presentación del producto "));



        this.panelConainter.add(jScrollPane);
        this.panelConainter.add(comboDenominationProduct);
        this.panelConainter.add(jButtonSelected);
        this.panelConainter.add(jCloseButton);


    }
    public void eraseTable() {
        this.defaultTableModel.setNumRows(0);
    }

    /**
     * Creo un metodo que me AGREGUE una hilera de datos
     */
    public void createRow(Object[] data) {
        this.defaultTableModel.addRow(data);
    }


    public void showDialog(){
        this.setVisible(true);
    }

    public String returnChosenType(){
        return String.valueOf(comboDenominationProduct.getSelectedItem());
    }
}
