package Date;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Calculo {

	public static void main(String[] args) {
		LocalDate d04 = LocalDate.parse("2022-07-20");
		Instant d01 = Instant.now();
		
		LocalDate pasweekLocalDate = d04.minusDays(7); //Localdate
		LocalDate nextweekLocalDate = d04.plusDays(7);
		
		Instant pasweekinstant = d01.minus(7,ChronoUnit.DAYS);
		Instant Nextweekinstant = d01.plus(7,ChronoUnit.DAYS); //instant
		
		Duration t1 = Duration.between(pasweekinstant, Nextweekinstant);
		
		System.out.println(pasweekLocalDate);
		System.out.println(nextweekLocalDate);
		System.out.println(pasweekinstant);
		System.out.println(Nextweekinstant);
		System.out.println("t1 dias = " + t1.toDays());
	}

}
