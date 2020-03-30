package tn.esprit.spring.pi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.pi.service.VenteService;

@SpringBootTest
class DariApplicationTests {

	@Autowired
	VenteService ms;

	//@Test
	//public void AddMaison() {
		//Vente u1 = new Vente(Region.Ariana, "sokra", TypeBien.Maison, new Date(), 1200, "photo1.jpg");

		//ms.addVente(u1);

//	}
}
