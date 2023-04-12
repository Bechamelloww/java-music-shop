import java.util.Scanner;

public class BassDrum extends Acoustic {

	public BassDrum(int id, float price, String brand, String model, boolean stock, float diameter, String material,
			String sound) {
		super(id, price, brand, model, stock, diameter, material, sound);
	}

	public BassDrum() {
	}

	public String toString() {
		return "Type : Bass Drum\n" + super.toString();
	}

	public BassDrum buy() {
		Scanner scanner = new Scanner(System.in);
		boolean stock;
		System.out.println("The Bass Drum's caracteristics :");
		System.out.println("ID : ");
		int id = scanner.nextInt();
		System.out.println("Brand : ");
		String brand = scanner.next();
		System.out.println("Model : ");
		String model = scanner.next();
		System.out.println("Diameter : ");
		float diameter = scanner.nextFloat();
		System.out.println("Material : ");
		String material = scanner.next();
		String sound = "Poum";
		System.out.println("Prix : ");
		Float price = scanner.nextFloat();
		System.out.println("Display in the shop ? (1 if yes) : ");
		int stocki = scanner.nextInt();
		if (stocki == 1) {
			stock = false;
		} else {
			stock = true;
		}
		BassDrum bassDrum = new BassDrum(id, price, brand, model, stock, diameter, material, sound);
		return bassDrum;
	}
}
