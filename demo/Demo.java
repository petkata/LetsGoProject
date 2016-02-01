package demo;

import engine.*;

public class Demo {

	public static void main(String[] args) {
		
//		Event ev1 = new Event("Music concert", "2016-05-06", "Sofia", 56.32, "concert");
//		Event ev2 = new Event("Party people", "2016-03-06", "Varna", 36, "party");
//		Event ev3 = new Event("Christmas show", "2016-12-26", "Sofia", 45.32, "show program");
//		Event ev4 = new Event("Theatre", "2016-05-30", "Sofia", 100.32, "play");
		
		DataBase db = DataBase.getInstance();
		
		Admin admin = new Admin("admin@", "1234");
		admin.login("1234");
		admin.connectToDB(db);
//		admin.logout();
		
		admin.adminAddEvent(new Event("Theatre", "2016-05-30", "Sofia", 100.32, "play"));
		admin.adminAddEvent(new Event("Party people", "2016-03-06", "Varna", 36, "party"));
		admin.adminAddEvent(new Event("Music concert", "2016-05-06", "Sofia", 56.32, "concert"));
		admin.adminAddEvent(new Event("Christmas show", "2016-12-26", "Sofia", 45.32, "show program"));
		admin.adminAddEvent(new Event("Theatre", "2016-05-30", "Sofia", 100.32, "play"));
//		admin.adminRemoveEvent("Theatre");
//		System.out.println(ev1);
		
		User mitko = new User("mitko@abv.bg", "asdf");
		mitko.login("asdf");
		
//		admin.adminRemoveUser(mitko);
		
		mitko.userAddToWatchList("Music concert");
		mitko.userAddToWatchList("Not present event");
		mitko.userAddToWatchList("Theatre");
//		mitko.logout();
		mitko.userAddToWatchList("Christmas show");
//		mitko.userRemoveFromWatchList("Theatre");
		mitko.userShowWatchList();
		
	}
}
