package fr.cavp.ctx.test;

import java.math.BigDecimal;
import java.util.Date;

import javax.inject.Inject;


import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;
import fr.cavp.ctx.model.Contrainte;
import fr.cavp.ctx.service.GestionContrainte;

@RunWith(Arquillian.class)
public class GestionContrainteTest {

	@Deployment
	public static Archive<?> createTestArchive() {
	return ShrinkWrap.create(WebArchive.class, "test.war")
				            .addClasses(GestionContrainte.class)
				            .addPackage("fr.cavp.ctx.model")
				            .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
				            .addAsResource("import.sql","import.sql")
				            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
				   }
	
	@Inject
	private GestionContrainte gestionContrainte;
	
	@Test
	public void test() {
		Contrainte contrainte = new Contrainte();
		contrainte.setDossier(101);
		contrainte.setDateEmission(new Date());
		contrainte.setPeriode("1-1/2011");
		contrainte.setMontantDu(new BigDecimal(120.36));
		
		gestionContrainte.createContrainte(contrainte);
		
		assertNotNull(contrainte.getId());
	}

}
