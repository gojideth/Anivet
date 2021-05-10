package views.dialogs;

import controllers.Commands;
import controllers.MyPresenter;
import views.Constants;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DialogCartShopping extends JDialog {


    private DefaultTableModel defaultTableModel;
    private JTable jTable;
    private JScrollPane jScrollPane;
    private JButton jButton;
    private JPanel panelConainter;

    public DialogCartShopping(MyPresenter myPresenter ){
        panelConainter = new JPanel();
        panelConainter.setLayout(new BoxLayout(panelConainter,BoxLayout.Y_AXIS));
        setSize(500,600);
        this.setBackground(Color.gray);
        JLabel test = new JLabel("TESTSTST");

        this.initComponents(myPresenter);
        this.add(test);
        this.addTest();
        this.add(panelConainter);

    }


    private void initComponents(MyPresenter myPresenter) {
        String[] rowNames = {Constants.NAME_PRODUCT, Constants.PRICE, Constants.AVAILABLE_PRODUCTS, Constants.TYPE_PRODUCT};
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

        //Creo mi JScroll para que mi tabla pueda ser desplazada
        jScrollPane = new JScrollPane(jTable);
        jScrollPane.setAlignmentX(LEFT_ALIGNMENT);
        jScrollPane.setForeground(Color.lightGray);

        this.jButton = new JButton("REALIZA LA COMPRA");
        jButton.setActionCommand(Commands.C_PROCEED_BUY.toString());
        jButton.addActionListener(myPresenter);


        this.panelConainter.add(jScrollPane);
        this.panelConainter.add(jButton);



    }

    private void addBuyButton(MyPresenter myPresenter){

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

    public void addTest(){
        this.defaultTableModel.addRow(new String[]{
                "Hola","Como tas"
        });
    }
}




