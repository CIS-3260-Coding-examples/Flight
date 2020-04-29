package Classes;

import java.util.ArrayList;

public class Flight {
	private int flightId;
	private String dateCreated;
	private String cityName ;
	private String destinantionCity;
	private String timeIn;
	private String timeOut;
	private static ArrayList<Flight> newflight;
	
	
	public Flight() {
		this.flightId = 0;
		this.dateCreated =  "";
		this.cityName = "";
		this.destinantionCity = "";
		this.timeIn ="";
		this.timeOut ="";
	}
	public Flight(int flightId ,String dateCreated, String cityName, String destinantionCity,String timeIn, String timeOut) {
		this.flightId = flightId;
		this.dateCreated = dateCreated;
		this.cityName = cityName;
		this.destinantionCity = destinantionCity;
		this.timeIn = timeIn;
		this.timeOut = timeOut;

	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getDestinantionCity() {
		return destinantionCity;
	}
	public void setDestinantionCity(String destinantionCity) {
		this.destinantionCity = destinantionCity;
	}
	public String getTimeIn() {
		return timeIn;
	}
	public void setTimeIn(String timeIn) {
		this.timeIn = timeIn;
	}
	public String getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}
}