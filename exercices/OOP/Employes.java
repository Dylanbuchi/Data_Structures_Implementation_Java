/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 class Employe {
	
	private String nom;
	private double salaire;
	private int taux;
	private double prime;
	
	public Employe(String nom, double salaire, int taux) {

        if (taux < 10) {
            taux = 10;
        }
        else if (taux > 100) {
            taux = 100;
        }

		this.nom = nom;
		this.salaire = salaire;
        this.taux = taux;

 
		System.out.print("Nous avons un nouvel employé : " + nom + ", c'est un " + this.getClass().getName().toLowerCase() + ".\n" );
	}
	public Employe(String nom, double salaire) {
		this(nom, salaire, 100);
	}
    
 
	public double revenuAnnuel() {
		return salaire * 12 * taux / 100 + prime;
	}
    
    @Override
	public String toString() {
	
		return prime == 0 
		?  String.format("%s :\n  Taux d’occupation : %d%%. Salaire annuel : %.2f francs.\n", nom, taux, revenuAnnuel()) 
		: String.format("%s :\n  Taux d’occupation : %d%%. Salaire annuel : %.2f francs, Prime : %.2f.\n", nom, taux, revenuAnnuel(), prime);
	}

    public void demandePrime() {

		Scanner in = new Scanner(System.in);
		int count = 5;

		while(count-- > 0) {

			try {
				System.out.printf("Montant de la prime souhaitée par %s ?\n", nom);
				double input = in.nextDouble();

				if (input <= revenuAnnuel() * 0.02) {
					in.nextLine();
					prime = input;
					break;
				}
					else {

					 System.out.println("Trop Cher!");
					 continue;
                 
					}
				
			} catch (Exception e) { 
				System.out.println("Vous devez introduire un nombre!");
				in.nextLine();
				continue;
			}


		}
    }
}

class Manager extends Employe {
	
	private final double FACTEUR_GAIN_CLIENT = 500;
	private final double FACTEUR_GAIN_VOYAGE = 100;
	private int voyage;
	private int client;
	
	public Manager(String nom, double salaire, int voyage, int client) {
		super(nom, salaire);
		this.voyage = voyage;
		this.client = client;
	
	}
    
    @Override
	public double revenuAnnuel() {

		return super.revenuAnnuel() + (voyage * FACTEUR_GAIN_VOYAGE) + (client * FACTEUR_GAIN_CLIENT);

	}
    
    @Override
	public String toString() {

        String formated = String.format("  A voyagé %d jours et apporté %d nouveaux clients.\n", voyage, client);
	
		return super.toString() + formated ;
        
	}
}

class Programmeur extends Employe {
	
	private final double FACTEUR_GAIN_PROJET = 200;
	private int project;
	
	public Programmeur(String nom, double salaire, int project, int taux) {
		super(nom, salaire, taux);
		this.project = project;
	
	}

    @Override
	public double revenuAnnuel() {

		return super.revenuAnnuel() + (project * FACTEUR_GAIN_PROJET);
	}
    @Override
	public String toString() {

        String formated = String.format("  A mené à bien %d projets\n", project);
	
		return super.toString() + formated ;
	}
}

class Testeur extends Employe {
	
	private int erreur;
	private final double FACTEUR_GAIN_ERREURS = 10;
	
	public Testeur(String nom, double salaire, int erreur, int taux) {
		super(nom, salaire, taux);
		this.erreur = erreur;
		
    }
    
    @Override
	public double revenuAnnuel() {

		return super.revenuAnnuel() + (erreur * FACTEUR_GAIN_ERREURS);
    }
    
    @Override
	public String toString() {
		String formated = String.format("  A corrigé %d erreurs.\n", erreur);
	
		return super.toString() + formated ;
	}
}
/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
class Employes {
    public static void main(String[] args) {

        List<Employe> staff = new ArrayList<Employe>();

        // TEST PARTIE 1:

        System.out.println("Test partie 1 : ");
        staff.add(new Manager("Serge Legrand", 7456, 30, 4 ));
        staff.add(new Programmeur("Paul Lepetit" , 6456, 3, 75 ));
        staff.add(new Testeur("Pierre Lelong", 5456, 124, 50 ));

        System.out.println("Affichage des employés : ");
        for (Employe modele : staff) {
            System.out.println(modele);
        }
        // FIN TEST PARTIE 1
        // TEST PARTIE 2
        System.out.println("Test partie 2 : ");

        staff.get(0).demandePrime();

        System.out.println("Affichage après demande de prime : ");
        System.out.println(staff.get(0));

        // FIN TEST PARTIE 2
    }
}

