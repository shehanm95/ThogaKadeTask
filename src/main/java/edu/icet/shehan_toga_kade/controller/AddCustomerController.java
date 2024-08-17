package edu.icet.shehan_toga_kade.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.icet.shehan_toga_kade.DB.Database;
import edu.icet.shehan_toga_kade.model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddCustomerController implements Initializable {

    Database database =Database.getDataBase();
    @FXML
    private JFXComboBox<String> comboTitle;

    @FXML
    private DatePicker dateBirthdate;

    @FXML
    private Label text;

    @FXML
    private Label labelId;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXTextField txtName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> titles = FXCollections.observableArrayList("Mr", "Ms", "Other");
        comboTitle.setItems(titles);
        labelId.setText(ControllerManager.getControllerManager().generateId());
    }

    @FXML
    void addCustomer(ActionEvent event) {
        Customer customer = new Customer(labelId.getText(),comboTitle.getValue(),txtName.getText(),txtAddress.getText() ,txtContact.getText() , dateBirthdate.getValue()  );
        ArrayList<String> errors = ValidateCustomer.getValidateCustomer().validateCustomer(customer);
        if(errors.isEmpty()){
        database.addCustomer(customer);
            ArrayList<Customer> customers =  database.getAllCustomers();
            System.out.println(customers.toString());
            cleaFields();
        }
        else {
            System.out.println(errors);
        }

    }

    private void cleaFields(){
        labelId.setText(null);
        comboTitle.setValue(null);
        txtName.setText(null);
        txtAddress.setText(null);
        txtContact.setText(null);
        dateBirthdate.setValue(null);
    }


}
