package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Applicant;

/**
 * Servlet implementation class createNewAppServlet
 */
@WebServlet("/createNewAppServlet")
public class createNewAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewAppServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String edLevel = request.getParameter("educationLevel");
		
		ApplicantHelper ah = new ApplicantHelper();
		
		Applicant check = ah.searchForApplicantByUsername(username);
		
		String path = "/index.jsp";
		
		//check if the username already exists
		if(check.getUsername().equalsIgnoreCase(username)) {
			path = "/createNewApplicant.jsp";
			
			String usernameTaken = "This Username is already Taken.  Please choose another.";
			
			request.setAttribute("errorCode", usernameTaken);
			
		}
		
		else {
		Applicant app = new Applicant(username, name, edLevel, address);
		
		ah.insertApplicant(app);
		
		System.out.println("New Applicant Created");
		System.out.println(app.toString());
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
