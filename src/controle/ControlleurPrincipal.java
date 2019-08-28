package controle;

import java.util.ArrayList;

import donnee.Bouee;
import donnee.Constantes;
import modele.Simulateur;
import presentation.AffichageConsole;

public class ControlleurPrincipal {
	private Simulateur simulateur;
	
	public ControlleurPrincipal() {
		simulateur = new Simulateur();
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
}

