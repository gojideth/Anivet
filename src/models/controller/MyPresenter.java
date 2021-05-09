package models.controller;

import models.administration.Administrator;
import models.shop.Client;
import models.shop.Market;
import utilities.HandlerLanguage;
import views.JFrameMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MyPresenter implements ActionListener {
    private static final String SPANISH_PATH = "./resources/languages/languageES.properties";
    private static final String NAME_FILE_CONFIG ="./resources/config/config.init" ;
    private static final String ENGLISH_PATH ="./resources/languages/languageUS.properties" ;
    private JFrameMain mainFrame;
    private Administrator administrator;
    private HandlerLanguage config;

    public MyPresenter() {
        loadConfiguration();
        this.administrator = new Administrator(new Market("Anivet"));
        this.mainFrame = new JFrameMain(this);

    }

    private void initComponents() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Commands.valueOf(e.getActionCommand())){
            case C_SHOW_HOMEPAGE:
                System.out.println("FUNCIONA");
                break;
            case I_CHANGE_TO_ENGLISH:
                manageChangeLenguageUS();
                break;
            case I_CHANGE_TO_SPANISH:
                manageChangeLanguageES();
                mainFrame.showTableProducts();
                break;
            case C_SHOW_DIALOG_CLIENT:
                this.showDialogCreate();
                break;
            case CREATE_CLIENT_DIALOG:
                this.createClientInAdmin(this.bringClientFromDialog());

                this.setText();
            case C_SHOW_TABLE:
                mainFrame.showTableProducts();
            default:
                break;
        }
    }


    public void showDialogCreate(){
        mainFrame.showDialogCreate();
    }

    public void closeDialogClient(){
        mainFrame.closeDialogClient();
    }

    public void createClientInAdmin(Client client){
        this.administrator.createClient(client);
        this.mainFrame.closeDialogClient();
    }

    public void printTestClient(Client client){
        System.out.println(this.bringClientFromDialog().toString());
    }
    private Client bringClientFromDialog(){
        return mainFrame.createClientFromDialog();
    }

    public void setText(){
        mainFrame.createUserWelcome(this.bringClientFromDialog().getName());

    }

    

    private void loadConfiguration() {
        if(config == null){
            config = new HandlerLanguage(NAME_FILE_CONFIG);
        }
        try{
            config.loadLanguage();
        }catch(IOException e){
            //JOptionPane.showMessageDialog(jfMainWindow, e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    private void loadLanguage() {
        try {
            config.loadLanguage();
        }catch (IOException e){
            JOptionPane.showMessageDialog(mainFrame,e.getMessage());
        }
    }

    private void saveConfig() {
        try {
            new HandlerLanguage(NAME_FILE_CONFIG).saveLanguage();
        }catch (IOException e){
            JOptionPane.showMessageDialog(mainFrame, e.getMessage());
        }
    }

    private void manageChangeLenguageUS(){
        try {
            changeToEnglish();
        }catch (IOException e1){
            JOptionPane.showMessageDialog(mainFrame,e1.getMessage());
        }
        manageChangeLanguage();
    }

    private void manageChangeLanguageES(){
        try {
            changeToSpanish();
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(mainFrame, e1.getMessage());
        }
        manageChangeLanguage();
    }

    public void changeToEnglish() throws IOException{
        HandlerLanguage.language = ENGLISH_PATH;
        saveConfig();
        loadLanguage();
    }

    public void changeToSpanish() throws IOException{
        HandlerLanguage.language = SPANISH_PATH;
        saveConfig();
        loadLanguage();
    }

    private void manageChangeLanguage(){
        mainFrame.changeLanguage();
    }
    
    public static void main(String[] args) {
        new MyPresenter();
    }
}
