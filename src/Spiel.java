import java.util.Random;
import java.util.Scanner;

public class Spiel {

	public int max, min;
	private int randomZahl;

	public boolean win(Spieler sp1, Spieler sp2) {

		if (sp1.getPunkte() >= 5) {
			System.out.println("Winner is " + sp1.getName());
			return true;
		} else if (sp2.getPunkte() >= 5) {
			System.out.println("Winner is " + sp2.getName());
			return true;
		}
		return false;

	}

	public int getRandomZahl() {
		return this.randomZahl;
	}

	public void zug(Spieler currSpieler) {

		System.out.println("Die Zahlen sind " + min + " und " + max);

		System.out.println(currSpieler.getName() + " ist an der Reihe: ");

		int auswahl = printGameMenu();
		gameChoice(currSpieler, auswahl);

	}

	private void gameChoice(Spieler currSpieler, int auswahl) {
		switch (auswahl) {
		case 0:
			if (randomZahl < min) {
				currSpieler.addPunkte(1);
			}
			break;
		case 1:
			if (randomZahl == min) {
				currSpieler.addPunkte(3);
			}
			break;
		case 2:
			if (randomZahl > min && randomZahl < max) {
				currSpieler.addPunkte(1);
			}
			break;

		case 3:
			if (randomZahl == max) {
				currSpieler.addPunkte(3);
			}
			break;
		case 4:
			if (randomZahl > max) {
				currSpieler.addPunkte(1);
			}
			break;
		}
	}

	public int gameNumberRandomize() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int randZahl = rand.nextInt(101);
		System.out.println(randZahl);
		return randZahl;
	}

	private int printGameMenu() {
		Scanner sc = new Scanner(System.in);
		int auswahl;
		do {
			System.out.println("Wählen Sie aus. Die naechste Zahl ist ... ");
			System.out.println("0: kleiner als " + min);
			System.out.println("1: genau " + min);
			System.out.println("2: zwischen " + min + " und " + max);
			System.out.println("3: genau " + max);
			System.out.println("4: größer als " + max);
			auswahl = sc.nextInt();
		} while (auswahl < 0 && auswahl > 4);
		return auswahl;
	}

	public void grenzeRandomize() {
		Random rand = new Random();
		int ersteZahl = rand.nextInt(101);
		int zweiteZahl;
		do {
			zweiteZahl = rand.nextInt(101);
		} while (ersteZahl == zweiteZahl); // darf nicht die gleiche zahl sein
		// Check whos größer als der andere
		if (ersteZahl > zweiteZahl) {
			max = ersteZahl;
			min = zweiteZahl;
		} else {
			min = ersteZahl;
			max = zweiteZahl;
		}

	}

	public void printPunkteStand(Spieler aktSpieler, Spieler otherSpieler) {
		// TODO Auto-generated method stub
		System.out.println(aktSpieler.getName() + ": " + aktSpieler.getPunkte() + " Punkte.");
		System.out.println(otherSpieler.getName() + ": " + otherSpieler.getPunkte() + " Punkte.");
	}

	public void initialize() {
		grenzeRandomize();
		randomZahl = gameNumberRandomize();
	}

	public void zugBOT(Spieler sp) {
		Random r = new Random();
		System.out.println("Computer ist an der Reihe:");
		int wahl = r.nextInt(5);
		System.out.println("Bot wählt " + wahl);
		gameChoice(sp, wahl);
	}

}