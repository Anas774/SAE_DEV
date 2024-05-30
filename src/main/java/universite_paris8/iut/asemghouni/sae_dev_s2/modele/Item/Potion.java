package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item;

import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.Item;

public class Potion extends Item {
    private String effet;
    public Potion(String nom, String effet) {
        super(nom);
        this.effet = effet;
    }
//    public void utiliserPotion() {
//        if ()
//    }
}
