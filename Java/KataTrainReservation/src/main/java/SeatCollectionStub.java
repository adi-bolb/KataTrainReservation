package main.java;

public class SeatCollectionStub implements ISeatCollection {

	private int expectedNumberOfSeats;
	private Seat seat;

	public void setSize(int expectedNumberOfSeats) {
		this.expectedNumberOfSeats = expectedNumberOfSeats;
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return expectedNumberOfSeats;
	}

	@Override
	public void add(Seat seat) {
		this.seat = seat;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seat get(int i) {
		return seat;
	}
}