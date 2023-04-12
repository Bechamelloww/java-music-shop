import java.util.Date;
import java.util.Scanner;

public class Piano extends Keyboard implements Tunable {
	private String hammerType;
	private float tunePrice;

	public Piano() {
	}

	public Piano(int id, float price, String brand, String model, boolean stock, int keyNum, String hammerType,
			float tunePrice) {
		super(id, price, brand, model, stock, keyNum);
		this.hammerType = hammerType;
		this.tunePrice = tunePrice;
	}

	public String getHammerType() {
		return hammerType;
	}

	public void setHammerType(String hammerType) {
		this.hammerType = hammerType;
	}

	public float getTunePrice() {
		return tunePrice;
	}

	public void tune() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Price to tune the piano is 350€. Would you like the shop to do it ? (1 = YES)");
		int usr = scanner.nextInt();
		if (usr == 1) {
			System.out.println("Tuning finished. Its price is " + this.getTunePrice() + ".");
		} else {
			System.out.println("Tuning cancelled");
		}
	}

	public String toString() {
		return "Type : Piano\n" + super.toString() + "\nHammer Type : " + this.getHammerType() + "Tune Price : "
				+ this.getTunePrice();
	}

	public Piano buy() {
		Scanner scanner = new Scanner(System.in);
		boolean stock;
		System.out.println("The Piano's caracteristics :");
		System.out.println("ID : ");
		int id = scanner.nextInt();
		System.out.println("Brand : ");
		String brand = scanner.next();
		System.out.println("Model : ");
		String model = scanner.next();
		System.out.println("Number of keys : ");
		int keyNum = scanner.nextInt();
		System.out.println("Hammers type : ");
		String hammerType = scanner.next();
		System.out.println("Price : ");
		Float price = scanner.nextFloat();
		System.out.println("Tune Price : ");
		Float tunePrice = scanner.nextFloat();
		System.out.println("Display in the shop ? (1 if yes) : ");
		int stocki = scanner.nextInt();
		if (stocki == 1) {
			stock = false;
		} else {
			stock = true;
		}
		Piano piano = new Piano(id, price, brand, model, stock, keyNum, hammerType, tunePrice);
		piano.tune();
		return piano;
	}
}
