import java.util.ArrayList;
import java.util.Scanner;

public class AcousticDrumkit extends Acoustic {
	private String deco;
	private boolean isMounted = false;

	public AcousticDrumkit(int id, float price, String brand, String model, boolean stock, float diameter,
			String material, String sound, String deco, boolean isMounted) {
		super(id, price, brand, model, stock, diameter, material, sound);
		this.deco = deco;
		this.isMounted = isMounted;
	}

	public AcousticDrumkit() {
	}

	ArrayList<Acoustic> AcDrumkit = new ArrayList<Acoustic>();

	public String getDeco() {
		return deco;
	}

	public void setDeco(String deco) {
		this.deco = deco;
	}

	public boolean isMounted() {
		return isMounted;
	}

	public void setMounted(boolean isMounted) {
		this.isMounted = isMounted;
	}

	public String toString() {
		return "\nType : Acoustic DrumKit\n" + super.toString() + "\nDecoration : " + deco + "\nMounted ?" + isMounted
				+ "\n";
	}

	public AcousticDrumkit buy() {
		Scanner scanner = new Scanner(System.in);
		boolean stock;
		System.out.println("The Acoustic Drumkit' caracteristics :");
		System.out.println("ID : ");
		int id = scanner.nextInt();
		System.out.println("Brand : ");
		String brand = scanner.next();
		System.out.println("Model : ");
		String model = scanner.next();
		System.out.println("Decoration : ");
		String deco = scanner.next();
		System.out.println("Prix : ");
		Float price = scanner.nextFloat();
		System.out.println("Display in the shop ? (1 if yes) : ");
		int stocki = scanner.nextInt();
		if (stocki == 1) {
			stock = false;
		} else {
			stock = true;
		}
		AcousticDrumkit acDrumkit = new AcousticDrumkit(id, price, brand, model, stock, 0, "", sound, deco, isMounted);
		return acDrumkit;
	}
}
