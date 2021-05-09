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
        initComponents(myPresenter);

    }

    public void initComponents(MyPresenter myPresenter){
        this.jpLogin = new JPLogin(myPresenter);
        this.jpHeaderMain = new JPHeaderMain(myPresenter);
        this.jpMainBody = new JPMainBody();
        this.add(jpHeaderMain,BorderLayout.NORTH);
        this.add(jpMainBody,BorderLayout.CENTER);
        //this.add(jpLogin);
        this.jpLogin.setVisible(false);
    }

    public void changeLanguage() {
        jpHeaderMain.changeLanguage();

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
