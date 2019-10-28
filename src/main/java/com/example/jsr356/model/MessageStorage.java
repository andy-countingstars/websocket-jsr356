package com.example.jsr356.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This is Description
 *
 * @author xulongjie
 * @date 2019/10/24
 */
public class MessageStorage {
    private List<Customer> customers = new ArrayList<>();

    public void add(Customer customer) {
        customers.add(customer);
    }

    public void clear() {
        customers.clear();
    }

    public List<Customer> getAll(){
        return customers;
    }
}