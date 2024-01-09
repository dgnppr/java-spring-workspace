package me.dgpr.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CouponEvent {

    private EventType eventType;
    private int remainingCount;

    public boolean isEnd() {
        return this.remainingCount <= 0;
    }

    public synchronized void decrease() {
        this.remainingCount--;
    }
}
