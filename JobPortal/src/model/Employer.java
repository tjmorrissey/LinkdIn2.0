package model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "employer")
public class Employer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPLOYERID")
	private int employerId;
	@Column(name = "COMPANY")
	private String company;
	

	public Employer() {
		// TODO Auto-generated constructor stub
	}


	public int getEmployerId() {
		return employerId;
	}


	public void setEmployerId(int employerId) {
		this.employerId = employerId;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}



	public Employer(String company) {
		super();
		this.company = company;
		
	}


	@Override
	public String toString() {
		return "Employer [employerId=" + employerId + ", company=" + company + "]";
	}

	

	

}
