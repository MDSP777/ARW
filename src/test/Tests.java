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
public class Tests {
	@Autowired
	private RegistrationService rs;
	@Autowired
	private RegTypeService rts;
	
	@Test
	public void testAddAndRetrieve(){
		Registrant r = new Registrant("San Pedro", "Marc", "", "11336617", 
				"BS CS-ST", "09989793916", "mdsp777@outlook.com", rts.findBy("New"), "1234");
		rs.register(r);
		assertTrue(true);
	}
	
	@Test
	public void testRetrieveRegType(){
		String name = "New";
		RegistrationType expected = new RegistrationType(name, 250.00);
		RegistrationType actual = rts.findBy(name);
		assertEquals(expected.getTypeName(), actual.getTypeName());
		assertEquals(expected.getAmount(), actual.getAmount(), 0.001);
	}
}
