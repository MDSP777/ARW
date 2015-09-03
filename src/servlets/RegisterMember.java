package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestHandler;

import service.RegTypeService;
import service.RegistrationService;
import model.Registrant;

public class RegisterMember implements HttpRequestHandler {
	@Autowired
	private RegistrationService rs;
	@Autowired
	private RegTypeService rts;
	
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String surname = request.getParameter("surname");
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String idNo = request.getParameter("idNo");
		String course = request.getParameter("course");
		String contactNo = request.getParameter("contactNo");
		String email = request.getParameter("email");
		String membershipType = request.getParameter("membershipType");
		String receiptNo = request.getParameter("receiptNo");
		Registrant r = new Registrant(surname, firstName, middleName,
				idNo, course, contactNo, email, rts.findBy(membershipType), receiptNo);
		rs.register(r);
		response.sendRedirect("form.jsp");
	}


}
