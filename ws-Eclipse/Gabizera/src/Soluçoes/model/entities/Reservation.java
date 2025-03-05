package Soluçoes.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
	public Reservation(Integer roomNumber, Date checkIn, Date checkout) {
		super();
		RoomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkout = checkout;
	}
	
	public long duration() {
		long diff = checkout.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
	}
	
	public String updateDates(Date checkIn, Date checkout) {
		Date now = new Date();
		if (checkIn.before(now) || checkout.before(now)) {
			return "Error in reservation: Dates estao erradas";
		}if (!checkout.after(checkIn)) {
			return "Erro in reservation: check-out deve ser depois da data de check-in";
		}
		this.checkIn = checkIn;
		this.checkout = checkout;
		return null;
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
