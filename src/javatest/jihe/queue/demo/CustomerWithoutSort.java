package javatest.jihe.queue.demo;

public class CustomerWithoutSort {
    private int money;

    private String account;


    @Override
    public String toString() {
        return "Customer{" +
                "money=" + money +
                ", account='" + account + '\'' +
                '}';
    }

    public CustomerWithoutSort(int m, String acc) {
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
}
