package me.dgpr.item_8;

import static java.lang.Thread.sleep;

public class BankTest {

    public static void main(final String[] args) throws InterruptedException {
        Bank bank = null;
        try {
            bank = new BankAttack(500);
            bank.transfer(1000);
        } catch (Exception e) {
            System.out.println("예외 터짐");
        }
        System.gc();
        sleep(3000);
    }

}
