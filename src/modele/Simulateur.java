package modele;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import donnee.BaseDeDonnees;
import donnee.Bouee;
import donnee.Constantes;
import donnee.PointDonnee;

public class Simulateur {
	private ArrayList<Bouee> listeBouees;
	private ArrayList<PointDonnee> listePointsDonnees;

	private BaseDeDonnees baseDeDonnees = BaseDeDonnees.getInstance();
	
	public Simulateur() {
		listeBouees = creerBouees(Constantes.NBR_BOUEES);
		listePointsDonnees = new ArrayList<PointDonnee>();
	}
	
	public void procUnParSeconde(){
		demarrerCollecte(1);
	}
	
	public ArrayList<PointDonnee> procGenererPoints(Integer nombre) {
		ArrayList<PointDonnee> listePointsDonneesLocale = new ArrayList<PointDonnee>();
		for(Bouee b : listeBouees) 
			listePointsDonneesLocale.addAll(b.genererNombrePointDonnee(nombre));
		return listePointsDonneesLocale;
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

	public void enregistrerBouees(){

		for(Bouee b : listeBouees){
			String queryBouee = "INSERT INTO bouees(id, numero, description, date_debut, latitude, longitude) VALUES(?,?,?,?,?,?)";

			try{
				PreparedStatement requeteBoueeParametree = baseDeDonnees.getConnection().prepareStatement(queryBouee);

				requeteBoueeParametree.setInt(1, b.getNumero());
				requeteBoueeParametree.setInt(2, b.getNumero());
				requeteBoueeParametree.setString(3, b.getDescription());
				requeteBoueeParametree.setString(4, String.valueOf(b.getMiseEnFonction()));
				requeteBoueeParametree.setString(5, String.valueOf(b.getLatitude()));
				requeteBoueeParametree.setString(6, String.valueOf(b.getLongitude()));

				requeteBoueeParametree.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
