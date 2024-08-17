package edu.icet.shehan_toga_kade.DB;

import edu.icet.shehan_toga_kade.model.Customer;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;


public class ArrayDataBase implements Database{

    ArrayList<Customer> customers = new ArrayList<>(){};

    private static ArrayDataBase arrayDataBase;
    private ArrayDataBase(){

    }
    static ArrayDataBase getDataBase (){
        arrayDataBase =  (arrayDataBase == null) ? new ArrayDataBase() : arrayDataBase;

        return arrayDataBase;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        if(customers != null){
            customers.add(customer);
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Customer> getCustomer(String searchText) {
        ArrayList<Customer> tempList = new ArrayList<>();
        for (Customer customer : customers){
            if(customer.getName().contains(searchText)||customer.getId().contains(searchText) ||customer.getAddress().contains(searchText)||customer.getContact().contains(searchText)||customer.getBirthDate().toString().contains(searchText)){
                tempList.add(customer);
            }
        }
        return tempList;
    }

    @Override
    public ArrayList<Customer> getAllCustomers() {
        return customers;
    }

    @Override
    public boolean UpdateCustomer(Customer customer) {
        return false;
    }

    @Override
    public boolean deleteCustomer(Customer customer) {
        if(customers.contains(customer)){
            customers.remove(customer);
            return true;
        }
        return false;
    }



}
