public class Info {
	protected String data;
	protected String tag;
	
	public Info(String data, String tag){
		this.data = data;
		this.tag = tag;
	}
	public boolean setData(String newData){
		this.data = newData;
		return true;
	}
	public String getData(){
		return this.data;
	}
	public boolean setTag(String newTag){
		this.tag = newTag;
		return true;
	}
	public String getTag(){
		return this.tag;
	}
}
	