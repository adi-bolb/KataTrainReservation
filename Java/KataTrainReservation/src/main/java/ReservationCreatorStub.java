package main.java;

public class ReservationCreatorStub implements IReservationCreator {

	private Reservation reservation;

	@Override
	public Reservation create() {
		// TODO Auto-generated method stub
		return reservation;
	}

	@Override
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
		
	}

}
