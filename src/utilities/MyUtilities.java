package utilities;

import views.ConstantGUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;

public class MyUtilities {

    public static void setFooterButtonsValues(JButton buttonToChange) {

        buttonToChange.setMaximumSize(new Dimension(169,52));
        buttonToChange.setFont(new Font("Arial", Font.BOLD, 15));
        buttonToChange.setForeground(Color.BLACK);
        buttonToChange.setBackground(null);
        buttonToChange.setBorder(null);
    }

    public static void setMainElementsButton(JButton jButton, ImageIcon imageIcon, int top, int left, int bottom, int right){
        jButton.setBackground(null);
        jButton.setIcon(imageIcon);
        jButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        jButton.setBorder(null);
        jButton.setBorder(BorderFactory.createEmptyBorder(top,left,bottom,right));
    }

    public static void setTextAndIconButtons(JButton button, String text, ImageIcon imageIcon, int top, int left, int bottom, int right){
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setText(text);
        button.setForeground(Color.BLACK);
        button.setMaximumSize(new Dimension(380,60));
        button.setBackground(Color.cyan);
        button.setForeground(Color.BLACK);
        button.setIcon(imageIcon);
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        Border emptyBorder = BorderFactory.createEmptyBorder();
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
        button.setBorder(emptyBorder);
        button.setBorder(null);
    }

    public static void setTextAndJLabel(JLabel jlabel,String text, ImageIcon logo) {
        jlabel.setText(text);
        jlabel.setFont(new Font("Arial", Font.PLAIN, 15));
        jlabel.setForeground(Color.BLACK);
        //jlabel.setMaximumSize(new Dimension(380,30));
        jlabel.setBackground(null);
        jlabel.setIcon(logo);
        //jlabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        jlabel.setBorder(null);

    }

    public static LocalDate parseDateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Properties generateProperties(String pathFile) throws IOException {
        Properties properties = new Properties();
        InputStream input = new FileInputStream(pathFile);
        properties.load(input);
        return properties;
    }

    public static void saveProperties(Properties properties,String pathFile) throws IOException {
        FileOutputStream output = new FileOutputStream(pathFile);
        properties.store(output,null);
        output.close();

    }


    /**
     * Arregla problemas de la Ñ y tildes
     * @param string
     * @return
     */
    public static String setRepairLetter(String string) {
        byte [] ptext = string.getBytes(ISO_8859_1);
        String value = new String(ptext, UTF_8);
        return  value;
    }



}