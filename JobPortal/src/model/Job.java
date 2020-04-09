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
	private String position;
	@Column(name = "SALARY")
	private String salary;
	@Column(name = "JOBDESC")
	private String jobdesc;

	public Job() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getJobdesc() {
		return jobdesc;
	}

	public void setJobdesc(String jobdesc) {
		this.jobdesc = jobdesc;
	}

	public Job(int id, String position, String salary, String jobdesc) {
		super();
		this.id = id;
		this.position = position;
		this.salary = salary;
		this.jobdesc = jobdesc;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", position=" + position + ", salary=" + salary + ", jobdesc=" + jobdesc + "]";
	}

	
	

}
