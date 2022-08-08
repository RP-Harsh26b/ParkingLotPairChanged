package bike.rapido.parkinglot.observers;

public interface Observer {
    void notifyObserverWhenLotIsFull();

    void notifyObserverWhenLotHasSpaceAgain();
}