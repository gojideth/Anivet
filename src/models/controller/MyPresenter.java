package models.controller;

import models.administration.Administrator;
import models.shop.Client;
import views.JFrameMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPresenter implements ActionListener {
    private JFrameMain mainFrame;
    private Administrator administrator;

    public MyPresenter() {
        this.mainFrame = new JFrameMain(this, administrator.getClient().getName());
    }

    private void initComponents() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public Client takeACyclistSinceDialog(){
        return mainFrame.createCyclist();
    }

    public void createClient(Client client){
        administrator.createClient(client);
    }


    public static void main(String[] args) {
        new MyPresenter();
    }
}
