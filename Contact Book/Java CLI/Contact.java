package ContactBook;

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

	public class Info {
		private String data;
		private String tag;

		public Info(String data, String tag){
			this.data = data;
			this.tag = tag;
		}
		public boolean setTag(String newTag){
			this.tag = newTag;
			return true;
		}
		public String getTag(){
			return this.tag;
		}
	}
	public class Phone extends Info {
		public Phone(String data, String tag){
			super(data, tag);
		}
		public boolean setNumber(String newNumber){
			super.data = newNumber;
			return true;
		}
		public String getNumber(){
			return super.data;
		}
	}
	public class Email extends Info {
		public Email(String data, String tag){
			super(data, tag);
		}
		public boolean setAddress(String newAddress){
			super.data = newAddress;
			return true;
		}
		public String getAddress(){
			return super.data;
		}
	}
	public class Place extends Info {
		public Place(String data, String tag){
			super(data, tag);
		}
		public boolean setAddress(String newAddress){
			super.data = newAddress;
			return true;
		}
		public String getAddress(){
			return super.data;
		}
	}
}