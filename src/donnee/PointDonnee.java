package donnee;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Date;
import java.util.Locale;

public class PointDonnee {

	private static int compteur = 0;
	private Integer id_bouee;
	private Integer no_seq;
	private Float temperature;
	private Float salinite;
	private Float debit;
	private Long moment;
	private Double longitude;
	private Double latitude;
	private Integer batterie = 0;

	public PointDonnee(Integer id_bouee) {
		this.id_bouee = id_bouee;
		compteur++;
		this.no_seq = compteur;
	}

	public int getId_bouee() {
		return id_bouee;
	}
	
	public void setId_bouee(Integer id_bouee) {
		this.id_bouee = id_bouee;
	}
	
	public Integer getNo_seq() {
		return no_seq;
	}

	public void setNo_seq(Integer no_seq) {
		this.no_seq = no_seq;
	}

	public float getTemperature() {
		return temperature;
	}
	
	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}
	
	public float getSalinite() {
		return salinite;
	}
	
	public void setSalinite(Float salinite) {
		this.salinite = salinite;
	}
	
	public float getDebit() {
		return debit;
	}
	
	public void setDebit(Float debit) {
		this.debit = debit;
	}
	
	public Long getMoment() {
		return moment;
	}
	
	public void setMoment(Long moment) {
		this.moment = moment;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		DecimalFormatSymbols  symbole = new DecimalFormatSymbols(new Locale("FR", "CA"));
		symbole.setDecimalSeparator('.');

		DecimalFormat format8decimale = new DecimalFormat("#.########", symbole);
		DecimalFormat format2decimale = new DecimalFormat("#.##", symbole);

		String chaine = String.join(";", id_bouee.toString(), format2decimale.format(temperature), format2decimale.format(salinite),
				format2decimale.format(debit), moment.toString(), format8decimale.format(longitude), format8decimale.format(latitude), batterie.toString());
		return chaine;
	}
}
