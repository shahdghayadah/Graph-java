
import java.sql.Time;
public class Flight {
	private   String flight_number;
	private   double travel_distance;
	private   double cost;
	private   Time time ;
    
    public Flight() {
    	time = null;
    }
    
    public Flight(String flight_number,double travel_distance,double cost,Time time) {
    	this.flight_number = flight_number;
    	this.travel_distance = travel_distance;
    	this.cost = cost;
    	this.time = time;
    	
    }
    public Flight(String flight_number) {
    	time = null;
    	this.flight_number = flight_number;
    }

	@Override
	public String toString() {
		return "Flight [flight_number=" + flight_number + ", travel_distance=" + travel_distance + ", cost=" + cost
				+ ", time=" + time + "]";
	}

	public String getFlight_number() {
		return flight_number;
	}

	public void setFlight_number(String flight_number) {
		this.flight_number = flight_number;
	}

	public double getTravel_distance() {
		return travel_distance;
	}

	public void setTravel_distance(double travel_distance) {
		this.travel_distance = travel_distance;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
    
    
}
