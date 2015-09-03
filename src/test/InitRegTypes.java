package test;

import static org.junit.Assert.*;
import model.RegistrationType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.RegTypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/ApplicationContext.xml" })
public class InitRegTypes {
	@Autowired
	private RegTypeService rts;
	
	@Test
	public void initReg(){
		RegistrationType n = new RegistrationType("New", 250);
		RegistrationType ng = new RegistrationType("New (Group)", 250);
		RegistrationType o = new RegistrationType("Old", 200);
		RegistrationType og = new RegistrationType("Old (Group)", 180);
		RegistrationType h = new RegistrationType("Honorary", 125);
		rts.add(n);
		rts.add(ng);
		rts.add(o);
		rts.add(og);
		rts.add(h);
		assertTrue(true);
	}
}
