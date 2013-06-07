package main.java;

public class TicketOffice {
    
    private final IReservationCreator reservationCreator;

	public TicketOffice(String trainDataService, String bookingReferenceService, IReservationCreator reservationCreator) {
		this.reservationCreator = reservationCreator;
    }

    public Reservation makeReservation(ReservationRequest request) {
		return reservationCreator.create();
    }

}