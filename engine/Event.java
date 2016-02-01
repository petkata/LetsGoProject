package engine;

import java.time.LocalDate;

import utils.FormatMoney;

public class Event {

	private String eventName;
	private LocalDate eventDate;
	private String eventLocation;
	private double eventTicketPrice;
	private String eventType;
//	private String eventDescription;
	
	public Event(String eventName, String eventDate, String eventLocation, double eventTicketPrice,
			String eventType) {
		this.eventName = eventName;
		this.eventDate = LocalDate.parse(eventDate);
		this.eventLocation = eventLocation;
		this.eventTicketPrice = eventTicketPrice;
		this.eventType = eventType.toLowerCase();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventDate == null) ? 0 : eventDate.hashCode());
		result = prime * result + ((eventLocation == null) ? 0 : eventLocation.hashCode());
		result = prime * result + ((eventName == null) ? 0 : eventName.hashCode());
		result = prime * result + ((eventType == null) ? 0 : eventType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (eventDate == null) {
			if (other.eventDate != null)
				return false;
		} else if (!eventDate.equals(other.eventDate))
			return false;
		if (eventLocation == null) {
			if (other.eventLocation != null)
				return false;
		} else if (!eventLocation.equals(other.eventLocation))
			return false;
		if (eventName == null) {
			if (other.eventName != null)
				return false;
		} else if (!eventName.equals(other.eventName))
			return false;
		if (eventType == null) {
			if (other.eventType != null)
				return false;
		} else if (!eventType.equals(other.eventType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.eventName + " " +
			   this.eventDate.toString() + " " + 
			   this.eventLocation + " " + 
			   FormatMoney.FromatMoney(this.eventTicketPrice) + " BGN.";
	}

	
	public String getName() {
		return this.eventName;
	}
}
