package edu.icet.shehan_toga_kade.controller;

import edu.icet.shehan_toga_kade.DB.ArrayDataBase;
import edu.icet.shehan_toga_kade.DB.Database;
import edu.icet.shehan_toga_kade.model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewCustomersController implements Initializable {

    @FXML
    private TableColumn<Customer,String> colAddress;

    @FXML
    private TableColumn<Customer, LocalDate> colBirthDate;

    @FXML
    private TableColumn<Customer,String> colContact;

    @FXML
    private TableColumn<Customer,String> colId;

    @FXML
    private TableColumn<Customer,String> colName;

    @FXML
    private TableColumn<Customer,String> colTitle;

    @FXML
    private TableView<Customer> customerTable;

    @FXML
    private Label text;

    @FXML
    private TextField txtSearch;
    Stage updateCustomer = null;

    private Customer selectedCustomer;

    private ObservableList<Customer> customers;


    @FXML
    void deleteCustomer(ActionEvent event) {
        if(selectedCustomer != null){
            if (Database.getDataBase().deleteCustomer(selectedCustomer)){
                System.out.println("deleted sucsessfully");
            }
            reload();
        }
    }

    @FXML
    void reloadPage(ActionEvent event) {
    reload();
    }

    void reload(){
        ArrayList<Customer> customersAr = Database.getDataBase().getAllCustomers();
        customers = FXCollections.observableArrayList(customersAr);
        System.out.println(customersAr.toString());
        customerTable.setItems(customers);
    }

    private void setColumnFactories(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colBirthDate.setCellValueFactory(new PropertyValueFactory<>("birthDate"));


    }


    @FXML
    void updateCustomer(ActionEvent event) {
        ControllerManager.getControllerManager().loadScene(updateCustomer,"../../../../view/update_customer.fxml");

    }

    @FXML
    void searchCustomer(ActionEvent event) {
        ArrayList<Customer> customersAr = Database.getDataBase().getCustomer(txtSearch.getText());
        customers = FXCollections.observableArrayList(customersAr);
        System.out.println(customersAr.toString());
        customerTable.setItems(customers);
    }

    @FXML
    void select(ActionEvent event) {
        System.out.println("clicked on table");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

      setColumnFactories();
        reload();
        customerTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedCustomer = (Customer) newSelection;
                ControllerManager.getControllerManager().setSelectedCustomer(selectedCustomer);

            }
        });
    }


}
