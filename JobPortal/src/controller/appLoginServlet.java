package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Applicant;

/**
 * Servlet implementation class appLoginServlet
 */
@WebServlet("/appLoginServlet")
public class appLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public appLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ApplicantHelper ah = new ApplicantHelper();
		Applicant app = new Applicant();
		String username = request.getParameter("username");
		
		app = ah.searchForApplicantByUsername(username);
		
		String path = "/applicantHomePage.jsp";
		
		request.setAttribute("applicant", app);
		
		if(app.getUsername().isEmpty()) {
			path = "/index.jsp";
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
