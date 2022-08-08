package bike.rapido.parkinglot.observers;

import bike.rapido.parkinglot.ParkingAttendant;
import bike.rapido.parkinglot.parkStrategy.ParkingStrategy;

public class ParkingLotOwner implements Observer {
    private String signBoard;

    public String getSignBoard() {
        return signBoard;
    }

    public void setSignBoard(String signBoard) {
        this.signBoard = signBoard;
    }

    public void putFullSignBoard() {
        setSignBoard("FULL");
    }

    @Override
    public void notifyObserverWhenLotIsFull() {
        putFullSignBoard();
    }

    private void removeFullSignBoard() {
        setSignBoard(null);
    }

    @Override
    public void notifyObserverWhenLotHasSpaceAgain() {
        removeFullSignBoard();
    }

    public void useParkingStrategy(ParkingAttendant parkingAttendant, ParkingStrategy parkingStrategy) {
        parkingAttendant.setParkingStrategy(parkingStrategy);
    }
}