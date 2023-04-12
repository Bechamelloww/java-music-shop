import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ElectronicDrumkit extends Electronic {
	private boolean isMounted = false;
	private boolean isConnected = false;

	public ElectronicDrumkit(int id, float price, String brand, String model, boolean stock, float diameter,
			String material, String sound, boolean state, boolean isConnected) {
		super(id, price, brand, model, stock, diameter, material, sound);
		this.isMounted = state;
		this.isConnected = isConnected;
	}

	public ElectronicDrumkit() {
	}

	public boolean isMounted() {
		return isMounted;
	}

	public void setMounted(boolean isMounted) {
		this.isMounted = isMounted;
	}

	public boolean isConnected() {
		return isConnected;
	}

	public void setConnected(boolean isConnected) {
		this.isConnected = isConnected;
	}

	public ArrayList<Electronic> getElDrumkit() {
		return ElDrumkit;
	}

	public String toString() {
		return "\nType : Electronic DrumKit\n" + super.toString() + "\nConnected ? : " + isConnected + "\nMounted ?"
				+ isMounted + "\n";
	}

	ArrayList<Electronic> ElDrumkit = new ArrayList<Electronic>();

	public ElectronicDrumkit buy() {
		Scanner scanner = new Scanner(System.in);
		boolean stock;
		System.out.println("The Electronic Drumkit' caracteristics :");
		System.out.println("ID : ");
		int id = scanner.nextInt();
		System.out.println("Brand : ");
		String brand = scanner.next();
		System.out.println("Model : ");
		String model = scanner.next();
		System.out.println("Prix : ");
		Float price = scanner.nextFloat();
		System.out.println("Display in the shop ? (1 if yes) : ");
		int stocki = scanner.nextInt();
		if (stocki == 1) {
			stock = false;
		} else {
			stock = true;
		}
		ElectronicDrumkit elDrumkit = new ElectronicDrumkit(id, price, brand, model, stock, 0, "", sound, isMounted,
				isConnected);
		return elDrumkit;
	}
}
