package model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "job")
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "POSITION")
	private String brand;
	@Column(name = "SALARY")
	private String color;

	public Job() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Job(int id, String brand, String color) {
		super();
		this.id = id;
		this.brand = brand;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", brand=" + brand + ", color=" + color + "]";
	}
	
	

}
