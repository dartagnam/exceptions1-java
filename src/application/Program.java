package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do quarto: ");
		int nr = sc.nextInt();
		System.out.print("Data do check-in (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data do check-out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: a data de check-out deve ser posterior a data de check-in");
		} else {
			Reserva reserva = new Reserva(nr, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Insira dados para atualizar a reserva: ");
			System.out.print("Data do check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data do check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro na reserva: As datas de reserva para atualização devem ser futuras!");
			}
			else if(!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: a data de check-out deve ser posterior a data de check-in");
			} 
			else {			
			reserva.updateDates(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);			
			}
		
		}
		
		sc.close();
	}

}
