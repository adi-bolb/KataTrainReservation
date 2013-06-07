package main.java;

import java.util.List;

public class Reservation implements IReservation {
	public final String trainId;
    public final String bookingId;
    public final List<Seat> seats;

    public Reservation(String trainId, List<Seat> seats, String bookingId) {
		this.trainId = trainId;
        this.bookingId = bookingId;
        this.seats = seats;
    }

}
