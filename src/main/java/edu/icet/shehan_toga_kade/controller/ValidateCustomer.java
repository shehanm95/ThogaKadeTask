package edu.icet.shehan_toga_kade.controller;

import edu.icet.shehan_toga_kade.model.Customer;

import java.time.LocalDate;
import java.util.ArrayList;

public class ValidateCustomer {
    private ValidateCustomer(){}
    private static ValidateCustomer validateCustomer;

    public static ValidateCustomer getValidateCustomer() {
        return validateCustomer  = (validateCustomer == null) ? new ValidateCustomer() : validateCustomer;
    }

    public ArrayList<String> validateCustomer(Customer customer) {
        String title = customer.getTitle();
        String name = customer.getName();
        String address = customer.getAddress();
        String contact = customer.getContact();
        LocalDate birthDate = customer.getBirthDate();

        ArrayList<String> errors = new ArrayList<>();
        if (title == null) errors.add("title should be selected");
        if (name == null) errors.add("Name cannot be Empty");

        if (contact == null) errors.add("Contact cannot be Empty");
        if (contact != null && contact.length() != 10) errors.add("Contact should have 10 digits only");
        return errors;
    }
}
