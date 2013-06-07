package main.java;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import static org.junit.Assert.*;

public class TicketOfficeTest {
    
    private IReservationCreator reservationCreator;
	private List<Seat> seats;
	private Reservation reservationStubbed;
	private TicketOffice office;
	private ReservationRequest request;
    @Before
    public void setup(){
    	reservationCreator = new ReservationCreatorStub();
    	seats = new ArrayList<Seat>();
    	reservationStubbed = new Reservation(null, seats,  null);
    	reservationCreator.setReservation(reservationStubbed);
    	office = new TicketOffice("http://localhost:8081", "http://localhost:8082", reservationCreator);
    	request = new ReservationRequest("express_2000", 4);
    }
    
	@Test
    public void reservationShouldContainCorrectNumberOfSeats() {
    	seats.add(new Seat(null, 0));
    	seats.add(new Seat(null, 0));
    	seats.add(new Seat(null, 0));
    	seats.add(new Seat(null, 0));
    	
        Reservation reservation = office.makeReservation(request);
        assertEquals(4, reservation.seats.size());

    }

    @Test
    public void reservedSeatShouldBeInTheCorrectCoach() {
    	seats.add(new Seat("A", 0));
    	
        Reservation reservation = office.makeReservation(request);
        assertEquals("A", reservation.seats.get(0).coach);
    }

    @Test
    @Ignore
    public void reserveSeats3() {
        Reservation reservation = office.makeReservation(request);
    
        assertEquals("75bcd15", reservation.bookingId);
    }
}
