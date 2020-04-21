

import java.util.ArrayList;
import java.util.List;

import controller.ApplicantHelper;
import controller.EmployerHelper;
import controller.JobHelper;
import model.Applicant;
import model.Employer;
import model.Job;

public class DBTesterWJoins {

	public DBTesterWJoins() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employer dmacc = new Employer("DMACC");
		EmployerHelper eh = new EmployerHelper();
		
		eh.insertEmployer(dmacc);
		
		Job j = new Job("Coordinator", dmacc, "Coordinates the activities of other staff");
		JobHelper jh = new JobHelper();
		
		Applicant app = new Applicant("Tjmorrissey", "Thomas Morrissey", "Associates Degree", "Norwalk");
		ApplicantHelper ah = new ApplicantHelper();
		
		jh.insertJob(j);
		ah.insertApplicant(app);
		
		
		List<Job> jobsAppliedFor = new ArrayList<Job>();
		jobsAppliedFor.add(j);
		app.setJobsAppliedFor(jobsAppliedFor);
		
		List<Applicant> appsForJob = new ArrayList<Applicant>();
		appsForJob.add(app);
		j.setJobApplicants(appsForJob);
		
		
		jh.updateJob(j);
		ah.updateApplicant(app);
		
		
		
		
		
		

	}
}
