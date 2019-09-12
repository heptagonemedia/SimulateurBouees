package donnee;

import presentation.TransmissionSocket;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Bouee {

	private Integer idBouee;
	private Integer no_seq;
	private String description;
	private Long miseEnFonction;
	private Double longitude;
	private Double latitude;
	
	private ValeursInitiales valeursInitiales;
	
	private ArrayList<PointDonnee> listePointDonnee;
	private Random generateurDeHasard;

	private float[][] tabTempMinMax;
	private BaseDeDonnees baseDeDonnees;

    TransmissionSocket transmissionSocket = null;
    String hostName = "10.1.106.12";
    int portNumber = 1432;
	
	public Bouee(Integer idBouee, String description) {
		generateurDeHasard = new Random();
		
		valeursInitiales = new ValeursInitiales();
		
		longitude = valeursInitiales.getLongitude();
		latitude = valeursInitiales.getLatitude();
		this.idBouee = idBouee;
		this.description = description;
		miseEnFonction = new Date().getTime();
		no_seq = 0;
		
		listePointDonnee = new ArrayList<PointDonnee>();

		tabTempMinMax = remplirTabTemp();
		baseDeDonnees = BaseDeDonnees.getInstance();
	}
	
	public void demarrerCollecte(Integer intervale) {
		ScheduledExecutorService executor =
			    Executors.newSingleThreadScheduledExecutor();
		
		Runnable periodicTask = new Runnable() {
		    public void run() {
		        // Invoke method(s) to do the work
		    	listePointDonnee.add(genererPointDonnee());
		    }
		};

		executor.scheduleAtFixedRate(periodicTask, 0, intervale, TimeUnit.SECONDS);
	}
	
	public ArrayList<PointDonnee> lireDonnees(){
		ArrayList<PointDonnee> templist = (ArrayList<PointDonnee>)listePointDonnee.clone();
		listePointDonnee.clear();
		return templist;
	}
	
	private PointDonnee genererPointDonnee() {
		PointDonnee p = new PointDonnee(idBouee);

		p.setMoment(new Date().getTime());

		//p.setTemperature(valeursInitiales.getTemperature() - 10 + (generateurDeHasard.nextFloat()*10));
		p.setTemperature(generateurDeHasard.nextFloat() * ((tabTempMinMax[0][1] - tabTempMinMax[0][0]) + 1) + tabTempMinMax[0][0]);


		p.setSalinite(valeursInitiales.getSalinite() - 5 + (generateurDeHasard.nextFloat() * 5));
		p.setDebit(valeursInitiales.getDebit() - 1 + (generateurDeHasard.nextFloat() * 2));
		p.setLongitude(valeursInitiales.getLongitude() + ((-0.5 + generateurDeHasard.nextFloat())/10) );
		p.setLatitude(valeursInitiales.getLatitude() + ((-0.5 + generateurDeHasard.nextFloat())/10) );

		enregistrerDonneeDansLaDB(p);
		
		return p;
	}
	
	private PointDonnee genererPointDonnee(Date moment) {
		PointDonnee p = new PointDonnee(idBouee);

		p.setMoment(moment.getTime());

		p.setTemperature(valeursInitiales.getTemperature() - 10 + (generateurDeHasard.nextFloat()*10));
		p.setTemperature(generateurDeHasard.nextFloat() * ((tabTempMinMax[0][1] - tabTempMinMax[0][0]) + 1) + tabTempMinMax[0][0]);

		p.setSalinite(valeursInitiales.getSalinite() - 5 + (generateurDeHasard.nextFloat() * 5));
		p.setDebit(valeursInitiales.getDebit() - 1 + (generateurDeHasard.nextFloat() * 2));
		p.setLongitude(valeursInitiales.getLongitude() + ((-0.5 + generateurDeHasard.nextFloat())/10) );
		p.setLatitude(valeursInitiales.getLatitude() + ((-0.5 + generateurDeHasard.nextFloat())/10) );

		//enregistrerDonneeDansLaDB(p);

		transmissionSocket.send(p.toString());
		
		return p;
	}
	
	
	public ArrayList<PointDonnee> genererNombrePointDonnee(Integer nombre){
		Calendar cal = Calendar.getInstance();

		ArrayList<PointDonnee> listePointDonneeLocale = new ArrayList<PointDonnee>();
		for(int i = 0 ; i < nombre ; i++) {
			cal.add(Calendar.SECOND, 1);
			if(i%1000 == 0){
			    System.out.println(nombre - i + "");
            }
			listePointDonneeLocale.add(this.genererPointDonnee(cal.getTime()));
		}
		return listePointDonneeLocale;
	}

	public void fabriquerNombrePointDonnee(Integer nombre){
        Calendar cal = Calendar.getInstance();
        transmissionSocket = new TransmissionSocket(hostName, portNumber);
        transmissionSocket.commencerDiscussion(hostName, portNumber);
        for(int i = 0 ; i < nombre ; i++) {
            cal.add(Calendar.SECOND, 1);
            if(i%1000 == 0){
                System.out.println(nombre - i + "");
            }
            String hostName = "10.1.106.12";
            int portNumber = 1432;

            genererPointDonnee(cal.getTime());
            //enregistrerDonneeDansLaDB(genererPointDonnee(cal.getTime()));
        }
        transmissionSocket.send("\r\nEnd;");
    }


	public void enregistrerDonneeDansLaDB(PointDonnee p){

		String queryDonnee = "INSERT INTO donnee_bouees(id_bouee, temperature, salinite, debit," +
				"valide, date_temps, latitude, longitude, batterie) VALUES(?,?,?,?,?,?,?,?,?)";

		try{
			PreparedStatement requeteDonneeParametree = baseDeDonnees.getConnection().prepareStatement(queryDonnee);

			//requeteDonneeParametree.setInt(1, p.getNo_seq());
			requeteDonneeParametree.setInt(1, p.getId_bouee());
			requeteDonneeParametree.setFloat(2, p.getTemperature());
			requeteDonneeParametree.setFloat(3, p.getSalinite());
			requeteDonneeParametree.setFloat(4, p.getDebit());
			requeteDonneeParametree.setBoolean(5, true);
			java.util.Date date = new java.util.Date(p.getMoment());
			java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
			requeteDonneeParametree.setTimestamp(6, timestamp);
			requeteDonneeParametree.setDouble(7, p.getLatitude());
			requeteDonneeParametree.setDouble(8, p.getLongitude());
			requeteDonneeParametree.setInt(9, 100);

			requeteDonneeParametree.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public float[][] remplirTabTemp(){
		float[][] tab = new float[12][2];

		tab[0][0] = 0;
		tab[0][1] = 5;

		tab[1][0] = 0;
		tab[1][1] = 3;

		tab[2][0] = 3;
		tab[2][1] = 5;

		tab[3][0] = 5;
		tab[3][1] = 7;

		tab[4][0] = 7;
		tab[4][1] = 17;

		tab[5][0] = 15;
		tab[5][1] = 20;

		tab[6][0] = 20;
		tab[6][1] = 25;

		tab[7][0] = 23;
		tab[7][1] = 25;

		tab[8][0] = 17;
		tab[8][1] = 23;

		tab[9][0] = 10;
		tab[9][1] = 20;

		tab[10][0] = 7;
		tab[10][1] = 15;

		tab[11][0] = 3;
		tab[11][1] = 10;

		return tab;
	}

	public Integer getIdBouee() {
		return idBouee;
	}

	public void setIdBouee(Integer idBouee) {
		this.idBouee = idBouee;
	}

	public Integer getNo_seq() {
		return no_seq;
	}

	public void setNo_seq(Integer no_seq) {
		this.no_seq = no_seq;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getMiseEnFonction() {
		return miseEnFonction;
	}

	public void setMiseEnFonction(Long miseEnFonction) {
		this.miseEnFonction = miseEnFonction;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public ValeursInitiales getValeursInitiales() {
		return valeursInitiales;
	}

	public void setValeursInitiales(ValeursInitiales valeursInitiales) {
		this.valeursInitiales = valeursInitiales;
	}

	public ArrayList<PointDonnee> getListePointDonnee() {
		return listePointDonnee;
	}

	public void setListePointDonnee(ArrayList<PointDonnee> listePointDonnee) {
		this.listePointDonnee = listePointDonnee;
	}
}
