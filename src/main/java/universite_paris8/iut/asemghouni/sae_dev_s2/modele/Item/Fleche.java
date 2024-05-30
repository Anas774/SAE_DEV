package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item;

public class Fleche extends Item {
    private int nombre;
    public Fleche(String nom, int nombre) {
        super(nom);
        this.nombre = nombre;
    }

//    public void ramasser() {
//
//    }


    @Override
    public String toString() {
        return "Une flèche !";
    }
}
