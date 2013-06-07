package main.java;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import static org.junit.Assert.*;

public class TicketOfficeTest {
    
    private IReservationCreator reservationCreator;
	private SeatCollectionStub seats;
	private Reservation reservationStubbed;
	private TicketOffice office;
	private ReservationRequest request;
    
	@Before
    public void setup(){
    	reservationCreator = new ReservationCreatorStub();
    	seats = new SeatCollectionStub();
    	reservationStubbed = new Reservation(null, seats,  null);
    	reservationCreator.setReservation(reservationStubbed);
    	office = new TicketOffice("http://localhost:8081", "http://localhost:8082", reservationCreator);
    	request = new ReservationRequest("express_2000", 4);
    }
    

	@Test
    public void reservationShouldContainCorrectNumberOfSeats() {
		int expectedNumberOfSeats = 4;
    	seats.setSize(expectedNumberOfSeats);
    	
        Reservation reservation = office.makeReservation(request);

        assertEquals(expectedNumberOfSeats, reservation.seats.size());

    }

    @Test
    public void reservedSeatShouldBeInTheCorrectCoach() {
    	String coach = "A";
		seats.add(new Seat(coach, 0));
    	
        Reservation reservation = office.makeReservation(request);
    
        ISeatCollection seats2 = reservation.seats;
		Seat seat = seats2.get(0);
		assertEquals(coach, seat.coach);
    }

    @Test
    public void reservedSeatShouldHaveTheCorrectBookingId() {
    	String reservationId = "75bcd15";
    	reservationStubbed = new Reservation(null, null, reservationId);
    	reservationCreator.setReservation(reservationStubbed);
    	
        Reservation reservation = office.makeReservation(request);
    
		assertEquals(reservationId, reservation.getBookingId());
    }
}