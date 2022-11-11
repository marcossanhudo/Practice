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