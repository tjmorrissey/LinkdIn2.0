package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employer")
public class Employer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "EMPLOYER")
	private String employer;
	@Column(name = "POSITION")
	private String position;
	@Column(name="LISTOFEMPLOYEES")
	private List listofemployees;
	@Column(name="DATE")
	private Date date;
	
	

	public Employer() {
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getEmployer() {
		return employer;
	}



	public void setEmployer(String employer) {
		this.employer = employer;
	}



	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}



	public List getListofemployees() {
		return listofemployees;
	}



	public void setListofemployees(List listofemployees) {
		this.listofemployees = listofemployees;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public Employer(int id, String employer, String position, List listofemployees, Date date) {
		super();
		this.id = id;
		this.employer = employer;
		this.position = position;
		this.listofemployees = listofemployees;
		this.date = date;
	}



	@Override
	public String toString() {
		return "Employer [id=" + id + ", employer=" + employer + ", position=" + position + ", listofemployees="
				+ listofemployees + ", date=" + date + "]";
	}
	
	

}
