package modele;

import java.util.ArrayList;

import donnee.Bouee;
import donnee.Constantes;
import donnee.PointDonnee;

public class Simulateur {
	private ArrayList<Bouee> listeBouees;
	private ArrayList<PointDonnee> listePointsDonnees;
	
	public Simulateur() {
		listeBouees = creerBouees(Constantes.NBR_BOUEES);
		listePointsDonnees = new ArrayList<PointDonnee>();
		
	}
	
	private ArrayList<Bouee> creerBouees(Integer nbrBouees) {
		ArrayList<Bouee> listeBouees = new ArrayList<Bouee>();
		Bouee boueeTemporaire;
		for(int i = 1; i <= 50; i++) {
			boueeTemporaire = new Bouee(i, "Bouee test no. "+i);
			listeBouees.add(boueeTemporaire);
		}
		
		return listeBouees;
	}

	public ArrayList<PointDonnee> lireDonnees(){
		ArrayList<PointDonnee> returnList = new ArrayList<PointDonnee>();
		for(Bouee b : listeBouees) {
			for(PointDonnee p : b.lireDonnees()) {
				returnList.add(p);
			}
				
		}
		return returnList;
	}
}
