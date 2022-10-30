package com.example.guiproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import menu.Menus;
import rolls.Admin;
import rolls.Buyer;
import rolls.Person;
import rolls.Seller;
import sqlPack.MySql;

import java.io.IOException;
import java.sql.SQLException;

public class signUpCtr {
    @FXML
    private TextField accountId;
    @FXML
    private TextField email;
    @FXML
    private TextField lastName;
    @FXML
    private TextField name;
    @FXML
    private TextField password;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField roll;
    @FXML
    private TextField wealth;
    @FXML
    private Label message;


    @FXML
    void submitSignUp(MouseEvent event) throws SQLException, IOException, ClassNotFoundException {

        if (roll.getText().toUpperCase().equals(Person.Roll.BUYER.toString()))
        {

            Buyer x = new Buyer(accountId.getText(),name.getText(),lastName.getText(),email.getText(),phoneNumber.getText(),password.getText(),Double.parseDouble(wealth.getText()));
            String sqlcmd = String.format("INSERT INTO buyerlist (idCode,userId,firstName,lastName,password,wealth) VALUES(%d,'%s','%s','%s','%s',%d)",x.getCode(),accountId.getText(),name.getText(),lastName.getText(),password.getText(),Integer.parseInt(wealth.getText()));
            MySql.getMySql().ExecuteSQL(sqlcmd);

            String sqlcmd2 = String.format("INSERT INTO b_emaillist (idCode,email) VALUES(%d,'%s')",x.getCode(),email.getText());
            MySql.getMySql().ExecuteSQL(sqlcmd2);

            String sqlcmd3 = String.format("INSERT INTO b_phonelist (idCode,phoneNumber) VALUES(%d,'%s')",x.getCode(),phoneNumber.getText());
            MySql.getMySql().ExecuteSQL(sqlcmd3);

            if(!Buyer.getBuyersList().contains(x)){
                Buyer.setBuyersList(x);
            }
            if(!Admin.allUsers.contains(x))
            {
                Admin.allUsers.add(x);
            }
            Menus.buyerMethods();
        }

        if (roll.getText().toUpperCase().equals(Person.Roll.SELLER.toString()))
        {
            Seller x = new Seller(accountId.getText(),name.getText(),lastName.getText(),email.getText(),phoneNumber.getText(),password.getText(),Double.parseDouble(wealth.getText()));
            Admin.allUsers.add(x);
            Admin.allPendingsellers.add(x);
            Admin.setAddSellerReq(x);
            Menus.sellerMethods();
        }

       message.setText("signUp successfully done!");
    }

}
