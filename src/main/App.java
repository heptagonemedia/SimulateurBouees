package main;

import donnee.PointDonnee;
import modele.Simulateur;

public class App {

	public static void main(String[] args) {
		/*
		long time1 = new Date().getTime();

		
		
		
		long time = new Date().getTime() - time1;
		System.out.println("Processed in " + time + "ms.");
		
		for(PointDonnee p : listePointsDonnees) {
			System.out.println(p.getId_bouee() + ": " + p.getMoment() + ": " + p.getSalinite() + ": " + p.getTemperature() + ": " + p.getDebit());
		}
		*/
		
		Simulateur sim = new Simulateur();
		try {
			Thread.sleep(4500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(PointDonnee p : sim.lireDonnees()) {
			System.out.println(p.getId_bouee() + ": " + p.getMoment() + ": " + p.getSalinite() + ": " + p.getTemperature() + ": " + p.getDebit());
		}
		
	}

}
