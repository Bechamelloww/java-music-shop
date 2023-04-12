import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Instrument> Stock = new ArrayList<Instrument>();
		Scanner scanner = new Scanner(System.in);
		showMenuP();
		int menup = scanner.nextInt();
		while (menup != 10) {
			if (menup == 1) {
				for (int i = 0; i < Stock.size(); i++) {
					showStock(Stock, i);
				}
			}
			if (menup == 2) {
				System.out.println("ID of the instrument you're looking for : ");
				int gotid = scanner.nextInt(); // id utilisateur
				for (int i = 0; i < Stock.size(); i++) {
					if (Stock.get(i).getId() == gotid) {
						System.out.println(Stock.get(i).toString() + "\n");
						if (Stock.get(i) instanceof ElectronicDrumkit) {
							ElectronicDrumkit eldrums = (ElectronicDrumkit) Stock.get(i);
							if (eldrums.ElDrumkit.size() != 0) {
								System.out.println("Composed with : ");
								for (int e = 0; e < eldrums.ElDrumkit.size(); e++) {
									showElDrums(eldrums.ElDrumkit, e);
								}
							}
						}
						if (Stock.get(i) instanceof AcousticDrumkit) {
							AcousticDrumkit acdrums = (AcousticDrumkit) Stock.get(i);
							if (acdrums.AcDrumkit.size() != 0) {
								System.out.println("Composed with : ");
								for (int e = 0; e < acdrums.AcDrumkit.size(); e++) {
									showAcDrums(acdrums.AcDrumkit, e);
								}
							}
						}
						break;
					} else if (i + 1 == Stock.size()) {
						System.out.println("\nNo instrument defined with ID " + gotid + ".\n");
					}
				}
			}
			if (menup == 3) {
				showMenuAdd1();
				int category = scanner.nextInt();
				while (category != 4) { // choix du type
					if (category == 1) // Si Stringed
					{
						showMenuAdd21();
						int instru1 = scanner.nextInt();
						while (instru1 != 3) {
							if (instru1 == 1) { // Si ElectricGuitar
								ElectricGuitar electricGuitar = new ElectricGuitar().buy();
								Stock.add(electricGuitar);
								System.out.println(electricGuitar.toString());
							}
							if (instru1 == 2) { // Si Violin
								Violin violin = new Violin().buy();
								Stock.add(violin);
								System.out.println(violin.toString());
							}
							showMenuAdd21();
							instru1 = scanner.nextInt();
						}
						break;
					}
					if (category == 2) // Si Keyboard
					{
						showMenuAdd22();
						int instru2 = scanner.nextInt();
						while (instru2 != 3) {
							if (instru2 == 1) { // si Piano
								Piano piano = new Piano().buy();
								Stock.add(piano);
								System.out.println(piano.toString());
							}
							if (instru2 == 2) { // si Arranger
								Arranger arranger = new Arranger().buy();
								Stock.add(arranger);
								System.out.println(arranger.toString());
							}
							showMenuAdd22();
							instru2 = scanner.nextInt();
						}
						break;
					}
					if (category == 3) // Si Percussion
					{
						showMenuAdd23();
						int percu = scanner.nextInt();
						while (percu != 3) {
							if (percu == 1) { // Acoustic
								showMenuAdd231();
								int instru3 = scanner.nextInt();
								while (instru3 != 5) {
									if (instru3 == 1) {
										BassDrumPad bassDrumPad = new BassDrumPad().buy();
										Stock.add(bassDrumPad);
										System.out.println(bassDrumPad.toString());
									}
									if (instru3 == 2) {
										CymbalPad cymbalPad = new CymbalPad().buy();
										Stock.add(cymbalPad);
										System.out.println(cymbalPad.toString());
									}
									if (instru3 == 3) {
										TomPad tomPad = new TomPad().buy();
										Stock.add(tomPad);
										System.out.println(tomPad.toString());
									}
									if (instru3 == 4) {
										ElectronicDrumkit elDrums = new ElectronicDrumkit().buy();
										Stock.add(elDrums);
										System.out.println(elDrums.toString());
									}
									showMenuAdd231();
									instru3 = scanner.nextInt();
								}
							}
							if (percu == 2) { // Electronic
								showMenuAdd232();
								int instru4 = scanner.nextInt();
								while (instru4 != 7) {
									if (instru4 == 1) {
										Cymbal cymbal = new Cymbal().buy();
										Stock.add(cymbal);
										System.out.println(cymbal.toString());
									}
									if (instru4 == 2) {
										BassDrum bassDrum = new BassDrum().buy();
										Stock.add(bassDrum);
										System.out.println(bassDrum.toString());
									}
									if (instru4 == 3) {
										Tom tom = new Tom().buy();
										Stock.add(tom);
										System.out.println(tom.toString());
									}
									if (instru4 == 4) {
										Charleston charley = new Charleston().buy();
										Stock.add(charley);
										System.out.println(charley.toString());
									}
									if (instru4 == 5) {
										Snare snare = new Snare().buy();
										Stock.add(snare);
										System.out.println(snare.toString());
									}
									if (instru4 == 6) {
										AcousticDrumkit acDrums = new AcousticDrumkit().buy();
										Stock.add(acDrums);
										System.out.println(acDrums.toString());
									}
									showMenuAdd232();
									instru4 = scanner.nextInt();
								}
							}
							showMenuAdd23();
							percu = scanner.nextInt();
						}
						break;
					}
				}
				showMenuAdd1();
				category = scanner.nextInt();
			}
			if (menup == 4) { // Modify
				int number;
				System.out.println("\nID of the instrument to edit : ");
				int gotid = scanner.nextInt(); // id utilisateur
				for (int i = 0; i < Stock.size(); i++) {
					if (Stock.get(i).getId() == gotid) {
						if (Stock.get(i) instanceof ElectricGuitar) { // tune, setmic et settunetype et setstock
							number = i;
							ElectricGuitar electricGuitar = (ElectricGuitar) Stock.get(i);
							modElectricGui();
							int mod = scanner.nextInt();
							while (mod != 5) {
								if (mod == 1) {
									System.out.println("Display in the shop ? (1 if yes) : ");
									int stocki = scanner.nextInt();
									if (stocki == 1) {
										electricGuitar.setStock(false);
									} else {
										electricGuitar.setStock(true);
									}
								}
								if (mod == 2) {
									System.out.println("Microphone : ");
									String mic = scanner.next();
									electricGuitar.setMic(mic);
								}
								if (mod == 3) {
									System.out.println("Tune type : ");
									String tuneType = scanner.next();
									electricGuitar.setTuneType(tuneType);
								}
								if (mod == 4) {
									electricGuitar.tune();
								}
								Stock.set(number, electricGuitar);
								modElectricGui();
								mod = scanner.nextInt();
							}
							break;
						}
						if (Stock.get(i) instanceof Violin) { // tune, set bowwood et setstock
							number = i;
							Violin violin = (Violin) Stock.get(i);
							modViolin();
							int mod = scanner.nextInt();
							while (mod != 4) {
								if (mod == 1) {
									System.out.println("Display in the shop ? (1 if yes) : ");
									int stocki = scanner.nextInt();
									if (stocki == 1) {
										violin.setStock(false);
									} else {
										violin.setStock(true);
									}
								}
								if (mod == 2) {
									System.out.println("Bow's wood type : ");
									String bowWood = scanner.next();
									violin.setBowWood(bowWood);
								}
								if (mod == 3) {
									violin.tune();
								}
								Stock.set(number, violin);
								modViolin();
								mod = scanner.nextInt();
							}
							break;
						}
						if (Stock.get(i) instanceof ElectronicDrumkit) { // connect, mount, setstock
							number = i;
							ElectronicDrumkit eldrumkit = (ElectronicDrumkit) Stock.get(i);
							modElDrumkit();
							int mod = scanner.nextInt();
							while (mod != 4) {
								if (mod == 1) {
									System.out.println("Display in the shop ? (1 if yes) : ");
									int stocki = scanner.nextInt();
									if (stocki == 1) {
										eldrumkit.setStock(false);
									} else {
										eldrumkit.setStock(true);
									}
								}
								if (mod == 2) {
									if (eldrumkit.isConnected() == true) {
										eldrumkit.setConnected(false);
										System.out.println("Disconnected successfully !");
									} else {
										eldrumkit.setConnected(true);
										System.out.println("Connected successfully !");
									}
								}
								if (mod == 3) {
									if (eldrumkit.isMounted() == true) {
										eldrumkit.setMounted(false);
										System.out.println("Dismounted successfully !");
									} else {
										eldrumkit.setMounted(true);
										System.out.println("Mounted successfully !");
									}
								}
								Stock.set(number, eldrumkit);
								modElDrumkit();
								mod = scanner.nextInt();
							}
							break;
						}
						if (Stock.get(i) instanceof AcousticDrumkit) { // connect, mount, setstock
							number = i;
							AcousticDrumkit acdrumkit = (AcousticDrumkit) Stock.get(i);
							modAcDrumkit();
							int mod = scanner.nextInt();
							while (mod != 4) {
								if (mod == 1) {
									System.out.println("Display in the shop ? (1 if yes) : ");
									int stocki = scanner.nextInt();
									if (stocki == 1) {
										acdrumkit.setStock(false);
									} else {
										acdrumkit.setStock(true);
									}
								}
								if (mod == 2) {
									System.out.println("New decoration message : ");
									String stocki = scanner.next();
									acdrumkit.setDeco(stocki);
								}
								if (mod == 3) {
									if (acdrumkit.isMounted() == true) {
										acdrumkit.setMounted(false);
										System.out.println("Dismounted successfully !");
									} else {
										acdrumkit.setMounted(true);
										System.out.println("Mounted successfully !");
									}
								}
								Stock.set(number, acdrumkit);
								modAcDrumkit();
								mod = scanner.nextInt();
							}
							break;
						}

						if (Stock.get(i) instanceof Piano) { // sethammertype et setstock
							number = i;
							Piano piano = (Piano) Stock.get(i);
							modPiano();
							int mod = scanner.nextInt();
							while (mod != 3) {
								if (mod == 1) {
									System.out.println("Display in the shop ? (1 if yes) : ");
									int stocki = scanner.nextInt();
									if (stocki == 1) {
										piano.setStock(false);
									} else {
										piano.setStock(true);
									}
								}
								if (mod == 2) {
									System.out.println("Hammers type : ");
									String hammerType = scanner.next();
									piano.setHammerType(hammerType);
								}
								Stock.set(number, piano);
								modPiano();
								mod = scanner.nextInt();
							}
							break;
						} else { // changer l'état en stock ou non
							number = i;
							System.out.println("\n1 Edit stock");
							System.out.println("2 Quit");
							int mod = scanner.nextInt();
							while (mod != 2) {
								if (mod == 1) {
									System.out.println("Display in the shop ? (1 if yes) : ");
									int stocki = scanner.nextInt();
									if (stocki == 1) {
										Stock.get(i).setStock(false);
									} else {
										Stock.get(i).setStock(true);
									}
								}
								Stock.set(number, Stock.get(number));
								System.out.println("\n1 Edit stock");
								System.out.println("2 Quit");
								mod = scanner.nextInt();
							}
						}
						break;
					} else {
						System.out.println("No instruments defined with ID " + gotid + "\n");
						break;
					}
				}
			}
			if (menup == 5) { // Vendre instrument
				System.out.println("\nID of the instrument to sell : ");
				int gotid = scanner.nextInt(); // id utilisateur
				for (int i = 0; i < Stock.size(); i++) {
					if (Stock.get(i).getId() == gotid) {
						Stock.remove(i);
						System.out.println("\nInstrument with ID " + gotid + " has been sold.\n");
						break;
					} else {
						System.out.println("No instruments defined with ID " + gotid + "\n");
						break;
					}
				}
			}
			if (menup == 6) { // assembler batterie
				System.out.println("\n1 Add percussions to an Electronic Drumkit");
				System.out.println("2 Add percussions to an Acoustic Drumkit");
				System.out.println("3 Quit");
				int got = scanner.nextInt(); // id utilisateur
				while (got != 3) {

					if (got == 1) {
						System.out.println("\nID of the Electronic drumkit to modify : (0 to escape)");
						int gotid = scanner.nextInt(); // id utilisateur
						while (gotid != 0) {
							for (int i = 0; i < Stock.size(); i++) {
								if (Stock.get(i).getId() == gotid && Stock.get(i) instanceof ElectronicDrumkit) {
									ElectronicDrumkit eldrums = (ElectronicDrumkit) Stock.get(i);
									System.out.println("\nID of the Electronic percussion to add (0 = STOP) : ");
									int gotid3 = scanner.nextInt(); // id utilisateur
									while (gotid3 != 0) {
										for (int j = 0; j < Stock.size(); j++) {
											if (Stock.get(j).getId() == gotid3 && Stock.get(j) instanceof Electronic
													&& !(Stock.get(j) instanceof ElectronicDrumkit)) {
												eldrums.ElDrumkit.add((Electronic) Stock.get(j));
												Stock.remove(j);
												System.out.println("\nInstrument with ID " + gotid3
														+ " has been added to the Drums.\n");
												break;
											} else if (i + 1 == Stock.size()) {
												System.out.println("No instruments defined with ID " + gotid3 + "\n");
												break;
											}
										}
										System.out.println("\nID of the Electronic percussion to add (0 = STOP) : ");
										gotid3 = scanner.nextInt(); // id utilisateur
									}
									break;
								} else if (i + 1 == Stock.size()) {
									System.out.println("No instruments defined with ID " + gotid + "\n");
									break;
								}
							}
							System.out.println("\nID of the Electronic drumkit to modify : (0 to escape)");
							gotid = scanner.nextInt(); // id utilisateur
						}
						break;
					}

					if (got == 2) {
						System.out.println("\nID of the Acoustic drumkit to modify : (0 to escape)");
						int gotid = scanner.nextInt(); // id utilisateur
						while (gotid != 0) {
							for (int i = 0; i < Stock.size(); i++) {
								if (Stock.get(i).getId() == gotid && Stock.get(i) instanceof AcousticDrumkit) {
									AcousticDrumkit acdrums = (AcousticDrumkit) Stock.get(i);
									System.out.println("\nID of the Acoustic percussion to add (0 = STOP) : ");
									int gotid3 = scanner.nextInt(); // id utilisateur
									while (gotid3 != 0) {
										for (int j = 0; j < Stock.size(); j++) {
											if (Stock.get(j).getId() == gotid3 && Stock.get(j) instanceof Acoustic
													&& !(Stock.get(j) instanceof AcousticDrumkit)) {
												acdrums.AcDrumkit.add((Acoustic) Stock.get(j));
												Stock.remove(j);
												System.out.println("\nInstrument with ID " + gotid3
														+ " has been added to the Drums.\n");
												break;
											} else if (j + 1 == Stock.size()) {
												System.out.println("No instruments defined with ID " + gotid3 + "\n");
												break;
											}
										}
										System.out.println("\nID of the Acoustic percussion to add (0 = STOP) : ");
										gotid3 = scanner.nextInt(); // id utilisateur
									}
									break;
								} else if (i + 1 == Stock.size()) {
									System.out.println("No instruments defined with ID " + gotid + "\n");
									break;
								}
							}
							System.out.println("\nID of the Acoustic drumkit to modify : (0 to escape)");
							gotid = scanner.nextInt(); // id utilisateur
						}
						break;
					}
				}
				System.out.println("\n1 Add percussions to an Electronic Drumkit");
				System.out.println("2 Add percussions to an Acoustic Drumkit");
				System.out.println("3 Quit");
				got = scanner.nextInt(); // id utilisateur
			}

			if (menup == 7) { // supprimer tout le stock (bruler le magasin)
				Stock.clear();
				System.out.println("\nThe shop is burning !!! Everything has burnt...\n");
			}

			if (menup == 8) { // drums demo
				System.out.println("ID of the Drumkit you want a demo from : (0 to escape)");
				int ide = scanner.nextInt();
				while (ide != 0) {
					for (int i = 0; i < Stock.size(); i++) {
						if (Stock.get(i).getId() == ide && Stock.get(i) instanceof AcousticDrumkit) {
							AcousticDrumkit acdrums = (AcousticDrumkit) Stock.get(i);
							if (acdrums.isMounted() == true) {
								demoAc(acdrums.AcDrumkit);
							} else {
								System.out.println("Please mount your Acoustic Drumkit to play.");
							}
							break;
						}
						if (Stock.get(i).getId() == ide && Stock.get(i) instanceof ElectronicDrumkit) {
							ElectronicDrumkit eldrums = (ElectronicDrumkit) Stock.get(i);
							if (eldrums.isMounted() == true && eldrums.isConnected() == true) {
								demoEl(eldrums.ElDrumkit);
							} else {
								System.out.println("Please mount and connect you Electronic Drumkit to play.");
							}
							break;
						} else {
							System.out.println("No Drumkit found for the given ID.");
							break;
						}
					}
					break;
				}
				System.out.println();
			}
			if (menup == 9) { // remove element from drums
				System.out.println("\n1 Remove percussions to an Electronic Drumkit");
				System.out.println("2 Remove percussions to an Acoustic Drumkit");
				System.out.println("3 Quit");
				int got = scanner.nextInt(); // id utilisateur
				while (got != 3) {

					if (got == 1) {
						System.out.println("\nID of the Electronic drumkit to modify : (0 to escape)");
						int gotid = scanner.nextInt(); // id utilisateur
						while (gotid != 0) {
							for (int i = 0; i < Stock.size(); i++) {
								if (Stock.get(i).getId() == gotid && Stock.get(i) instanceof ElectronicDrumkit) {
									ElectronicDrumkit eldrums = (ElectronicDrumkit) Stock.get(i);
									System.out.println("\nID of the Electronic percussion to remove (0 = STOP) : ");
									int gotid3 = scanner.nextInt(); // id utilisateur
									while (gotid3 != 0) {
										for (int j = 0; j < Stock.size(); j++) {
											if (eldrums.ElDrumkit.get(j).getId() == gotid3
													&& eldrums.ElDrumkit.get(j) instanceof Electronic) {
												Stock.add(eldrums.ElDrumkit.get(j));
												eldrums.ElDrumkit.remove((Electronic) eldrums.ElDrumkit.get(j));
												System.out.println("\nInstrument with ID " + gotid3
														+ " has been removed from the Drums.\n");
												break;
											} else if (j + 1 == Stock.size()) {
												System.out.println("No instruments defined with ID " + gotid3 + "\n");
												break;
											}
										}
										System.out.println("\nID of the Electronic percussion to remove (0 = STOP) : ");
										gotid3 = scanner.nextInt(); // id utilisateur
									}
									break;
								} else if (i + 1 == Stock.size()) {
									System.out.println("No Drumkit defined with ID " + gotid + "\n");
									break;
								}
							}
							System.out.println("\nID of the Acoustic drumkit to modify : (0 to escape)");
							gotid = scanner.nextInt(); // id utilisateur
						}
						break;
					}

					if (got == 2) {
						System.out.println("\nID of the Acoustic drumkit to modify : (0 to escape)");
						int gotid = scanner.nextInt(); // id utilisateur
						while (gotid != 0) {
							for (int i = 0; i < Stock.size(); i++) {
								if (Stock.get(i).getId() == gotid && Stock.get(i) instanceof AcousticDrumkit) {
									AcousticDrumkit acdrums = (AcousticDrumkit) Stock.get(i);
									System.out.println("\nID of the Acoustic percussion to remove (0 = STOP) : ");
									int gotid3 = scanner.nextInt(); // id utilisateur
									while (gotid3 != 0) {
										for (int j = 0; j < Stock.size(); j++) {
											if (acdrums.AcDrumkit.get(j).getId() == gotid3
													&& acdrums.AcDrumkit.get(j) instanceof Acoustic) {
												Stock.add(acdrums.AcDrumkit.get(j));
												acdrums.AcDrumkit.remove((Acoustic) acdrums.AcDrumkit.get(j));
												System.out.println("\nInstrument with ID " + gotid3
														+ " has been removed from the Drums.\n");
												break;
											} else if (j + 1 == Stock.size()) {
												System.out.println("No instruments defined with ID " + gotid3 + "\n");
												break;
											}
										}
										System.out.println("\nID of the Acoustic percussion to remove (0 = STOP) : ");
										gotid3 = scanner.nextInt(); // id utilisateur
									}
									break;
								} else if (i + 1 == Stock.size()) {
									System.out.println("No Drumkit defined with ID " + gotid + "\n");
									break;
								}
							}
							System.out.println("\nID of the Acoustic drumkit to modify : (0 to escape)");
							gotid = scanner.nextInt(); // id utilisateur
						}
						break;
					}
				}
				System.out.println("\n1 Add percussions to an Electronic Drumkit");
				System.out.println("2 Add percussions to an Acoustic Drumkit");
				System.out.println("3 Quit");
				got = scanner.nextInt(); // id utilisateur
			}

			showMenuP();
			menup = scanner.nextInt();
		}
		scanner.close();
	}

	private static void showMenuP() {
		System.out.println("1 Look at the stock");
		System.out.println("2 Look for an instrument");
		System.out.println("3 Buy an instrument");
		System.out.println("4 Modify an instrument");
		System.out.println("5 Sell an instrument");
		System.out.println("6 Add percussions to a Drumkit");
		System.out.println("7 Set the shop on fire");
		System.out.println("8 Drums Concerto");
		System.out.println("9 Remove Percussion from a Drumkit");
		System.out.println("10 Quit");
	}

	private static void showMenuAdd1() {
		System.out.println("\n1 Stringed");
		System.out.println("2 Keyboard");
		System.out.println("3 Percussion");
		System.out.println("4 Back to Home menu");
	}

	private static void showMenuAdd21() {
		System.out.println("\n1 Electric Guitar");
		System.out.println("2 Violin");
		System.out.println("3 Back");
	}

	private static void showMenuAdd22() {
		System.out.println("\n1 Piano");
		System.out.println("2 Arranger");
		System.out.println("3 Back");
	}

	private static void showMenuAdd23() {
		System.out.println("\n1 Electronic");
		System.out.println("2 Acoustic");
		System.out.println("3 Back");
	}

	private static void showMenuAdd231() {
		System.out.println("\n1 Bass Drum Pad");
		System.out.println("2 Cymbal Pad");
		System.out.println("3 Tom Pad");
		System.out.println("4 Electronic Drumkit");
		System.out.println("5 Back");
	}

	private static void showMenuAdd232() {
		System.out.println("\n1 Cymbal");
		System.out.println("2 Drum Bass");
		System.out.println("3 Tom");
		System.out.println("4 Charleston");
		System.out.println("5 Snare");
		System.out.println("6 Acoustic Drumkit");
		System.out.println("7 Back");
	}

	private static void modElectricGui() {
		System.out.println("\n1 Edit stock");
		System.out.println("2 Change Microphone");
		System.out.println("3 Modify tune type");
		System.out.println("4 Tune");
		System.out.println("5 Quit");
	}

	private static void modViolin() {
		System.out.println("\n1 Edit stock");
		System.out.println("2 Change Bow's Wood");
		System.out.println("3 Tune");
		System.out.println("4 Quit");
	}

	private static void modPiano() {
		System.out.println("\n1 Edit stock");
		System.out.println("2 Set Hammers type");
		System.out.println("3 Quit");
	}

	private static void modElDrumkit() {
		System.out.println("\n1 Edit stock");
		System.out.println("2 Connect");
		System.out.println("3 Mount/Unmount");
		System.out.println("4 Quit");
	}

	private static void modAcDrumkit() {
		System.out.println("\n1 Edit stock");
		System.out.println("2 Edit decoration");
		System.out.println("3 Mount/Unmount");
		System.out.println("4 Quit");
	}

	private static void showStock(ArrayList<Instrument> Stock, int i) {
		System.out.println(Stock.get(i).toString() + "\n");
		if (Stock.get(i) instanceof ElectronicDrumkit) {
			ElectronicDrumkit eldrums = (ElectronicDrumkit) Stock.get(i);
			if (eldrums.ElDrumkit.size() != 0) {
				System.out.println("Composed with : ");
				System.out.println("----------------------");
				for (int e = 0; e < eldrums.ElDrumkit.size(); e++) {
					showElDrums(eldrums.ElDrumkit, e);
				}
				System.out.println("----------------------");
			}
		}
		if (Stock.get(i) instanceof AcousticDrumkit) {
			AcousticDrumkit acdrums = (AcousticDrumkit) Stock.get(i);
			if (acdrums.AcDrumkit.size() != 0) {
				System.out.println("Composed with : ");
				System.out.println("----------------------");
				for (int e = 0; e < acdrums.AcDrumkit.size(); e++) {
					showAcDrums(acdrums.AcDrumkit, e);
				}
				System.out.println("----------------------");

			}
		}
	}

	private static void showAcDrums(ArrayList<Acoustic> AcDrums, int i) {
		System.out.println(AcDrums.get(i).toString() + "\n");
	}

	private static void showElDrums(ArrayList<Electronic> ElDrums, int i) {
		System.out.println(ElDrums.get(i).toString() + "\n");
	}

	private static void demoAc(ArrayList<Acoustic> AcDrums) {
		for (int g = 0; g < AcDrums.size(); g++) {
			System.out.println(AcDrums.get(g).getSound());
		}
	}

	private static void demoEl(ArrayList<Electronic> ElDrums) {
		for (int g = 0; g < ElDrums.size(); g++) {
			System.out.println(ElDrums.get(g).getSound());
		}
	}
}
