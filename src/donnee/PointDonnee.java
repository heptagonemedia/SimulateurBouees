package donnee;

import java.util.Date;

public class PointDonnee {
	private Integer id_bouee;
	private Integer no_seq;
	private Float temperature;
	private Float salinite;
	private Float debit;
	private Long moment;
	private Double longitude;
	private Double latitude;
	
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
}
