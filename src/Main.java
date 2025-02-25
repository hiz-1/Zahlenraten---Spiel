import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int auswahl;
		Spiel spiel = new Spiel();
		String name1, name2;
		Spieler spieler1 = null, spieler2 = null;
		// the Menu stuff
		do {
			auswahl = printMenu();

			switch (auswahl) {
			case 1:
				System.out.println("Geben Sie den Namen des Spielers ein :");
				name1 = sc.nextLine();
				spieler1 = new Spieler(name1);
				name2 = "Bot";
				spieler2 = new Spieler(name2);
				// bot zufällig spielt zwischen 0, 1,2,3,4
				break;
			case 2:
				System.out.println("Geben Sie den Namen des ersten Spielers ein:");
				name1 = sc.nextLine();
				spieler1 = new Spieler(name1);
				System.out.println("Geben Sie den Namen des zweiten Spielers ein:");
				name2 = sc.nextLine();
				spieler2 = new Spieler(name2);
				break;
			case 3:
				System.out.println("Programm beendet");
				break;
			}
		} while (auswahl != 1 && auswahl != 2 && auswahl != 3);

		// The spiel ablauf
		Spieler aktSpieler = spieler1;
		Spieler otherSpieler = spieler2;
		int i = 1;
		do {
			System.out.println("Runde " + i + " :");
			spiel.initialize();
			spiel.zug(aktSpieler);
			if (otherSpieler.getName().equals("Bot")) {
				spiel.zugBOT(otherSpieler);
			} else {
				spiel.zug(otherSpieler);
			}
			System.out.println("Die naechste Zahl war :  " + spiel.getRandomZahl());
			spiel.printPunkteStand(aktSpieler, otherSpieler);
			i++;
			// change spieler each rounddd
			if (aktSpieler == spieler1) {
				aktSpieler = spieler2;
				otherSpieler = spieler1;
			} else {
				aktSpieler = spieler1;
				otherSpieler = spieler2;
			}
		} while (!spiel.win(spieler1, spieler2));

	}

	private static int printMenu() {
		Scanner sc = new Scanner(System.in);
		int auswahl;
		// TODO Auto-generated method stub
		System.out.println("Zahlen raten");
		System.out.println("1- Ein Spieler");
		System.out.println("2- Zwei Spieler");
		System.out.println("3- Programm beenden! ");
		auswahl = sc.nextInt();
		sc.nextLine();
		return auswahl;
	}

}
