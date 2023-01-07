
public class Airport {
	private String airport_code;
	private String City;
	
	public Airport() {}
	
	public Airport(String airport_code,String City) {
		this.airport_code = airport_code;
		this.City= City;
	}
	public Airport(String airport_code) {
		this.airport_code = airport_code;
	}

	@Override
	public String toString() {
		return "Airport [airport_code=" + airport_code + ", City=" + City + "]";
	}

	public String getAirport_code() {
		return airport_code;
	}

	public void setAirport_code(String airport_code) {
		this.airport_code = airport_code;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}
	
	
}
