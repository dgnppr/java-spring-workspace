package me.dgpr.data;

import lombok.Getter;

@Getter
public enum EventType {

    CHICKEN("치킨 기프티콘");

    private final String name;

    EventType(String name) {
        this.name = name;
    }
}
