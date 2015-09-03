package servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RegistrationType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestHandler;

import service.RegTypeService;

public class RegisterForm implements HttpRequestHandler {
	@Autowired
	private RegTypeService rts;
	
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<RegistrationType> regTypes = rts.findAllRegTypes();
		request.getSession().setAttribute("regTypes", regTypes);
		request.getRequestDispatcher("form.jsp").forward(request, response);
	}
}
