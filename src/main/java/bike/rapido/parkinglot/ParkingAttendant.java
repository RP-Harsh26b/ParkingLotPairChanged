package bike.rapido.parkinglot;

import bike.rapido.parkinglot.parkStrategy.FirstFreeParkingStrategy;
import bike.rapido.parkinglot.parkStrategy.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingAttendant {

    List<ParkingLot> parkingLots;
    ParkingStrategy parkingStrategy;

    ParkingAttendant(int totalLots, int totalSlots) {
        this.parkingLots = new ArrayList<>();
        for (int count = 0; count < totalLots; count++) {
            parkingLots.add(new ParkingLot(totalSlots));
        }
        this.parkingStrategy = new FirstFreeParkingStrategy(parkingLots);
    }

    public List<ParkingLot> getParkingLots() {
        return this.parkingLots;
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    public boolean parkTheCar(Car car) {
        return parkingStrategy.parkAccordingToStrategy(car);
    }

    public boolean getEmptySlots() {
        for (ParkingLot ele : parkingLots) {
            if (ele.isFullyEmpty()) {
                return true;
            }
        }
        return false;
    }

    public boolean unParkTheCar(Car car) {
        for (ParkingLot ele : this.parkingLots) {
            if (ele.getCar(car)) {
                return ele.unParkACar(car);
            }
        }
        return false;
    }

    public int[] getSlotDetailsWhereCarIsParked(Car car) {
        for (int count = 0; count < parkingLots.size(); count++) {
            if (parkingLots.get(count).getCar(car)) {

                int[] parkingSlotDetails = new int[2];
                int slotId = parkingLots.get(count).getSlotIdWhereCarIsParked(car);

                parkingSlotDetails[0] = count;
                parkingSlotDetails[1] = slotId;

                return parkingSlotDetails;
            }
        }
        return new int[2];
    }
}