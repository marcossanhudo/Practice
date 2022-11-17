import java.util.ArrayList;

public class Contact {

	// Variables
	private int id;
	private String name = "";
	private ArrayList<Phone> phones = new ArrayList<>();
	private ArrayList<Email> emails = new ArrayList<>();
	private ArrayList<Place> places = new ArrayList<>();


	// Constructor methods
	public Contact(){
	}
	
	public Contact(String name){
		this.name = name;
	}

	public boolean setName(String name){
		this.name = name;
		return true;
	}
	public String getName(){
		return this.name;
	}
	public boolean setPhones(ArrayList<Phone> phones){
		this.phones = phones;
		return true;
	}
	public ArrayList<Phone> getPhones(){
		return this.phones;
	}
	public boolean setEmails(ArrayList<Email> emails){
		this.emails = emails;
		return true;
	}
	public ArrayList<Email> getEmails(){
		return this.emails;
	}
	public boolean setPlaces(ArrayList<Place> places){
		this.places = places;
		return true;
	}
	public ArrayList<Place> getPlaces(){
		return this.places;
	}
}