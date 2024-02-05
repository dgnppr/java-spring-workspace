package me.dgpr.chapter_2.item_8;

import java.text.MessageFormat;

public class Bank {

    private int money;

    public Bank(final int money) {
        if (money < 1000) {
            throw new RuntimeException("1000원 이하로 생성이 불가능해요.");
        }
        this.money = money;
    }

    void transfer(final int money) {
        this.money -= money;
        System.out.println(MessageFormat.format("{0}원 입금 완료!!", money));
    }
}
