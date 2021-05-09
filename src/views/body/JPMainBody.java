package views.body;

import javax.swing.*;
import java.awt.*;

public class JPMainBody extends JPanel {
    private JProductTable jProductTable;

    public JPMainBody() {
        this.setLayout(new BorderLayout());
        initComponents();
    }

    public void initComponents() {
        this.jProductTable = new JProductTable();

    }

    public void showTableProducts() {
        this.removeAll();
        this.repaint();
        this.add(jProductTable,BorderLayout.PAGE_START);
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
