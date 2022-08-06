package durree;

public class Durree {

	private int secondes; 

	public Durree() {
		// Ce constructeur permet d'obtenir une duree de 0 secondes
		secondes = 0;
	}
	
	public Durree(int secondes) {
		// Ce constructeur permet d'obtenir une duree exprimee en secondes
		// secondes doit etre compris entre 0 et 86399
		if(secondes < 0 || secondes > 86399) {
			throw new IllegalArgumentException("secondes doivent être entre 0 et 86399");
		}
		this.secondes = secondes;
	}
	
	public Durree(int heures, int minutes, int secondes) {
		// Ce constructeur permet d'obtenir une duree exprimee en heures, minutes et secondes
		// La duree exprimee doit etre positive ou nulle et inferieure a un jour
		if(heures < 0 || heures > 23 || minutes < 0 || minutes > 59 || secondes < 0 || secondes > 59) {
			throw new IllegalArgumentException("heures doivent être entre 0 et 23, minutes doivent être entre 0 et 59 et secondes doivent être entre 0 et 59");
		}
		this.secondes = (heures*3600) + (minutes*60) + secondes;
	}
	
	public int getHeures() {
		// retourne le nombre d'heures pleines
		return (this.secondes / 3600) % 24;
	}
	
	public int getMinutes() {
		// retourne le nombre de minutes pleines qui ne sont pas dans une heure pleine
		return (this.secondes / 60) % 60;
	}
	
	public int getSecondes() {
		// retourne le nombre de secondes qui ne sont pas dans une minute pleine
		return this.secondes % 60;
	}

	public int enSecondes() {
		// retourne la duree exprimee en secondes
		return this.secondes % 86399;
	}
	
	public String toString() {
		return secondes + " secondes";
	}
	
	public static void main(String[] args) {
		// Methode main si vous souhaitez faire des tests
		Durree d = new Durree();
		System.out.println(d);
		Durree d1 = new Durree(1200);
		System.out.println(d1);
		Durree d2 = new Durree(2, 50, 59);
		System.out.println(d2);
		System.out.println(d2.getHeures());
		System.out.println(d2.getMinutes());
		System.out.println(d2.getSecondes());
		System.out.println(d2.enSecondes());
	}

}
