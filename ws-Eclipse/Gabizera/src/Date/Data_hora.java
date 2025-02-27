package Date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Data_hora {

	public static void main(String[] args) {
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
		LocalDate d01 = LocalDate.parse("20/07/2022",fmt1);
		
		System.out.println(d01);
		
		
		Instant DataNow = Instant.now();
		
		System.out.println(fmt2.format(DataNow));
		
		
				

	}

}
