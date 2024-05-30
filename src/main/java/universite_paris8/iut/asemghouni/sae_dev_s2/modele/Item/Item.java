package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item;

public class Item {
    private String nom;

    public Item(String nom) {
        this.nom = nom;
    }

    public void utiliser(Item item){
        System.out.println("Utilisation de l'item " + this.nom);
        //faire un for pour que l'item choisie se retire de liventaire
    }

    @Override
    public String toString() {
        return "";
    }
}
