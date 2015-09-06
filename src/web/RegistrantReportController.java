package web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Registrant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import service.RegistrationService;

public class RegistrantReportController extends AbstractController{
	@Autowired
	private RegistrationService rs;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		
		String output =
			ServletRequestUtils.getStringParameter(request, "output");

		ArrayList<Registrant> registrants = new ArrayList<>(rs.getRegistrants());
		
		if(output ==null || "".equals(output)){
			//return normal view
			return new ModelAndView("RegistrantSummary","registrants",registrants);
			
		}else if("EXCEL".equals(output.toUpperCase())){
			//return excel view
			return new ModelAndView("ExcelRegistrantSummary","registrants",registrants);
			
		}else{
			//return normal view
			return new ModelAndView("RegistrantSummary","registrants",registrants);
			
		}	
	}
}