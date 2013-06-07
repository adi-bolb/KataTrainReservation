package main.java;

import java.util.List;

public class Reservation implements IReservation {
	public final String trainId;
    private final String bookingId;
    public final ISeatCollection seats;

    public Reservation(String trainId, ISeatCollection seats, String bookingId) {
		this.trainId = trainId;
        this.bookingId = bookingId;
        this.seats = seats;
    }

	public String getBookingId() {
		return bookingId;
	}

}
