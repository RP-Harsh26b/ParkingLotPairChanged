package bike.rapido.parkinglot.observers;

public class AirportSecurityPersonal implements Observer {
    private boolean hasSecurityPersonalNotified = false;

    public void redirectSecurityStaff() {
        this.hasSecurityPersonalNotified = true;
    }

    public boolean isSecurityPersonalNotified() {
        return this.hasSecurityPersonalNotified;
    }

    @Override
    public void notifyObserverWhenLotIsFull() {
        redirectSecurityStaff();
    }

    @Override
    public void notifyObserverWhenLotHasSpaceAgain() {
    }
}