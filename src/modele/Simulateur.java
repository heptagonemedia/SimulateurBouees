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
	
	public void procUnParSeconde(){
		demarrerCollecte(1);
	}
	
	private ArrayList<Bouee> creerBouees(Integer nbrBouees) {
		ArrayList<Bouee> listeBouees = new ArrayList<Bouee>();
		Bouee boueeTemporaire;
		for(int i = 1; i <= nbrBouees; i++) {
			boueeTemporaire = new Bouee(i, "Bouee test no. "+i);
			listeBouees.add(boueeTemporaire);
		}
		
		return listeBouees;
	}
	
	private void demarrerCollecte(Integer intervale) {
		for(Bouee b : listeBouees) 			
			b.demarrerCollecte(intervale);
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
