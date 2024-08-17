package edu.icet.shehan_toga_kade.DB;

import edu.icet.shehan_toga_kade.model.Customer;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

public interface Database {

    boolean addCustomer(Customer customer);
    boolean UpdateCustomer(Customer customer);
    boolean deleteCustomer(Customer customer);
    ArrayList<Customer> getCustomer(String searchText);
    ArrayList<Customer> getAllCustomers();
    static Database getDataBase(){
        return ArrayDataBase.getDataBase();
    }
}
