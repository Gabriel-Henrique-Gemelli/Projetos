package Soluçoes.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import Soluçoes.model.exceptions.DomainException;

public class Reservation {
	
	private Integer RoomNumber;
	private Date checkIn;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Integer getRoomNumber() {
		return RoomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		RoomNumber = roomNumber;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public Date getCheckout() {
		return checkout;
	}
	public Reservation(Integer roomNumber, Date checkIn, Date checkout) throws DomainException {
		if (!checkout.after(checkIn)) {
			throw new DomainException("Erro in reservation: check-out deve ser depois da data de check-in");
		}
		RoomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkout = checkout;
	}
	
	public long duration() {
		long diff = checkout.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkout) throws DomainException {
		Date now = new Date();
		if (checkIn.before(now) || checkout.before(now)) {
			throw new DomainException("Error in reservation: Dates estao erradas");
		}if (!checkout.after(checkIn)) {
			throw new DomainException("Erro in reservation: check-out deve ser depois da data de check-in");
		}
		this.checkIn = checkIn;
		this.checkout = checkout;
	}
	@Override
	public String toString() {
		return "Room "
				+ RoomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", "
				+ duration()
				+ "Nights";
	}
	
}
