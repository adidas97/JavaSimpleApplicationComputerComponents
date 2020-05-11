
public abstract class ComputerComponent implements IConnector {
        private Manufacturer manufacturer;
        private double price;
        private int warranty;
        private String serieNumber;
        
        public ComputerComponent (Manufacturer manufacturer, double price, int warranty, String serieNumber) {
        	this.manufacturer = manufacturer;
        	this.price = price;
        	this.warranty = warranty;
        	this.serieNumber = serieNumber;
        }
        
        public Manufacturer getManufacturer() {
        	return this.manufacturer;
        }
        
        public double getPrice() {
        	return this.price;
        }
        
        public int getWarranty() {
        	return this.warranty;
        }
        
        public String getSerieNumber() {
        	return this.serieNumber;
        }
        
        public void connectWithComputer() {
        	
        }
}
