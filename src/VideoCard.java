
public class VideoCard extends ComputerComponent {
	
	private int ram;
	private int bitRate;
	private int id;
	private static int lastAssignedId = 0;
	
	public VideoCard(Manufacturer manufacturer, double price, int warranty, String serieNumber
			, int ram, int bitRate) {
		super(manufacturer,price,warranty,serieNumber);
		this.ram = ram;
		this.bitRate = bitRate;
		this.lastAssignedId++;
		this.id = lastAssignedId;
	}
	
	public int getRam() {
		return this.ram;
	}
	
	public int getBitRate() {
		return this.bitRate;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void ShowGraphic() {
		
	}

}
