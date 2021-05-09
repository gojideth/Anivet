package views.body;

import models.controller.MyPresenter;

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
}
