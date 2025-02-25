
public class Spieler {
	private String name;
	private int punkte;

	public Spieler(String name) {
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public void addPunkte(int i) {
		// TODO Auto-generated method stub
		punkte += i;
	}

	public int getPunkte() {
		// TODO Auto-generated method stub
		return punkte;
	}

}
