package main.java;

public class TicketOffice {
    
    private final IReservationCreator reservationCreator;

	public TicketOffice(String trainDataService, String bookingReferenceService, IReservationCreator reservationCreator) {
		this.reservationCreator = reservationCreator;
		//TODO: implement this code!
    }

    public Reservation makeReservation(ReservationRequest request) {
		return reservationCreator.create();
    }

}