import java.util.Date;
import java.util.Scanner;

public class Violin extends Stringed implements Tunable {
	private String bowWood;

	public Violin(int id, float price, String brand, String model, boolean stock, int stringNum, String woodType,
			Date tuneDate, String bowWood) {
		super(id, price, brand, model, stock, stringNum, woodType, tuneDate);
		this.bowWood = bowWood;
	}

	public String getBowWood() {
		return bowWood;
	}

	public void setBowWood(String bowWood) {
		this.bowWood = bowWood;
	}

	public Violin() {

	}

	public String toString() {
		return "Type : Violin\n" + super.toString() + "\nBow Wood : " + this.getBowWood();
	}

	public Violin buy() {
		Scanner scanner = new Scanner(System.in);
		boolean stock;
		System.out.println("The Violin's caracteristics :");
		System.out.println("ID : ");
		int id = scanner.nextInt();
		System.out.println("Brand : ");
		String brand = scanner.next();
		System.out.println("Model : ");
		String model = scanner.next();
		System.out.println("Number of strings : ");
		int stringNum = scanner.nextInt();
		System.out.println("Wood type : ");
		String woodType = scanner.next();
		System.out.println("Bow wood type : ");
		String bowWood = scanner.next();
		System.out.println("Price : ");
		Float price = scanner.nextFloat();
		System.out.println("Display in the shop ? (1 if yes) : ");
		int stocki = scanner.nextInt();
		if (stocki == 1) {
			stock = false;
		} else {
			stock = true;
		}
		Violin violin = new Violin(id, price, brand, model, stock, stringNum, woodType, getTuneDate(), bowWood);
		return violin;
	}
}
