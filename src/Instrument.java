
public abstract class Instrument {
	private int id;
	private float price;
	private String brand;
	private String model;
	private boolean stock = false;

	public Instrument(int id, float price, String brand, String model, boolean stock) {
		this.id = id;
		this.price = price;
		this.brand = brand;
		this.model = model;
		this.stock = stock;
	}

	public Instrument() {

	}

	public int getId() {
		return id;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public boolean isStock() {
		return stock;
	}

	public void setStock(boolean stock) {
		this.stock = stock;
	}

	public String toString() {
		return "ID : " + this.getId() + "\nPrice : " + this.getPrice() + "€\nBrand : " + this.getBrand() + "\nModel : "
				+ this.getModel() + "\nIn Stock : " + this.isStock();
	}
}
