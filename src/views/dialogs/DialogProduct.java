package views.dialogs;

import controllers.Commands;
import controllers.MyPresenter;
import models.shop.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DialogProduct extends JDialog {
    private JPanel panelContainer; //Panel que va a contender el dialog
    private JTextField nameProduct;
    private JTextField price;
    private JTextField quantityAvailable;
    private JTextField providerPrice;
    private JTextField provider;
    private JTextField quantityPresentationAmount;
    private JComboBox<Denomination> quantityPresentationDenomination;
    private JTextField sanitaryLicense;
    private JComboBox<TypeProduct> typeProductJComboBox;
    private JToggleButton jToggleButton;


    public DialogProduct(MyPresenter myPresenter) {
        setModal(true);
        setSize(500, 600);
        getContentPane().setBackground(new Color(229, 220, 220));
        setLocationRelativeTo(null);
        initComponents(myPresenter);

    }

    private void initComponents(MyPresenter myPresenter) {
        panelContainer = new JPanel();
        panelContainer.setLayout(new GridLayout(10, 1, 10, 10));
        panelContainer.setBackground(Color.lightGray);

        nameProduct = new JTextField();
        nameProduct.setBorder(BorderFactory.createTitledBorder("Ingresa nombre del producto "));
        panelContainer.add(nameProduct);

        price = new JTextField();
        price.setBorder(BorderFactory.createTitledBorder("Ingrese precio "));
        panelContainer.add(price);

        quantityAvailable = new JTextField();
        quantityAvailable.setBorder(BorderFactory.createTitledBorder("Ingresa por cuantas unidades se venderá el producto"));
        panelContainer.add(quantityAvailable);

        providerPrice = new JTextField();
        providerPrice.setBorder(BorderFactory.createTitledBorder("Ingresa precio del proveedor "));
        panelContainer.add(providerPrice);

        provider = new JTextField();
        provider.setBorder(BorderFactory.createTitledBorder("Ingresa el provedor"));
        panelContainer.add(provider);

        quantityPresentationAmount = new JTextField();
        quantityPresentationAmount.setBorder(BorderFactory.createTitledBorder("Ingresa la cantidad total disponible"));
        panelContainer.add(quantityPresentationAmount);


        quantityPresentationDenomination = new JComboBox<>(Denomination.values());
        quantityPresentationDenomination.setBorder(BorderFactory.createTitledBorder("Denominacion"));
        panelContainer.add(quantityPresentationDenomination);

        sanitaryLicense = new JTextField();
        sanitaryLicense.setBorder(BorderFactory.createTitledBorder("Ingresa numero licencia sanitaria"));
        panelContainer.add(sanitaryLicense);

        typeProductJComboBox = new JComboBox<>(TypeProduct.values());
        typeProductJComboBox.setBorder(BorderFactory.createTitledBorder("Tipo de producto"));
        panelContainer.add(typeProductJComboBox);



        jToggleButton = new JToggleButton("Agrega tu nuevo producto");
        jToggleButton.setActionCommand(Commands.CREATE_PRODUCT_DIALOG_AND_CLOSE.toString());
        jToggleButton.setBorder(new EmptyBorder(10, 10, 10, 10));

        jToggleButton.addActionListener(myPresenter);
        panelContainer.add(jToggleButton);

        this.add(panelContainer);
    }

    public Product createProduct() {

        return new Product(
                this.nameProduct.getText(),
                Double.parseDouble(this.price.getText()),
                Integer.parseInt(this.quantityAvailable.getText()),
                Double.parseDouble(this.providerPrice.getText()),
                this.provider.getText(),
                new Quantity(Integer.parseInt(this.quantityPresentationAmount.getText()),String.valueOf(quantityPresentationDenomination.getSelectedItem())),
                this.sanitaryLicense.getText(),
                String.valueOf(this.typeProductJComboBox.getSelectedItem())

        );
    }
}
