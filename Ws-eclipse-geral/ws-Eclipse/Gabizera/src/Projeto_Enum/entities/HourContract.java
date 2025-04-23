package Projeto_Enum.entities;

import java.util.Date;

public class HourContract {
	
	private Date date;
	private Double ValuePerHour;
	private Integer hour;
	
	public HourContract() {
		
	}

	public HourContract(Date date, Double valuePerHour, Integer hour) {
		this.date = date;
		ValuePerHour = valuePerHour;
		this.hour = hour;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValuePerHour() {
		return ValuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		ValuePerHour = valuePerHour;
	}

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}
	
	public double totalValue() {
		return ValuePerHour * hour;
	}
	
}
