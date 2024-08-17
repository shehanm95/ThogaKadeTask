package edu.icet.shehan_toga_kade.controller;

import edu.icet.shehan_toga_kade.DB.Database;
import edu.icet.shehan_toga_kade.model.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable  {

    private Stage addCustomer;
    private Stage deleteCustomer;
    private Stage updateCustomer;
    private Stage viewCustomer;
    @FXML
    private Label text;



    @FXML
    void addCustomer(ActionEvent event) throws IOException {
        ControllerManager.getControllerManager().loadScene(addCustomer,"../../../../view/add_customer_form.fxml");
    }

    @FXML
    void viewCustomer(ActionEvent event) {
        ControllerManager.getControllerManager().loadScene(viewCustomer,"../../../../view/view_customers.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        text.requestFocus();
        Database.getDataBase().addCustomer(new Customer("003","Mr","asdasd","asdasd","asdad", LocalDate.now()));

    }



//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        text.requestFocus();
//    }
}

