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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "job")
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "JOBID")
	private int jobId;
	@Column(name = "TITLE")
	private String title;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "EMPLOYERID")
	private Employer employer;
	@Column(name = "JOBDESC")
	private String jobdesc;

	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable
	(
			name="job_applicants", 
			joinColumns= { @JoinColumn(name="JOBID", referencedColumnName="JOBID") },
			inverseJoinColumns= { @JoinColumn(name="APPLICANTID", referencedColumnName="APPLICANTID", unique=true) }
	)
	private List<Applicant> jobApplicants;

	public Job() {
		// TODO Auto-generated constructor stub
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public String getJobdesc() {
		return jobdesc;
	}

	public void setJobdesc(String jobdesc) {
		this.jobdesc = jobdesc;
	}
	
	public List<Applicant> getJobApplicants() {
		return jobApplicants;
	}

	public void setJobApplicants(List<Applicant> jobApplicants) {
		this.jobApplicants = jobApplicants;
	}

	public Job(String title, Employer employer, String jobdesc) {
		super();
	
		this.title = title;
		this.employer = employer;
		this.jobdesc = jobdesc;
	
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", title=" + title + ", employerId=" + employer + ", jobdesc=" + jobdesc
				+ ", jobsAppliedFor="  + jobApplicants + "]";
	}

	

}