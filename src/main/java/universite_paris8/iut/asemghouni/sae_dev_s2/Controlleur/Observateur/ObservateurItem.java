package universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur.Observateur;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import universite_paris8.iut.asemghouni.sae_dev_s2.Vue.VueItem;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.Fleche;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.Item;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.Potion;


import java.util.ArrayList;

public class ObservateurItem implements ListChangeListener<Item> {

    private Pane affichage;
    private ArrayList<Item> vueItems;

    public ObservateurItem(Pane affichage) {
        this.affichage = affichage;
        this.vueItems = new ArrayList<>();
    }

    @Override
    public void onChanged(Change<? extends Item> change) {

        while (change.next()) {

            if (change.wasAdded()) {

                for (Item item : change.getAddedSubList()) {
                    if (item instanceof Potion) {
                        vueItems.add(item);
                    }
                    if (item instanceof Fleche) {
                        vueItems.add(item);
                    }
                }

        } else if (change.wasRemoved()) {
                for (Item item : change.getRemoved()) {
                    this.affichage.getChildren().remove(affichage.lookup("#" + item.getId()));
//                    this.affichage.getChildren().remove(affichage.lookup(item.getId()));

                }
            }
        }
    }

}
