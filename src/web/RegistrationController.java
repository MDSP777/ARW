package web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Registrant;
import model.RegistrationType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.RegTypeService;
import service.RegistrationService;

@Controller
public class RegistrationController {
	@Autowired
	private RegistrationService rs;
	@Autowired
	private RegTypeService rts;
	
	@RequestMapping("/RegisterForm")
	public void redirectToForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<RegistrationType> regTypes = rts.findAllRegTypes();
		request.getSession().setAttribute("regTypes", regTypes);
		request.getRequestDispatcher("WEB-INF/view/form.jsp").forward(request, response);
	}
	
	@RequestMapping("/RegisterMember")
	public void registerMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String surname = request.getParameter("surname");
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String idNo = request.getParameter("idNo");
		String course = request.getParameter("course");
		String contactNo = request.getParameter("contactNo");
		String email = request.getParameter("email");
		String membershipType = request.getParameter("membershipType");
		String receiptNo = request.getParameter("receiptNo");
		String resultMsg = "Registration successful!";
		Registrant r = new Registrant(surname, firstName, middleName,
				idNo, course, contactNo, email, rts.findBy(membershipType), receiptNo);
		try{
			rs.register(r);
		} catch(DataAccessException e){
			resultMsg = "Registration failed, an identical name already exists.";
		}
		request.getSession().setAttribute("resultMsg", resultMsg);
		response.sendRedirect("RegisterForm");
	}
	
	@RequestMapping("/ViewRegistrants")
	public void viewRegistrants(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<Registrant> registrants = rs.getRegistrants();
		request.getSession().setAttribute("registrants", registrants);
		request.getSession().setAttribute("totalRevenue", rs.calculateTotalRevenue());
		request.getRequestDispatcher("WEB-INF/view/view_registrants.jsp").forward(request, response);
	}
}
