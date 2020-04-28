package application;

public class Flight {
	private int flightId;
	private String dateCreated;
	private String cityPrefix ;
	private String cityName ;
	private String destinantionPrefix;
	private String destinantionCity;
	private String timeIn;
	private String timeOut;
	
	
	public Flight() {
		this.flightId = 0;
		this.dateCreated =  "";
		this.cityPrefix ="";
		this.cityName = "";
		this.destinantionPrefix = "";
		this.destinantionCity = "";
		this.timeIn ="";
		this.timeOut ="";
	}
	public Flight(int flightId ,String dateCreated,String cityPrefix, String cityName,String destinantionPrefix, String destinantionCity,String timeIn, String timeOut) {
		this.flightId = flightId;
		this.dateCreated = dateCreated;
		this.cityPrefix =cityPrefix;
		this.cityName = cityName;
		this.destinantionPrefix = destinantionPrefix;
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
	public String getCityPrefix() {
		return cityPrefix;
	}
	public void setCityPrefix(String cityPrefix) {
		this.cityPrefix = cityPrefix;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getDestinantionPrefix() {
		return destinantionPrefix;
	}
	public void setDestinantionPrefix(String destinantionPrefix) {
		this.destinantionPrefix = destinantionPrefix;
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