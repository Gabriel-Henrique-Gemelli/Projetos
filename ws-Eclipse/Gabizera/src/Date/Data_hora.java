package Date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Data_hora {

	public static void main(String[] args) {
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate d01 = LocalDate.parse("20/07/2022",fmt1);
		
		System.out.println(d01);
				

	}

}
