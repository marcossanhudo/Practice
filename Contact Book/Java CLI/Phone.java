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
	