package javatest.jihe.queue.demo;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class Customer implements Comparable<Customer>{

    private int money;

    private String account;


    @Override
    public String toString() {
        return "Customer{" +
                "money=" + money +
                ", account='" + account + '\'' +
                '}';
    }

    public Customer(int m, String acc) {
        super();
        this.money =m;
        this.account = acc;
    }


    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public int compareTo(Customer o2) {
        /**
         * 按照从小到大的顺序排列
         */
        return this.money - o2.money;
    }




}
