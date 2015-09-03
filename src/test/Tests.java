package test;

import static org.junit.Assert.*;

import javax.persistence.PersistenceUnit;

import model.Registrant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.RegistrationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/ApplicationContext.xml" })
public class Tests {
	@Autowired
	private RegistrationService rs;
	
	@Test
	public void testAddAndRetrieve(){
		assertEquals(0, rs.getRegistrants().size());
		Registrant r = new Registrant("Marc", "11336617", "BS CS-ST", "09989793916", "mdsp777@outlook.com", "New", "1234");
		rs.register(r);
		assertEquals(1, rs.getRegistrants().size());
	}
}
