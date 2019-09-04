package presentation;

import java.util.ArrayList;

import donnee.PointDonnee;
import donnee.PointDonneeDAO;

public class insererBaseDonnee {
	public static void inserer(ArrayList<PointDonnee> donnees) {
		for(PointDonnee p : donnees) {
			PointDonneeDAO pDAO = new PointDonneeDAO();
			pDAO.inserer(p);
		}
	}
}
