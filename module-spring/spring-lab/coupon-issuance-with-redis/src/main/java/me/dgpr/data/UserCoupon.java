package me.dgpr.data;

import lombok.Getter;

@Getter
public class UserCoupon {

    private EventType eventType;
    private String code;

    public UserCoupon(EventType eventType) {
        this.eventType = eventType;
        this.code = java.util.UUID.randomUUID().toString();
    }
}
