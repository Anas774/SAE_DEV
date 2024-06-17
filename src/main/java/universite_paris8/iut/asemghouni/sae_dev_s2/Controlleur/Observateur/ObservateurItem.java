package universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur.Observateur;
import javafx.collections.ListChangeListener;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.Item;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.Potion;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.PotionInvincible;
//import universite_paris8.iut.asemghouni.sae_dev_s2.Vue.VueItem;


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
                        creeItemPotionVie(affichage, item);
                    }
                    if (item instanceof PotionInvincible) {
                        creeItemPotionInvincible(affichage,item);
                    }
                }
            } else if (change.wasRemoved()) {
                for (Item item : change.getRemoved()) {
                    this.affichage.getChildren().remove(affichage.lookup("#" + item.getId()));
                }
            }
        }
    }

    private void creeItemPotionVie(Pane affichagePane, Item item) {
        Image item1 = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/image/potion_bleu.png").toString());
        ImageView itemImageview = new ImageView(item1);
        itemImageview.setFitWidth(15);
        itemImageview.setFitHeight(15);
        itemImageview.setId(item.getId());
        itemImageview.translateXProperty().bind(item.getXProperty());
        itemImageview.translateYProperty().bind(item.getYProperty());
        affichagePane.getChildren().add(itemImageview);
    }

    private void creeItemPotionInvincible(Pane affichagePane, Item item) {
        Image item2 = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/image/PotionInvincible.png").toString());
        ImageView item2Imageview = new ImageView(item2);
        item2Imageview.setFitWidth(18);
        item2Imageview.setFitHeight(18);
        item2Imageview.setId(item.getId());
        item2Imageview.translateXProperty().bind(item.getXProperty());
        item2Imageview.translateYProperty().bind(item.getYProperty());
        affichagePane.getChildren().add(item2Imageview);
    }

}