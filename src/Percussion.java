
public abstract class Percussion extends Instrument {
	private float diameter;
	private String material;
	protected String sound;

	public Percussion(int id, float price, String brand, String model, boolean stock, float diameter, String material,
			String sound) {
		super(id, price, brand, model, stock);
		this.diameter = diameter;
		this.material = material;
		this.sound = sound;
	}

	public Percussion() {
	}

	public float getDiameter() {
		return diameter;
	}

	public String getMaterial() {
		return material;
	}

	public String getSound() {
		return sound;
	}

	protected void demo() {
		System.out.println(this.getSound());
	}
}
