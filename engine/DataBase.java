package engine;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DataBase {

	private static DataBase instance = new DataBase();
	
	private Set<Event> eventList; 
	private Set<User> userList;
	private Iterator<Event> it;
	
	private DataBase(){
		this.eventList = new HashSet<Event>();
		this.userList = new HashSet<User>();
		System.out.println("DataBase created");
	}
	
	public static DataBase getInstance(){
		return instance;
	}

	Set<Event> getEventList(){
		return this.eventList;
	}
	
	Set<User> getUserList(){
		return this.userList;
	}
	
	Event getEvent(String eventName){
		
		for (Event event : this.eventList) {
			if (event.getName().equals(eventName)) {
				return event;
			}
		}
		System.out.println("No such event");
		return null;
	}
	
	void addEventToDb(Event newEvent){
		if(this.eventList.add(newEvent)){
			System.out.println("Add to db successful");
			return;
		}
		System.out.println("Add to db failed: possible duplicate");
	}
	
	void removeEventFromDb(String eventName){
		this.it = this.eventList.iterator();
		while (this.it.hasNext()) {
			if (this.it.next().getName().equals(eventName)) {
				this.it.remove();
				return;
			}
		}
	}
	
	
	void addUserToDb(User newUser){
		this.userList.add(newUser);
	}

	void removeUserFromDb(User user){
		this.userList.remove(user);
	}
	
	public void showUserList(){
		System.out.println(this.userList);
	}
}
