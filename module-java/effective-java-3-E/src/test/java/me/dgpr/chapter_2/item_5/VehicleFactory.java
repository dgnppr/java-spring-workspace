package me.dgpr.chapter_2.item_5;

import java.util.function.Supplier;

public class VehicleFactory {
    public static Vehicle createVehicle(Supplier<? extends Vehicle> supplier) {
        return supplier.get();
    }
}
