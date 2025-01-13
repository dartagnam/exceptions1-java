package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Integer nrQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer nrQuarto, Date checkIn, Date checkOut) {
		this.nrQuarto = nrQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNrQuarto() {
		return nrQuarto;
	}

	public void setNrQuarto(Integer nrQuarto) {
		this.nrQuarto = nrQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duracao() {
		long dif = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Quarto "
			   + nrQuarto
			   + ", check-in: "
			   + sdf.format(checkIn)
			   + ", check-out: "
			   + sdf.format(checkOut)
			   +", "
			   + duracao()
			   + " noites";
	}
	
}
