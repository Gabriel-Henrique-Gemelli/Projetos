package Entities;

import java.time.LocalDate;

import Enum.Orderenum;

public class Order {
	
	private Integer id;
	private LocalDate moment;
	private Orderenum status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getMoment() {
		return moment;
	}
	public void setMoment(LocalDate moment) {
		this.moment = moment;
	}
	public Orderenum getStatus() {
		return status;
	}
	public void setStatus(Orderenum status) {
		this.status = status;
	}
	public Order(Integer id, LocalDate moment, Orderenum status) {
		this.id = id;
		this.moment = moment;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", moment=" + moment + ", status=" + status;
	
	}
}
