package org.LibrePlan;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestGestionFormulaireQualite {
	static Logger logger = LoggerFactory.getLogger(TestAdministrationDesCriteresCRI01.class);
	WebDriver driver;
	WebDriverWait wait;
	Actions action;

	// JEUX DE DONNEES
	String jdd_utilisateur = "admin";
	String jdd_motdepasse = "admin";
	String jdd_nom_haut_formulaire = "Formulaire Test 1";
	String jdd_nom_bas_formulaire = "Formulaire Test 1";
	String jdd_description_formulaire = "Formulaire Test 1";

	@Before
	public void setUp() {
		driver = SocleTechnique.choisirNavigateur(logger, ENavigateur.f);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 7000);
		action = new Actions(driver);
	}

	// @After
	// public void tearDown() {
	// driver.quit();
	// }

	@Test
	public void test (){
		driver.get("http://localhost:8090/libreplan/common/layout/login.zul");

		// Nettoyage, renseignenement champs et connexion
		SocleTechnique.seConnecter(jdd_utilisateur, jdd_motdepasse, driver);

		// Instanciation PageIndex et verification Page d'accueil
		PageIndex page_index = PageFactory.initElements(driver, PageIndex.class);
		assertTrue(page_index.isMessagePresent());
		logger.info("La page d'accueil s'affiche");
		
		// Appel méthode clicFormulaireQualite Instanciation PageFormulaireQualite
		PageFormulaireQualite page_formulairequalite = page_index.clicRessourceFormulaireQualite(driver);
		assertTrue(driver.findElement(By.xpath("//div[@class='z-column-cnt' and contains(.,'Nom')]")).isDisplayed()
				&& driver.findElement(By.xpath("//div[@class='z-column-cnt' and contains(.,'Description')]")).isDisplayed()
				&& driver.findElement(By.xpath("//div[@class='z-column-cnt' and contains(.,'Opérations')]"))
						.isDisplayed());
		assertTrue(driver.findElement(By.xpath("//table[@class='z-hbox']/tbody//tr/td/input[@type='text']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//td[@class='z-button-cm'][contains(.,'Créer')]")).isDisplayed());
		logger.info("Les éléments de la page Formulaire qualité Liste s'affichent");
		
		// Appel méthode clicRessourceCritere; Instanciation PageCreerCritere;
		page_formulairequalite .clicBoutonCreer(driver);
		
			
		
		// Appel de la méthode Remplir Description Formulaire pas de Test 4
		page_formulairequalite.rempliDescriptionFormulaire(jdd_description_formulaire);
		
//		// Appel de la méthode Remplir Nom Formulaire pas de Test 4		
//		page_formulairequalite.rempliNomHautFormulaire(jdd_nom_haut_formulaire);
		
		// Appel de la méthode click checkbox
		page_formulairequalite.cocheCheckboxAvancement();
		
		// Appel méthode clic Bouton Nouvel élément du formulaire qualité
		page_formulairequalite.clicBoutonListeFormulaireQualite();
		
		// Appel de la méthode Remplir Nom Formulaire pas de Test 4		
		page_formulairequalite.rempliNomBasFormulaire(jdd_nom_bas_formulaire);
		
		
	}

}
