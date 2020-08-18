package org.LibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageFormulaireQualite {

	// WEBELEMENTS
	// Boutons et icônes
	@FindBy(xpath = "//td[@class='z-button-cm'][contains(.,'Créer')]")
	private WebElement bouton_creer;

	// Champs et menus
	@FindBy(xpath = "//span[text()='Nom']/parent::div/parent::td/following-sibling::td/div/input")
	private WebElement champ_nomhaut;

	@FindBy(xpath = "//textarea")
	private WebElement champ_description;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement checkbox_avancement;

	@FindBy(xpath = "//td[1][contains(.,'Nouvel élément du formulaire qualité')]/span[@class='z-button']")
	private WebElement bouton_listeformulairequalite;
	
	@FindBy(xpath = "//div[@class='z-row-cnt z-overflow-hidden']/input[@class='z-textbox']")
	private WebElement champ_nombas;

	
	// METHODES
	// Méthodes pour renseigner et vérifier des champs
	
	public void clicBoutonCreer(WebDriver driver) {
		bouton_creer.click();

	}

	public void rempliDescriptionFormulaire(String d) {

		SocleTechnique.renseignerChamps(champ_description, d);
	}

	public void rempliNomHautFormulaire(String n) {
		SocleTechnique.renseignerChamps(champ_nomhaut, n);
	}

	public void cocheCheckboxAvancement() {
		if (checkbox_avancement.isSelected()) {

		} else
			checkbox_avancement.click();
	}
	
	public void clicBoutonListeFormulaireQualite() {
		bouton_listeformulairequalite.click();
	}
	
	public void rempliNomBasFormulaire(String n) {
		SocleTechnique.renseignerChamps(champ_nombas, n);
	}

}
