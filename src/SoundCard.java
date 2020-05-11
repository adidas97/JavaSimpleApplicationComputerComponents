
public class SoundCard extends ComputerComponent {
	
	private int db;
	private int id;
	private static int lastAssignedId = 0;
	
	public SoundCard(Manufacturer manufacturer, double price, int warranty, String serieNumber, int db) {
		super(manufacturer,price,warranty,serieNumber);
		this.db = db;
		this.lastAssignedId++;
		this.id = lastAssignedId;
	}
	
	public int getDb() {
		return this.db;
	}
	
	public int getId() {
		return this.id;
	}

}
