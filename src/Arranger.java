import java.util.Scanner;

public class Arranger extends Keyboard {
	private int soundNum;

	public Arranger(int id, float price, String brand, String model, boolean stock, int keyNum, int soundNum) {
		super(id, price, brand, model, stock, keyNum);
		this.soundNum = soundNum;
	}

	public Arranger() {

	}

	public int getSoundNum() {
		return soundNum;
	}

	public String toString() {
		return "Type : Arranger\n" + super.toString() + "\nNumber of sounds : " + this.getSoundNum();
	}

	public Arranger buy() {
		Scanner scanner = new Scanner(System.in);
		boolean stock;
		System.out.println("The Arranger's caracteristics :");
		System.out.println("ID : ");
		int id = scanner.nextInt();
		System.out.println("Brand : ");
		String brand = scanner.next();
		System.out.println("Model : ");
		String model = scanner.next();
		System.out.println("Number of keys : ");
		int keyNum = scanner.nextInt();
		System.out.println("Number of sounds : ");
		int soundNum = scanner.nextInt();
		System.out.println("Prix : ");
		Float price = scanner.nextFloat();
		System.out.println("Display in the shop ? (1 if yes) : ");
		int stocki = scanner.nextInt();
		if (stocki == 1) {
			stock = false;
		} else {
			stock = true;
		}
		Arranger arranger = new Arranger(id, price, brand, model, stock, keyNum, soundNum);
		return arranger;
	}
}
