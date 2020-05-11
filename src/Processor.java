
public class Processor extends ComputerComponent {
	
	private int numberOfCores;
	private int mhz;
	private int id;
	private static int lastAssignedId = 0;
	
	public Processor(Manufacturer manufacturer, double price, int warranty, String serieNumber,int numberOfCores,
			int mhz) {
		super(manufacturer,price,warranty,serieNumber);
		this.numberOfCores = numberOfCores;
		this.mhz = mhz;
		this.lastAssignedId++;
		this.id = lastAssignedId;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getNumberOfCores() {
		return this.numberOfCores;
	}
	
	public int getMhz() {
		return this.mhz;
	}
	
	
	public void ReadFiles() {
		
	}

}
