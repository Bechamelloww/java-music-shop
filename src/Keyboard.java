
public abstract class Keyboard extends Instrument {
	private int keyNum;

	public Keyboard() {
	}

	public Keyboard(int id, float price, String brand, String model, boolean stock, int keyNum) {
		super(id, price, brand, model, stock);
		this.keyNum = keyNum;
	}

	public int getKeyNum() {
		return keyNum;
	}

	public String toString() {
		return super.toString() + "\nNumber of keys : " + this.getKeyNum();
	}

}
