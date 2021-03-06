package com.example.SafetyManagementSystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import org.junit.Assert;

import com.dao.InjuryCentreService;
import com.model.InjuryCentre;


@SpringBootTest
class InjuryCentreTest {
	@Autowired
	InjuryCentreService service;

	@Test
	void testAddInjury() {
		InjuryCentre centre=new InjuryCentre();
		centre.setPersonName("raghu");
		centre.setPersonAddress("banglore");
		centre.setReport("head injury");
		centre.setMobile("1234567890");
		service.addInjury(centre);
	InjuryCentre repot_to_be_added=service.findCentre(centre.getInjuryId());
	Assert.assertEquals("raghu", repot_to_be_added.getPersonName());
	Assert.assertEquals("banglore", repot_to_be_added.getPersonAddress());
	Assert.assertEquals("head injury", repot_to_be_added.getReport());
	Assert.assertEquals("1234567890", repot_to_be_added.getMobile());
	}

	@Test
	void testFindCentre() {
		InjuryCentre centre=new InjuryCentre();
		centre.setReport("leg pain");
		try {
			service.addInjury(centre);
		}
		catch(Exception e){
			System.out.println(e);
			
		}
		InjuryCentre centre2=service.findCentre(centre.getInjuryId());
		Assert.assertNull(centre2);
	}

	@Test
	void testFindAllCentre() {
		InjuryCentre centre=new InjuryCentre();
		centre.setPersonName("king");
		centre.setPersonAddress("mumbai");
		centre.setReport("neck injury");
		centre.setMobile("1122334455");
		service.addInjury(centre);
		InjuryCentre centre1=new InjuryCentre();
		centre1.setPersonName("sachin");
		centre1.setPersonAddress("chennai");
		centre1.setReport("heart injury");
		centre1.setMobile("0099887766");
		service.addInjury(centre1);
		InjuryCentre centre2=new InjuryCentre();
		centre2.setPersonName("vijay");
		centre2.setPersonAddress("kerla");
		centre2.setReport("back injury");
		centre2.setMobile("0099887766");
		service.addInjury(centre2);
		List<InjuryCentre> centrelist=service.findAllCentre();
		centrelist.get(0).getPersonName();
		Assert.assertEquals(centrelist.get(0).getPersonName(), "raghu");

		Assert.assertEquals(centrelist.get(1).getPersonName(),"king");
		Assert.assertEquals(centrelist.get(2).getPersonName(),"sachin");

		Assert.assertEquals(centrelist.get(3).getPersonName(),"vijay");
	}

	@Test
	void testUpdateCentre() {
		InjuryCentre centre1=new InjuryCentre();
		centre1.setPersonName("rajesh");
		centre1.setPersonAddress("new address");
		centre1.setReport("no injuries");
		centre1.setMobile("0000000000");
		service.addInjury(centre1);
		centre1.setReport("heavy injuries");
		service.updateCentre(centre1);
		Assert.assertEquals(true, service.updateCentre(centre1));
	}

	@Test
	void testDeleteCentre() {
		service.deleteCentre(2);
	InjuryCentre centre=	service.findCentre(2);
	Assert.assertNull(centre);
		
		
		
	}

}
