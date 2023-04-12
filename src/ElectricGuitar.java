import java.util.Date;
import java.util.Scanner;

public class ElectricGuitar extends Stringed implements Tunable {
	private String mic;
	private String tuneType;

	public ElectricGuitar(int id, float price, String brand, String model, boolean stock, int stringNum,
			String woodType, Date tuneDate, String mic, String tuneType) {
		super(id, price, brand, model, stock, stringNum, woodType, tuneDate);
		this.mic = mic;
		this.tuneType = tuneType;
	}

	public String getMic() {
		return mic;
	}

	public void setMic(String mic) {
		this.mic = mic;
	}

	public String getTuneType() {
		return tuneType;
	}

	public void setTuneType(String tuneType) {
		this.tuneType = tuneType;
	}

	public ElectricGuitar() {
	}

	public String toString() {
		return "Type : Electric Guitar\n" + super.toString() + "\nMic : " + this.getMic() + "\nTune Type : "
				+ this.getTuneType();
	}

	public ElectricGuitar buy() {
		Scanner scanner = new Scanner(System.in);
		boolean stock;
		System.out.println("The Electric Guitar's caracteristics :");
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
		System.out.println("Mic : ");
		String mic = scanner.next();
		System.out.println("Tune type : ");
		String tuneType = scanner.next();
		System.out.println("Price : ");
		Float price = scanner.nextFloat();
		System.out.println("Display in the shop ? (1 if yes) : ");
		int stocki = scanner.nextInt();
		if (stocki == 1) {
			stock = false;
		} else {
			stock = true;
		}
		ElectricGuitar electricGuitar = new ElectricGuitar(id, price, brand, model, stock, stringNum, woodType,
				getTuneDate(), mic, tuneType);
		return electricGuitar;
	}
}
