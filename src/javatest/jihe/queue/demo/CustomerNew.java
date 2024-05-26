package javatest.jihe.queue.demo;

import java.util.Comparator;

public class CustomerNew implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        return o2.getMoney()-o1.getMoney();
    }

}
