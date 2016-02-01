package engine;

public class Admin extends Account{

	private DataBase db;
	private boolean hasConnected;
	
	public Admin(String email, String password) {
		super(email, password);
	}
	
	public void connectToDB(DataBase db){
		if (super.getHasLogged()) {
			this.db = db;
			this.hasConnected = true;
			System.out.println("Connected to db");
		}
	}
	
	public void adminAddEvent(Event event){
		if (this.checkAdmin()) {
			this.db.addEventToDb(event);
			return;
		}
		System.out.println("eRROR");
	}
	
	public void adminRemoveEvent(String eventName){
		if (this.checkAdmin()) {
			this.db.removeEventFromDb(eventName);
			System.out.println("Event removed");
			return;
		}
		System.out.println("eRROR");
	}
	
	public void adminRemoveUser(User user){
		if (this.checkAdmin()) {
			DataBase.getInstance().removeUserFromDb(user);
			System.out.println("user removed");
			return;
		}
		System.out.println("eRROR");
		
	}
	
	private boolean checkAdmin(){
		if (super.getHasLogged() && this.hasConnected) {
			return true;
		}
		return false;
	}
}

