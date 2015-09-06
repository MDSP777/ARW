package test;

import static org.junit.Assert.*;
import model.Registrant;
import model.RegistrationType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.RegTypeService;
import service.RegistrationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/ApplicationContext.xml" })
public class InitRegistrants {
	@Autowired
	private RegistrationService rs;
	
	@Test
	public void initReg(){
		RegistrationType n = new RegistrationType("New", 250);
		RegistrationType ng = new RegistrationType("New (Group)", 220);
		RegistrationType o = new RegistrationType("Old", 220);
		RegistrationType og = new RegistrationType("Old (Group)", 200);
		RegistrationType h = new RegistrationType("Honorary", 50);
		
		Registrant avril = new Registrant("Fernandez", "Avril Ranezca", "Lim", "113something", 
				"BS CS-ST", "09something", "avril_fernandez@dlsu.edu.ph", n, "1");
		Registrant gio = new Registrant("Velez", "Gio Anton", "Tan", "113something", 
				"BS CS-ST", "09something", "gio_velez@dlsu.edu.ph", ng, "2");
		Registrant joswin = new Registrant("Go-Soco", "Joswin Paolo", "", "112something", 
				"BS CS-NE", "09something", "joswin_gosoco@dlsu.edu.ph", o, "3");
		Registrant marc = new Registrant("San Pedro", "Marc Dominic", "", "113something", 
				"BS CS-ST", "09something", "marc_sanpedro@dlsu.edu.ph", og, "4");
		Registrant clarisse = new Registrant("Poblete", "Clarisse Felicia", "Maramba", "113something", 
				"BS CS-ST", "09something", "clarisse_poblete@dlsu.edu.ph", h, "5");
		rs.register(avril);
		rs.register(gio);
		rs.register(marc);
		rs.register(joswin);
		rs.register(clarisse);
		assertTrue(true);
	}
}
