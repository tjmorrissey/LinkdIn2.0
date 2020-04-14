package model;


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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "applicant")
public class Applicant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "APPLICANTID")
	private int applicantId;
	@Column(name = "NAME")
	private String name;
	@Column(name ="ADDRESS")
	private String address;
	@Column(name = "EDUCATIONLEVEL")
	private String educationLevel;
	
	
	/*@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
		@JoinTable
		(
				name="HISTORY", 
				joinColumns= { @JoinColumn(name="EMPLOYERID", referencedColumnName="JOBID") },
				inverseJoinColumns= { @JoinColumn(name="JOBID", referencedColumnName="JOBID", unique=true) }
		)
		private List<Job> jobsAppliedFor;*/

	public Applicant() {
		super();
	}

	public int getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	//public List<Job> getJobsAppliedFor() {
		//return jobsAppliedFor;
	//}

	//public void setJobsAppliedFor(List<Job> jobsAppliedFor) {
	//	this.jobsAppliedFor = jobsAppliedFor;
	//}

	public Applicant(String name,String educationLevel) {
		super();
		
		this.name = name;
		this.educationLevel = educationLevel;
	
	}

	@Override
	public String toString() {
		return "Applicant [applicantId=" + applicantId + ", name=" + name + ", address=" + address + ", educationLevel="
				+ educationLevel; // + ", jobsAppliedFor=" + jobsAppliedFor + "]";
	}
	
	
		
	
	
	
}
