package main.java;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import static org.junit.Assert.*;

public class TicketOfficeTest {
    
    @Test
    public void reserveSeats() {
    	
    	IReservationCreator reservationCreator = new ReservationCreatorStub();
    	List<Seat> seats = new ArrayList<Seat>();
    	seats.add(new Seat(null, 0));
    	seats.add(new Seat(null, 0));
    	seats.add(new Seat(null, 0));
    	seats.add(new Seat(null, 0));
    	Reservation reservationStubbed = new Reservation(null, seats,  null);
    	reservationCreator.setReservation(reservationStubbed);
    	
        TicketOffice office = new TicketOffice("http://localhost:8081", "http://localhost:8082", reservationCreator);
        ReservationRequest request = new ReservationRequest("express_2000", 4);
    
        Reservation reservation = office.makeReservation(request);
    
        assertEquals(4, reservation.seats.size());

    }

    @Test
    @Ignore
    public void reserveSeats2() {
        TicketOffice office = new TicketOffice("http://localhost:8081", "http://localhost:8082", null);
        ReservationRequest request = new ReservationRequest("express_2000", 4);
    
        Reservation reservation = office.makeReservation(request);
    
        assertEquals("A", reservation.seats.get(0).coach);

    }

    @Test
    @Ignore
    public void reserveSeats3() {
        TicketOffice office = new TicketOffice("http://localhost:8081", "http://localhost:8082", null);
        ReservationRequest request = new ReservationRequest("express_2000", 4);
    
        Reservation reservation = office.makeReservation(request);
    
        assertEquals("75bcd15", reservation.bookingId);
    }
}
