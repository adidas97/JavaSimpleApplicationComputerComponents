
public class SSD extends ComputerComponent {
	
	private int capacity;
	private int id;
	private static int lastAssignedId = 0;
	
	public SSD(Manufacturer manufacturer, double price, int warranty, String serieNumber, int capacity) {
		super(manufacturer,price,warranty,serieNumber);
		this.capacity = capacity;
		this.lastAssignedId++;
		this.id = lastAssignedId;
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public int getId() {
		return this.id;
	}

}
