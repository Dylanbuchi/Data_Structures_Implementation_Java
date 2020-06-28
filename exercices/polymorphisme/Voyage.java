package exercices.polymorphisme;

import java.util.ArrayList;

/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
class OptionVoyage {

    private String nom;
    private double prix;

    public OptionVoyage(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;

    }

    @Override
    public String toString() {

        return nom + " -> " + prix + " CHF";
    }

    public double prix() {
        return prix;
    }

    public String getNom() {
        return nom;
    }

}

class Sejour extends OptionVoyage {

    private int nuit;
    private double prixNuit;

    public Sejour(String nom, double prix, int nuit, double prixNuit) {
        super(nom, prix);
        this.nuit = nuit;
        this.prixNuit = prixNuit;

    }

    public int getNuit() {
        return nuit;
    }

    public double getPrixNuit() {
        return prixNuit;
    }

    @Override
    public double prix() {

        return nuit * prixNuit + super.prix();
    }

}

class Transport extends OptionVoyage {

    public final static double TARIF_LONG = 1500.0;
    public final static double TARIF_BASE = 200.0;

    private boolean trajetLong;

    public Transport(String nom, double prix, boolean trajetLong) {
        super(nom, prix);
        this.trajetLong = trajetLong;

    }

    public Transport(String nom, double prix) {
        super(nom, prix);
        this.trajetLong = false;

    }

    public double prix() {

        return trajetLong == true ? TARIF_LONG + super.prix() : TARIF_BASE + super.prix();

    }
}

class KitVoyage {

    private ArrayList<OptionVoyage> kit;
    private String depart;
    private String arrivee;

    public KitVoyage(String depart, String arrivee) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.kit = new ArrayList<>();
    }

    public String getDepart() {
        return depart;
    }

    public String getArrivee() {
        return arrivee;
    }

    public int getNbOptions() {

        return kit.size();
    }

    public void ajouterOption(OptionVoyage optionVoyage) {
        kit.add(optionVoyage);

    }

    public void annuler() {
        kit.clear();
    }

    public String toString() {

        String result = "";

        for (OptionVoyage optionVoyage : kit) {

            if (optionVoyage instanceof Sejour) {

                result += optionVoyage.toString();

            } else if (optionVoyage instanceof Transport) {

                result += optionVoyage.toString();
            }

            else {

                result += optionVoyage.toString();

            }
        }
        return result;
    }

    public double prix() {

        double prix = 0;

        for (OptionVoyage optionVoyage : kit) {

            if (optionVoyage instanceof Sejour) {

                prix += optionVoyage.prix();

            } else if (optionVoyage instanceof Transport) {

                prix += optionVoyage.prix();
            }

            else {

                prix += optionVoyage.prix();

            }
        }

        return prix;
    }

}

/*******************************************
 * Ne pas modifier apres cette ligne pour pr'eserver les fonctionnalit'es et le
 * jeu de test fourni. Votre programme sera test'e avec d'autres donn'ees.
 *******************************************/

public class Voyage {
    public static void main(String args[]) {

        // TEST 1
        System.out.println("Test partie 1 : ");
        System.out.println("----------------");
        OptionVoyage option1 = new OptionVoyage("Séjour au camping", 40.0);
        System.out.println(option1.toString());

        OptionVoyage option2 = new OptionVoyage("Visite guidée : London by night", 50.0);
        System.out.println(option2.toString());
        System.out.println();

        // FIN TEST 1

        // TEST 2
        System.out.println("Test partie 2 : ");
        System.out.println("----------------");

        Transport transp1 = new Transport("Trajet en car ", 50.0);
        System.out.println(transp1.toString());

        Transport transp2 = new Transport("Croisière", 1300.0);
        System.out.println(transp2.toString());

        Sejour sejour1 = new Sejour("Camping les flots bleus", 20.0, 10, 30.0);
        System.out.println(sejour1.toString());
        System.out.println();

        // FIN TEST 2

        // TEST 3
        System.out.println("Test partie 3 : ");
        System.out.println("----------------");

        KitVoyage kit1 = new KitVoyage("Zurich", "Paris");
        kit1.ajouterOption(new Transport("Trajet en train", 50.0));
        kit1.ajouterOption(new Sejour("Hotel 3* : Les amandiers ", 40.0, 5, 100.0));
        System.out.println(kit1.toString());
        System.out.println();
        kit1.annuler();

        KitVoyage kit2 = new KitVoyage("Zurich", "New York");
        kit2.ajouterOption(new Transport("Trajet en avion", 50.0, true));
        kit2.ajouterOption(new Sejour("Hotel 4* : Ambassador Plazza  ", 100.0, 2, 250.0));
        System.out.println(kit2.toString());
        // kit2.annuler();

        // FIN TEST 3
    }
}
