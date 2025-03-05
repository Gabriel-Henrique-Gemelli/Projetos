package Herança.ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<employee> list = new ArrayList<employee>();
		
		System.out.print("Enter the number of employees: ");
		int n = sc.nextInt();
		
		for (int i = 0; i<n ;i++) {
			System.out.print("Employee#" + i + " data:");
			System.out.print("Terceiro(Y/n)? ");
			char ch = sc.next().charAt(0);
			System.out.println("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Hours: ");
			int hours = sc.nextInt();
			System.out.println("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			if (ch == 'y') {
				System.out.print("Aditional Charge: ");
				double additionalCharge = sc.nextDouble();
				list.add(new Terceiro(name, hours, valuePerHour, additionalCharge));
			}
			else {
				list.add(new employee(name, hours, valuePerHour));
			}
		}
		System.out.println();
		System.out.println("Payments: ");
		for (employee emp : list) {
			System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
		}
		
		sc.close();

	}

}
