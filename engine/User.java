package engine;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class User extends Account{

	private Set<Event> watchtList;
	public User(String email, String password) {
		super(email, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void login(String pass) {
		if (!DataBase.getInstance().getUserList().contains(this)) {
			DataBase.getInstance().addUserToDb(this);
		}
		super.login(pass);
		
	}
	
	public void userAddToWatchList(String eventName){
		if (this.checkUser()) {
			if (this.watchtList == null) {
				this.watchtList = new HashSet<Event>();
			}
			if (DataBase.getInstance().getEvent(eventName) != null) {
				if(this.watchtList.add(DataBase.getInstance().getEvent(eventName))){
					
					System.out.println("Event added");
				}
			}
			else System.out.println("Add failed: possible duplicate or not present event");
			return;
		}
		System.out.println("Please login");
	}
	
	public void userRemoveFromWatchList(String eventName){
		if (this.checkUser()) {
			Iterator<Event> it;
			it = this.watchtList.iterator();
			while (it.hasNext()) {
				if (it.next().getName().equals(eventName)) {
					it.remove();
					return;
				}
			}
			System.out.println("Remove failed: possible event not in list");
			return;
		}
		System.out.println("Please login");
	}
	
	public void userShowWatchList(){
		if (this.checkUser()) {
			for (Event event : watchtList) {
				System.out.println(event);
			}
			return;
		}
		System.out.println("Please login");
	}

	public void editprofile(String newEmail, String newPassword){
		if (newEmail!=null) {
			super.setEmail(newEmail);
		}
		if (newPassword!=null) {
			super.setPassword(newPassword);
		}
	}
	
	private boolean checkUser(){
		if (super.getHasLogged() && DataBase.getInstance().getUserList().contains(this)) {
			return true;
		}
		else return false;
	}
}
