package bike.rapido.parkinglot.parkStrategy;

import bike.rapido.parkinglot.Car;
import bike.rapido.parkinglot.ParkingLot;

import java.util.List;

public class EvenDistributedParkingStrategy implements ParkingStrategy {
    List<ParkingLot> parkingLots;

    public EvenDistributedParkingStrategy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public boolean parkAccordingToStrategy(Car car) {
        int lotIdToParkCarIn = getParkingSlotAreaIdWithMinimumCarsParked();
        ParkingLot parkCarInSlot = parkingLots.get(lotIdToParkCarIn);
        return parkCarInSlot.parkACar(car);
    }

    private int getParkingSlotAreaIdWithMinimumCarsParked() {
        int parkingSlotId = 0;
        int carsParkedInASlot = Integer.MIN_VALUE;

        for (int count = 0; count < parkingLots.size(); ++count) {
            int carsParkedInCurrentSlot = parkingLots.get(count).getEmptySlots();

            if (carsParkedInASlot < carsParkedInCurrentSlot) {
                carsParkedInASlot = carsParkedInCurrentSlot;
                parkingSlotId = count;
            }
        }
        return parkingSlotId;
    }
}