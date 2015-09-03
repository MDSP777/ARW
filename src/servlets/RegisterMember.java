package servlets;

import java.io.IOException;

import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import service.RegistrationService;
import model.Registrant;

public class RegisterMember implements HttpRequestHandler {
	@Autowired
	private RegistrationService rs;
	
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("firstName")+" "+request.getParameter("surname");
		String idNo = request.getParameter("idNo");
		String course = request.getParameter("course");
		String contactNo = request.getParameter("contactNo");
		String email = request.getParameter("email");
		String membershipType = request.getParameter("membershipType");
		String receiptNo = request.getParameter("receiptNo");
		Registrant r = new Registrant(name, idNo, course, contactNo, email, membershipType, receiptNo);
		rs.register(r);
		response.sendRedirect("form.jsp");
	}


}
