package main;

import java.util.Date;

import controle.ControlleurPrincipal;
import donnee.PointDonnee;
import modele.Simulateur;
import presentation.AffichageConsole;
import presentation.TransmissionSocket;

public class App {

	public static void main(String[] args) {

		ControlleurPrincipal controleur = new ControlleurPrincipal();
		long time1 = new Date().getTime();
		
		
		controleur.genererNombrePoints(5);
		
		long time = new Date().getTime() - time1;
		System.out.println("Processed in " + time + "ms.");


		
		

		//controleur.demarrerCollecte();

		/*controleur.attendre(6500);

		controleur.afficherConsole();

		controleur.attendre(6500);

		controleur.afficherConsole();*/
		

	}

}
