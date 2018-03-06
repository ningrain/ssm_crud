package com.practice.thread;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/3/6
 * Time: 11:09
 */
class Account{
    private int balance;
    public synchronized void deposite(Integer amt){
        this.balance += amt;
        try {
            Thread.currentThread().sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "：" + balance);
    }

}


class Customer implements Runnable{

    private Account account;

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposite(1000);
        }
    }
}

public class TestDraw {
    public static void main(String[] args) {
        Account account = new Account();
        Customer customer = new Customer(account);
        Thread t1 = new Thread(customer);
        Thread t2 = new Thread(customer);
        t1.start();
        t2.start();
    }
}
