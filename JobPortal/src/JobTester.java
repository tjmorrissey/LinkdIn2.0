
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.EmployerHelper;
import controller.JobHelper;
import model.Applicant;
import model.Employer;
import model.Job;

public class JobTester {

	public JobTester() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employer dmacc = new Employer("DMACC");
		EmployerHelper ldh = new EmployerHelper();
		Job shampoo = new Job("Manager", dmacc, "Going for a walk and doing nothing.");
		Applicant app = new Applicant("Susan", "Bachelors");
		List<Applicant> susansItems = new ArrayList<Applicant>();
		susansItems.add(app);
		ldh.insertEmployer(dmacc);

		JobHelper susansList = new JobHelper();
		susansList.setListOfItems(susansItems);
		ldh.insertNewListDetails(susansList);
		List<ListDetails> allLists = ldh.getLists();
		for (ListDetails a : allLists) {
			System.out.println(a.toString());

		}

	}
}
