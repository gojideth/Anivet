package views.body;

import views.Constants;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class JProductTable extends JPanel {

    private DefaultTableModel defaultTableModel;
    private JTable jTable;
    private JScrollPane jScrollPane;

    public JProductTable() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.gray);
        this.initComponents();

    }


    private void initComponents() {
        String[] rowNames = {Constants.NAME_PRODUCT, Constants.PRICE, Constants.QUANTITY_AVAILABLE, Constants.PROVIDER_PRICE, Constants.PROVIDER, Constants.QUANTITY_PRESENTATION, Constants.LICENSE, Constants.TYPE_PRODUCT};
        //Creo mi cascarón y a este le debo poner el titulo de las columnas que vaya a usar, en este caso vienen organizadas por el arreglo de objetos de la clase Cuyclist


        defaultTableModel = new DefaultTableModel() {
            @Override
            public Class getColumnClass(int columna) {
                switch (columna) {
                    case 1:
                        return Integer.class;
                    case 2:
                        return Integer.class;
                }
                return String.class;
            }
        };

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
        this.add(jScrollPane);

    }

    public String tryBuy() {
        return String.valueOf(defaultTableModel.getValueAt(jTable.getSelectedRow(), 0));
    }

    /**
     * Creo metodos que traten directamente con mi tabla, recordando que debo traer desde el presenter los mismos metodos
     * teniendo en cuenta que debo hacerlo al cascaron (DEFAULT TABLE)
     */

    public void eraseTable() {
        this.defaultTableModel.setNumRows(0);
    }

    /**
     * Creo un metodo que me AGREGUE una hilera de datos
     */
    public void createRow(Object[] data) {
        this.defaultTableModel.addRow(data);
    }
}