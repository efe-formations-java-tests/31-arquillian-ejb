package fr.formation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import fr.formation.ejb.CapsConvertisseur;
import fr.formation.ejb.CapsService;
import fr.formation.ejb.ConvertEnMinuscule;

@RunWith(Arquillian.class)
public class CapsTest {
	@Inject
	private CapsService capsService;

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class)
				.addClasses(CapsService.class, CapsConvertisseur.class, ConvertEnMinuscule.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Test
	public void givenWord__WhenUppercase__ThenLowercase() {
		
		assertTrue("en_majuscule".equals(capsService.getConvertedCaps("EN_MAJUSCULE")));
		assertEquals("en_majuscule", capsService.getConvertedCaps("EN_MAJUSCULE"));
	}
}

