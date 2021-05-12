package views;

import controllers.MyPresenter;
import views.body.JPLogin;
import views.body.JPMainBody;
import views.header.JPHeaderMain;

import javax.swing.*;
import java.awt.*;

public class JPMain extends JPanel {
    private JPLogin jpLogin;
    private JPHeaderMain jpHeaderMain;
    private JPMainBody jpMainBody;


    public JPMain(MyPresenter myPresenter) {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(1900,200));
        initComponents(myPresenter);

    }

    public void initComponents(MyPresenter myPresenter){
        this.jpLogin = new JPLogin(myPresenter);
        this.jpHeaderMain = new JPHeaderMain(myPresenter);
        this.jpMainBody = new JPMainBody(myPresenter);
        this.add(jpHeaderMain,BorderLayout.NORTH);
        this.add(jpMainBody,BorderLayout.CENTER);

        this.jpLogin.setVisible(false);
    }

    public void changeLanguage() {
        jpHeaderMain.changeLanguage();

    }

    public void showGraphicsButtons(){
        jpMainBody.showGraphicsButtons();
    }

    public void showTablesButtons(){
        jpMainBody.showTableButtons();
    }



    public void changeButtonsIdiom(){
        jpHeaderMain.changeButtonsIdiom();
        jpMainBody.changeIdiom();
    }


    public String obtainSelectedData(){
        return jpMainBody.obtainSelectedData();
    }

    public void createRow(Object [] data){
        this.jpMainBody.createRow(data);
    }

    public void showTable(){
        jpMainBody.showTableProducts();
    }

    public void eraseTable(){
        jpMainBody.deleteRows();
    }


    public void welcomeUserText(String name){
        jpHeaderMain.setTextWelcom(name);
    }
    public void welcomeUserId(String id){
        jpHeaderMain.setTextID(id);
    }
}
