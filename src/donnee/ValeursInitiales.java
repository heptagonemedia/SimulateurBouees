package donnee;

import java.util.Random;

public class ValeursInitiales {
	private Float temperature;
	private Float salinite;
	private Float debit;
	private Double longitude;
	private Double latitude;
	
	public Float getTemperature() {
		return temperature;
	}

	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}

	public Float getSalinite() {
		return salinite;
	}

	public void setSalinite(Float salinite) {
		this.salinite = salinite;
	}

	public Float getDebit() {
		return debit;
	}

	public void setDebit(Float debit) {
		this.debit = debit;
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

	public ValeursInitiales() {
		genererValeursInitiales();
	}

	private void genererValeursInitiales() {
		Random generateurDeHasard = new Random();
		
		setTemperature(generateurDeHasard.nextFloat()*35f);
		setSalinite(generateurDeHasard.nextFloat()*20f);
		setDebit(generateurDeHasard.nextFloat()*generateurDeHasard.nextInt(5));
		setLongitude(generateurDeHasard.nextDouble()*10);
		setLatitude(generateurDeHasard.nextDouble()*10);
		
	}
}
