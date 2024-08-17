package edu.icet.shehan_toga_kade.controller;

import edu.icet.shehan_toga_kade.DB.Database;
import edu.icet.shehan_toga_kade.model.Customer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Objects;

public class ControllerManager {

    private Customer selectedCustomer;

    private ControllerManager(){}
    private static ControllerManager controllerManager;
    public static ControllerManager getControllerManager(){
        return controllerManager = (controllerManager == null) ? new ControllerManager() : controllerManager;
    }
    public void loadScene(Stage stage , String fileName){
        if(stage != null){
            stage.show();
            stage.requestFocus();
        }
        else {
            try{
                stage = new Stage();
                stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fileName)))));
                stage.setTitle("Add Customer");
                stage.show();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    public Customer getSelectedCustomer() {
        return selectedCustomer;
    }

    public void setSelectedCustomer(Customer selectedCustomer) {
        this.selectedCustomer = selectedCustomer;
    }


    public String generateId(){
        ArrayList<Customer> customers =  Database.getDataBase().getAllCustomers();
        System.out.println(customers.size());
        if(!customers.isEmpty()){
            String lastId = customers.getLast().getId();
            int newIdNum = Integer.parseInt( lastId.substring(1)) + 1;
            return  String.format("C%04d",newIdNum);
        }
        return "C0001";

    }
}
