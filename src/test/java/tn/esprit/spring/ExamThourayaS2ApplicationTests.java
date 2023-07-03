package tn.esprit.spring;
import org.apache.logging.log4j.LogManager;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.repository.VoyageRepository;
import tn.esprit.spring.services.IVoyageService;
import org.apache.logging.log4j.Logger;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@SpringBootTest

@WebAppConfiguration
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ExamThourayaS2ApplicationTests {
	@Autowired
	IVoyageService  iVoyageService;
	@Autowired
	VoyageRepository voyageRepository;
	private static final Logger L = LogManager.getLogger(ExamThourayaS2ApplicationTests.class);

	@Before
	public void setUp(){

	try{
		Voyage voyage = new Voyage();
		voyage.setCodeVoyage(1234);
		voyage.setDateArrivee(new Date());
		voyage.setDateArrivee(new Date());
		voyage.setHeureArrivee(12);
		voyage.setHeureDepart(11);

		voyageRepository.save(voyage);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Test
	public void testGetAllVoyages() {
		java.util.List<Voyage> listVoyage = iVoyageService.recupererAll();
		assertEquals(0, listVoyage.size());
	}

	@Test
	public void log4J()
	{
		L.info("test success");

	}

}
