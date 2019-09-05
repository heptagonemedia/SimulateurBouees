package controle;

import java.util.ArrayList;

import donnee.Bouee;
import donnee.Constantes;
import modele.Simulateur;
import presentation.AffichageConsole;
import presentation.SauvegardeFichier;
import presentation.insererBaseDonnee;

public class ControlleurPrincipal {
	private Simulateur simulateur;
	
	public ControlleurPrincipal() {
		simulateur = new Simulateur();
	}
	
	public void demarrerCollecte() {
		enregistrerDansLaDB();
		simulateur.procUnParSeconde();
	}
	
	public void genererNombrePoints(Integer nombre) {
		//AffichageConsole.afficher(simulateur.procGenererPoints(nombre));
		//SauvegardeFichier.sauvegarder("test", simulateur.procGenererPoints(nombre));
		//insererBaseDonnee.inserer(simulateur.procGenererPoints(nombre));
		enregistrerDansLaDB();
	}

	public void attendre(Integer ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void afficherConsole() {
		AffichageConsole.afficher(simulateur.lireDonnees());
		
	}

	public void enregistrerDansLaDB(){
		simulateur.enregistrerBouees();
	}
}

