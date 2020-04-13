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
	@Column(name = "FIRSTNAME")
	private String fName;
	@Column(name = "LASTNAME")
	private String lName;
	@Column(name ="ADDRESS")
	private Address address;
	@Column(name = "EDUCATIONLEVEL")
	private String educationLevel;
	@Column(name = "SCHOOLNAME")
	private String schoolName;
	
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
		@JoinTable
		(
				name="JOBS_APPLIED_FOR", 
				joinColumns= { @JoinColumn(name="APPLICANTID", referencedColumnName="APPLICANTID") },
				inverseJoinColumns= { @JoinColumn(name="JOBID", referencedColumnName="ID", unique=true) }
		)
		private List<Job> jobsAppliedFor;

	public Applicant() {
		super();
	}
	
	public Applicant(int applicantId, String fName, String lName, Address address, String educationLevel, String schoolName, List<Job> jobsAppliedFor) {
		super();
		this.applicantId = applicantId;
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.educationLevel = educationLevel;
		this.schoolName = schoolName;
		this.jobsAppliedFor = jobsAppliedFor;
	}
	
	public Applicant(String fName, String lName, Address address, String educationLevel, String schoolName, List<Job> jobsAppliedFor) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.educationLevel = educationLevel;
		this.schoolName = schoolName;
		this.jobsAppliedFor = jobsAppliedFor;
	}
	
	public Applicant(String fName, String lName, Address address, String educationLevel, String schoolName) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.educationLevel = educationLevel;
		this.schoolName = schoolName;
	}
	
	
	
	public int getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public List<Job> getJobsAppliedFor() {
		return jobsAppliedFor;
	}

	public void setJobsAppliedFor(List<Job> jobsAppliedFor) {
		this.jobsAppliedFor = jobsAppliedFor;
	}

	
	@Override
	public String toString() {
		return "Applicant [applicantId=" + applicantId + ", fName=" + fName + ", lName=" + lName + ", address="
				+ address + ", educationLevel=" + educationLevel + ", schoolName=" + schoolName + ", jobsAppliedFor="
				+ jobsAppliedFor + "]";
	}
		
	
	
	
}
