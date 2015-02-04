package naruhina.toeica.view;

public class SlotData {
	public int id = -1;
	public String data = "";
	public SlotData() {
		super();
	}
	public SlotData(int id, String data) {
		super();
		this.id = id;
		this.data = data;
	}
	public SlotData setId(int id) {
		this.id = id;
		return this;
	}
	public SlotData setData(String data) {
		this.data = data;
		return this;
	}
	
	
	
}
