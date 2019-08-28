package donnee;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Bouee {
	private Integer numero;
	private String description;
	private Long miseEnFonction;
	private Double longitude;
	private Double latitude;
	
	private ValeursInitiales valeursInitiales;
	
	private ArrayList<PointDonnee> listePointDonnee;
	private Random generateurDeHasard; 
	
	public Bouee(Integer numero, String description) {
		generateurDeHasard = new Random();
		
		valeursInitiales = new ValeursInitiales();
		
		longitude = valeursInitiales.getLongitude();
		latitude = valeursInitiales.getLatitude();
		this.numero = numero;
		this.description = description;
		miseEnFonction = new Date().getTime();
		
		listePointDonnee = new ArrayList<PointDonnee>();
		
		demarrerCollecte();
	}
	
	private void demarrerCollecte() {
		ScheduledExecutorService executor =
			    Executors.newSingleThreadScheduledExecutor();
		
		Runnable periodicTask = new Runnable() {
		    public void run() {
		        // Invoke method(s) to do the work
		    	listePointDonnee.add(genererPointDonnee());
		    }
		};

		executor.scheduleAtFixedRate(periodicTask, 0, 1, TimeUnit.SECONDS);
	}
	
	public ArrayList<PointDonnee> lireDonnees(){
		ArrayList<PointDonnee> templist = (ArrayList<PointDonnee>)listePointDonnee.clone();
		listePointDonnee.clear();
		return templist;
	}
	
	private PointDonnee genererPointDonnee() {
		PointDonnee p = new PointDonnee();
		
		p.setId_bouee(numero);
		p.setMoment(new Date().getTime());
		p.setTemperature(valeursInitiales.getTemperature() - 10 + (generateurDeHasard.nextFloat()*10));
		p.setSalinite(valeursInitiales.getSalinite() - 5 + (generateurDeHasard.nextFloat() * 5));
		p.setDebit(valeursInitiales.getDebit() - 1 + (generateurDeHasard.nextFloat() * 2));
		p.setLongitude(valeursInitiales.getLongitude() + ((-0.5 + generateurDeHasard.nextFloat())/10) );
		p.setLatitude(valeursInitiales.getLatitude() + ((-0.5 + generateurDeHasard.nextFloat())/10) );
		
		return p;
	}
}
