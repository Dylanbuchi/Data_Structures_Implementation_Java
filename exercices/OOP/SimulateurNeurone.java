package exercices.OOP;
import java.util.ArrayList;

/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
class Position {

    private double x;
    private double y;

    public Position(double x, double y){
        this.x = x;
        this.y = y;

    }
    public Position(){
       this(0, 0);

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        
        return String.format("(%.1f, %.1f)", x, y);
    }
}


class Neurone {

    private Position position;
    protected double signal;
    protected double attenuation;
    protected ArrayList<Neurone> connexions;

    public Neurone(Position position, double attenuation) {
        this.position = position;
        this.attenuation = attenuation;
        this.signal = 0;
        this.connexions = new ArrayList<>();
    }

    public Position getPosition() {
        return position;
    }

    public int getNbConnexions() {
        return connexions.size();
    }

    public double getSignal() {
        return signal;

    }

    public double getAttenuation() {
        return attenuation;
    }

    public Neurone getConnexion(int index) {
        return connexions.get(index);
    }

    public void connexion(Neurone n) {
        connexions.add(n);

    }

    public void recoitStimulus(double stimulus) {

        signal = stimulus * attenuation;

        for (Neurone neurone : connexions) {
            neurone.recoitStimulus(signal);
        }

    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (Neurone neurone : connexions) {

            s.append("  - un neurone en position " + neurone.position + "\n");

        }
        return connexions.isEmpty()
                ? String.format("Le neurone en position %s avec attenuation %.1f sans connexion\n", position,
                        attenuation)
                : String.format("Le neurone en position %s avec attenuation %.1f en connexion avec\n", position, attenuation)
                        + s;

    }

}

class NeuroneCumulatif extends Neurone {

    public NeuroneCumulatif(Position position, double attenuation) {
        super(position, attenuation);
    }

    @Override
    public void recoitStimulus(double stimulus) {

        signal += stimulus * attenuation;

        for (Neurone neurone : connexions) {
            neurone.recoitStimulus(signal);
        }
    }

}

class Cerveau {

    private ArrayList<Neurone> cerveau;

    public Cerveau(){
        this.cerveau = new ArrayList<>();
    }

    public int getNbNeurones(){
        return cerveau.size();
    }

    public Neurone getNeurone(int index) {
        return cerveau.get(index);

    }

    public void ajouterNeurone(Position pos, double attenuation){
        cerveau.add(new Neurone(pos, attenuation));
    }

    public void ajouterNeuroneCumulatif(Position pos, double attenuation){
        cerveau.add(new NeuroneCumulatif(pos, attenuation));
    }

    public void stimuler(int index, double stimulus){
        cerveau.get(index).recoitStimulus(stimulus);

    }

    public double sonder(int index){
        return cerveau.get(index).getSignal();

    }

    public void creerConnexions(){
        
        int size = cerveau.size();
		int i = 0;
		
		cerveau.get(i).connexions.add(cerveau.get(i + 1));
		cerveau.get(i).connexions.add(cerveau.get(i + 2));
		
		i++;
		
		if (cerveau.size() != 0) {

			while (i  < size - 2) {

				if (size >= i + 1) {
					cerveau.get(i).connexions.add(cerveau.get(i + 1));
                }
                
				if (size >= i + 2) {
					cerveau.get(i + 1).connexions.add(cerveau.get(i + 2));
                }
                
				i += 2;
			}
			
		}
    }

    public String toString() {
        String s = "Le cerveau contient " + cerveau.size() + " neurone(s)\n";
        
		for(Neurone neurone : cerveau) {
			s+= neurone + "\n";
        }
        
		return s;
	}


}
/*******************************************
 * Ne pas modifier apres cette ligne
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/
public class SimulateurNeurone {

    public static void main(String[] args) {
        // TEST DE LA PARTIE 1
        System.out.println("Test de la partie 1:");
        System.out.println("--------------------");

        Position position1 = new Position(0, 1);
        Position position2 = new Position(1, 0);
        Position position3 = new Position(1, 1);

        Neurone neuron1 = new Neurone(position1, 0.5);
        Neurone neuron2 = new Neurone(position2, 1.0);
        Neurone neuron3 = new Neurone(position3, 2.0);

        neuron1.connexion(neuron2);
        neuron2.connexion(neuron3);
        neuron1.recoitStimulus(10);

        System.out.println("Signaux : ");
        System.out.println(neuron1.getSignal());
        System.out.println(neuron2.getSignal());
        System.out.println(neuron3.getSignal());

        System.out.println();
        System.out.println("Premiere connexion du neurone 1");
        System.out.println(neuron1.getConnexion(0));


        // FIN TEST DE LA PARTIE 1

        // TEST DE LA PARTIE 2
        System.out.println("Test de la partie 2:");
        System.out.println("--------------------");

        Position position5 = new Position(0, 0);
        NeuroneCumulatif neuron5 = new NeuroneCumulatif(position5, 0.5);
        neuron5.recoitStimulus(10);
        neuron5.recoitStimulus(10);
        System.out.println("Signal du neurone cumulatif  -> " + neuron5.getSignal());

        // FIN TEST DE LA PARTIE 2

        // TEST DE LA PARTIE 3
        System.out.println();
        System.out.println("Test de la partie 3:");
        System.out.println("--------------------");
        Cerveau cerveau = new Cerveau();

        // parametres de construction du neurone:
        // la  position et le facteur d'attenuation
        cerveau.ajouterNeurone(new Position(0,0), 0.5);
        cerveau.ajouterNeurone(new Position(0,1), 0.2);
        cerveau.ajouterNeurone(new Position(1,0), 1.0);

        // parametres de construction du neurone cumulatif:
        // la  position et le facteur d'attenuation
        cerveau.ajouterNeuroneCumulatif(new Position(1,1), 0.8);
        cerveau.creerConnexions();
        cerveau.stimuler(0, 10);

        System.out.println("Signal du 3eme neurone -> " + cerveau.sonder(3));
        System.out.println(cerveau);
        // FIN TEST DE LA PARTIE 3
    }
}
