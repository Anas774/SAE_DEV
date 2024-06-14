package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Arme;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Epée;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.Item;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.MasterSword;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.Potion;


public class Link extends Personnage {
    private Personnage cible;
    private ObservableList<Item> itemPossederParLink;
    private ObservableList<Arme> armePossederParLink;
    private boolean aDesArmes = false;
    private boolean aDesItems = false;

    public Link(String nom, int PointVie, Arme arme,  Environnement envi, Personnage cible) {
        super("Link", 20, new MasterSword(), envi);                                 // 10 coeurs
        this.cible = cible;
        this.itemPossederParLink = FXCollections.observableArrayList();
        this.armePossederParLink = FXCollections.observableArrayList();

    }
    public ObservableList<Item> getItems() {
        return itemPossederParLink;
    }

    public void ramasserItem(Item item) {
        if (item instanceof Potion) {
            if (this.getPointVie().get() < this.getVieMax()) {
                ((Potion) item).utiliser(this);
                System.out.println("Potion utilisée et retiré de l'inventaire." + "\n");
            } else {
                System.out.println("Link a déjà toute sa vie. Il ne peut pas consommer la potion." + "\n");
            }
        } else {
            itemPossederParLink.add(item);
            aDesItems = true;
            afficherItems();
        }
    }

    public void retirerItem(Item item) {
        itemPossederParLink.remove(item);
        if (itemPossederParLink.isEmpty()) {
            aDesItems = false;
        }
        afficherItems();
    }

    public void afficherItems() {
        System.out.println("Items dans l'inventaire :");
        for (Item item : itemPossederParLink) {
            System.out.println("- " + item.getNom());
        }
    }


    public boolean possedeItem(Item item) {
        for (Item i : itemPossederParLink) {
            if (i.getNom().equals(i.getNom())) {
                return true;
            }
        }
        return false;
    }


    public boolean possedeArme(Arme arme) {
        for (Arme a : armePossederParLink) {
            if (a.getNom().equals(arme.getNom())) {
                return true;
            }
        }
        return false;
    }

    public boolean possedeEpee() {
        for (Arme arme : armePossederParLink) {
            if (arme instanceof MasterSword) {
                return true;
            }
        }
        return false;
    }


    public void ramasserArme(Arme arme) {
        if (!possedeArme(arme)) {
            armePossederParLink.add(arme);
            aDesArmes = true;
            afficherArmes();
        } else {
            System.out.println("Link possede deja l'arme qui est : " + arme.getNom());
        }
    }

    public void retirerArme(Arme arme) {
        armePossederParLink.remove(arme);
        if (armePossederParLink.isEmpty()) {
            aDesArmes = false;
        }
        afficherArmes();
    }

    public void afficherArmes() {
        System.out.println("Armes dans l'inventaire :");
        for (Arme arme : armePossederParLink) {
            System.out.println("- " + arme.getNom() + "\n");
        }
    }

    public void infligerDegats(Personnage cible, int degats) {
        if (possedeEpee() && VerifpeutAttaquerCorpsACorps(cible)) {
            cible.recevoirDegats(degats);
            System.out.println("Link a infligé " + degats + " points de dégâts.");
        } else {
            System.out.println("Link doit ramasser une épée avant de pouvoir infliger des dégâts.");
        }
    }

//    private boolean VerifpeutAttaquerCorpsACorpsEnnemie(Personnage cible) {
//        if (cible != null) {
//            if ((this.getY() - 30 <= cible.getY() && cible.getY() <= this.getY() + 30) &&
//                    (this.getX() - 30 <= cible.getX() && cible.getX() <= this.getX() + 30)) {
//                return true;
//            }
//        }
//        return false;
//    }

    public void recupererVie(int points) {

        int pointVieActuelle = this.getPointVie().get();

        pointVieActuelle = pointVieActuelle + points;

        if (pointVieActuelle > 20) {
            pointVieActuelle = 20;
        }
        this.getPointVie().set(pointVieActuelle);
    }
}



