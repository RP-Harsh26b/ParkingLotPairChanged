package bike.rapido.parkinglot;

public class Driver {
    private final ParkingLot parkingLot;

    Driver(final int totalSlots) {
        this.parkingLot = new ParkingLot(totalSlots);
    }

    public boolean parkVehicle(Car car) {
        if (parkingLot.isAvailable()) {
            parkingLot.parkACar(car);
            return true;
        } else {
            return false;
        }
    }

    public boolean unParkVehicle(Car car) {
        if (parkingLot.isFullyEmpty()) {
            return false;
        } else {
            parkingLot.unParkACar(car);
            return true;
        }
    }

    public ParkingLot getParkingSlot() {
        return this.parkingLot;
    }
}