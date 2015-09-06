package view;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Registrant;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ExcelRegistrantReportView extends AbstractExcelView{
	
	@Override
	protected void buildExcelDocument(Map model, HSSFWorkbook workbook,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
	
		ArrayList<Registrant> registrants = (ArrayList<Registrant>) model.get("registrants");
		//create a wordsheet
		HSSFSheet sheet = workbook.createSheet("Registrant Report");
		
		HSSFRow header = sheet.createRow(0);
		header.createCell(0).setCellValue("#");
		header.createCell(1).setCellValue("Surname");
		header.createCell(2).setCellValue("First Name");
		header.createCell(3).setCellValue("Middle Name");
		header.createCell(4).setCellValue("ID Number");
		header.createCell(5).setCellValue("Email Address");
		header.createCell(6).setCellValue("Course");
		header.createCell(7).setCellValue("Membership Type");
		
		
		int rowNum = 1;
		for (Registrant entry : registrants) {
			//create the row data
			HSSFRow row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(rowNum-1);
			row.createCell(1).setCellValue(entry.getSurname());
			row.createCell(2).setCellValue(entry.getFirstName());
			row.createCell(3).setCellValue(entry.getMiddleName());
			row.createCell(4).setCellValue(entry.getIdNo());
			row.createCell(5).setCellValue(entry.getEmail());
			row.createCell(6).setCellValue(entry.getCourse());
			row.createCell(7).setCellValue(entry.getMembershipTypeName());
        }
	}
}