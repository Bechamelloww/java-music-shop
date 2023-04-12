import java.util.Date;

public abstract class Stringed extends Instrument implements Tunable {
	private int stringNum;
	private String woodType;
	private Date tuneDate;

	public Stringed(int id, float price, String brand, String model, boolean stock, int stringNum, String woodType,
			Date tuneDate) {
		super(id, price, brand, model, stock);
		this.stringNum = stringNum;
		this.woodType = woodType;
		this.tuneDate = tuneDate;
	}

	public Stringed() {
	}

	public Date getTuneDate() {
		return tuneDate;
	}

	protected void setTuneDate(Date tuneDate) {
		this.tuneDate = tuneDate;
	}

	public int getStringNum() {
		return stringNum;
	}

	public String getWoodType() {
		return woodType;
	}

	public void tune() {
		if (this.tuneDate != null) {
			System.out.println("Tuning already done.");
		} else {
			this.setTuneDate(tuneDate = new Date());
			System.out.println("Tuning finished.");
		}
	}

	public String toString() {
		return super.toString() + "\nNumber of strings : " + this.getStringNum() + "\nLast tune date : "
				+ this.getTuneDate();
	}
}
