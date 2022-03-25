package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner entrada = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int rNumber = Integer.parseInt(entrada.nextLine());
		System.out.print("Check-in date (dd/MM/yyyy):");
		Date checkIn = sdf.parse(entrada.nextLine());
		System.out.print("Check-out date (dd/MM/yyyy):");
		Date checkOut = sdf.parse(entrada.nextLine());
		Date now = new Date();
		if (!checkOut.after(checkIn) || (checkIn.before(now) || checkOut.before(now))) {
			System.out.println("Error in reservation: Check-out date must be after check-in!");
		} else {
			Reservation reservation = new Reservation(rNumber, checkIn, checkOut);
			System.out.println(reservation);

			System.out.println("\nEnter data to update the resevation: ");
			System.out.print("Check-in date (dd/MM/yyyy):");
			checkIn = sdf.parse(entrada.nextLine());
			System.out.print("Check-out date (dd/MM/yyyy):");
			checkOut = sdf.parse(entrada.nextLine());

			now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Check-out date must be in future!");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in!");
			} else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}

		}
	}

}
