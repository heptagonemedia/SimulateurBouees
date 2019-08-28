package presentation;

import java.util.ArrayList;

import donnee.PointDonnee;

public class AffichageConsole {
	public static void afficher(ArrayList<PointDonnee> listePointsDonnees) {
		for(PointDonnee p : listePointsDonnees) {
			String infoString = "Bouee No." + p.getId_bouee() + "n" + p.getNo_seq() +"- Time: " + p.getMoment() + 
					"; Sel:" + p.getSalinite() + "; Temp:" + p.getTemperature() + 
					"; Debit:" + p.getDebit();
			System.out.println(infoString);
		}
	}
}
