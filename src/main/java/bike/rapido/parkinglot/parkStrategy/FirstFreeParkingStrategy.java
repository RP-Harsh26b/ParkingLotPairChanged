package bike.rapido.parkinglot.parkStrategy;

import bike.rapido.parkinglot.Car;
import bike.rapido.parkinglot.ParkingLot;

import java.util.List;

public class FirstFreeParkingStrategy implements ParkingStrategy {
    List<ParkingLot> parkingLots;

    public FirstFreeParkingStrategy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public boolean parkAccordingToStrategy(Car car) {
        for (ParkingLot ele : parkingLots) {
            if (ele.isAvailable()) {
                return ele.parkACar(car);
            }
        }
        return false;
    }
}