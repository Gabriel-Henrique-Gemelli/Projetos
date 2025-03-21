package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String email;
	public Person() {
		super();
	}
	public Person(Integer id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Person: name=" + name + ", email=" + email;
	}
	
	
}
