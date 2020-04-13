package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

public class Employee {

	
		
		private int id;
		
		private String location;
	
		private LocalDate appliedDate;
		
		private Employer employer;
		
		private List<Applications>listofApplications;
		
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Employee(int id, String location, LocalDate appliedDate,Employer employer, List<Applications> listofApplications) {
			super();
			this.id = id;
			this.location = location;
			this.appliedDate = appliedDate;
			this.employer = employer;
			this.listofApplications = listofApplications;
		}
		
		public Employee(String location, LocalDate appliedDate,Employer employer, List<Applications>listofApplications) {
			super();
			this.location = location;
			this.appliedDate = appliedDate;
			this.employer = employer;
			this.listofApplications = listofApplications;
		}
		
		public Employee(String location, LocalDate appliedDate,Employer employer) {
			super();
			this.location = location;
			this.appliedDate = appliedDate;
			this.employer = employer;
		}

		

		public Employer getEmployer() {
			return employer;
		}

		public void setEmployer(Employer employer) {
			this.employer = employer;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public LocalDate getAppliedDate() {
			return appliedDate;
		}

		public void setAppliedDate(LocalDate appliedDate) {
			this.appliedDate = appliedDate;
		}

		public List<Applications> getListofApplications() {
			return listofApplications;
		}

		public void setListofApplications(List<Applications> listofApplications) {
			this.listofApplications = listofApplications;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", location=" + location + ", appliedDate=" + appliedDate + ", employer="
					+ employer + ", listofApplications=" + listofApplications + "]";
		}

		
		
	}
		


