package bike.rapido.parkinglot;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ParkingAttendantTest {

	final private int TOTAL_LOTS = 5;
	final private int TOTAL_SLOTS = 10;
	ParkingAttendant parkingAttendant;

	@Before
	public void setUp() {
		parkingAttendant = new ParkingAttendant(TOTAL_LOTS, TOTAL_SLOTS);
	}

	@Test
	public void shouldFindTheEmptySlot() {
		boolean isEmptySlotPreset = parkingAttendant.getEmptySlots();

		assertTrue(isEmptySlotPreset);
	}

	@Test
	public void shouldReturnFalseIfNoEmptySlotPresent() {
		ParkingAttendant parkingAttendant = new ParkingAttendant(1, 1);
		Car car = new Car("TestCar");

		boolean isParked = parkingAttendant.parkTheCar(car);
		boolean isUnParked = parkingAttendant.unParkTheCar(car);
		boolean isEmptySlotPreset = parkingAttendant.getEmptySlots();

		assertTrue(isParked);
		assertTrue(isUnParked);
		assertTrue(isEmptySlotPreset);
	}

	@Test
	public void shouldReturnEmptySlotPresentAfterParkAndUnparkACar()
	{

		ParkingAttendant parkingAttendant = new ParkingAttendant(1, 1);
		Car car = new Car("TestCar");

		boolean isParked = parkingAttendant.parkTheCar(car);
		boolean isUnParked = parkingAttendant.unParkTheCar(car);
		boolean isEmptySlotPreset = parkingAttendant.getEmptySlots();

		assertTrue(isParked);
		assertTrue(isUnParked);
		assertTrue(isEmptySlotPreset);
	}

	@Test
	public void shouldParkTheCar() {
		Car car = new Car("Test Car 1234");

		boolean isCarParked = parkingAttendant.parkTheCar(car);

		assertTrue(isCarParked);
	}

	@Test
	public void shouldUnParkTheCar() {
		Car car = new Car("TestCar Bugatti");

		boolean isCarParked = parkingAttendant.parkTheCar(car);
		boolean isCarUnparked = parkingAttendant.unParkTheCar(car);

		assertTrue(isCarParked);
		assertTrue(isCarUnparked);
	}

	@Test
	public void shouldNotBeAbleToParkTheCar() {
		ParkingAttendant parkingAttendant = new ParkingAttendant(0, 0);
		Car car = new Car("Testing mercedes");

		boolean isCarParked = parkingAttendant.parkTheCar(car);

		assertFalse(isCarParked);
	}
}
