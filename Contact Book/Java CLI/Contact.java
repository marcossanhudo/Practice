public class Contact {

	// Variables
	private int id;
	private String name;
	private Phone[] phones;
	private Email[] emails;
	private Place[] places;


	// Constructor methods
	public Contact(){
		this.name = "";
		this.phones = new Phone[0];
		this.emails = new Email[0];
		this.places = new Place[0];
	}
	
	public Contact(String name){
		this.name = name;
		this.phones = new Phone[0];
		this.emails = new Email[0];
		this.places = new Place[0];
	}

	public boolean setName(String name){
		this.name = name;
		return true;
	}
	public String getName(){
		return this.name;
	}
	public boolean setPhones(Phone[] phones){
		this.phones = phones;
		return true;
	}
	public Phone[] getPhones(){
		return this.phones;
	}
	public boolean setEmails(Email[] emails){
		this.emails = emails;
		return true;
	}
	public Email[] getEmails(){
		return this.emails;
	}
	public boolean setPlaces(Place[] places){
		this.places = places;
		return true;
	}
	public Place[] getPlaces(){
		return this.places;
	}
}