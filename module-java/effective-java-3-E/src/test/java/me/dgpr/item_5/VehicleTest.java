package me.dgpr.item_5;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

class VehicleTest {

    @Test
    void car_객체_생성하기() {
        //Arrange
        Supplier<Car> carSupplier = Car::new;

        //Act
        Vehicle vehicle = VehicleFactory.createVehicle(carSupplier);

        //Assert
        assertThat(vehicle.getType()).isEqualTo("car");
    }
}
