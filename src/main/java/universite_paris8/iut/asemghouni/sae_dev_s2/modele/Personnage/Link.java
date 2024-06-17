package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Arme;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Epée;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.Item;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.MasterSword;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.Potion;

import java.util.Timer;
import java.util.TimerTask;


public class Link extends Personnage {
    private Personnage cible;
    private ObservableList<Item> itemPossederParLink;
    private ObservableList<Arme> armePossederParLink;
    private boolean aDesArmes = false;
    private boolean invincible = false;

    public Link(String nom, int PointVie, Arme arme,  Environnement envi, Personnage cible) {
        super("Link", 20, new MasterSword(), envi);                                 // 10 coeurs
        this.cible = cible;
        this.itemPossederParLink = FXCollections.observableArrayList();
        this.armePossederParLink = FXCollections.observableArrayList();
    }
    public ObservableList<Item> getItems() {
        return itemPossederParLink;
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
            System.out.println("Link a infligé " + degats + " points de dégâts." + "\n");
        } else {
            System.out.println("Link doit ramasser une épée avant de pouvoir infliger des dégâts." + "\n");
        }
    }

    public void recupererVie(int points) {

        int pointVieActuelle = this.getPointVie().get();

        pointVieActuelle = pointVieActuelle + points;

        if (pointVieActuelle > 20) {
            pointVieActuelle = 20;
        }
        this.getPointVie().set(pointVieActuelle);
    }

    public void effetPotion() {
        if (this.getPointVie().get() < this.getVieMax()) {
            this.recupererVie(4);
            System.out.println("Link utilise une potion de vie et récupère 2 points de vie.");
        } else {
            System.out.println("Link a déjà toute sa vie.");
        }
    }

    public void effetPotionInvincible() {
        this.invincible = true;
        System.out.println("Link utilise une potion d'invincibilité et ne peut pas recevoir de dégâts pendant 15 secondes." + "\n");

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                invincible = false;
                System.out.println("L'effet de la potion d'invincibilité s'est terminé. Link peut à nouveau recevoir des dégâts." + "\n");
            }
        }, 15000);
    }

    public boolean estInvincible() {
        return invincible;
    }

    public void setInvincible(boolean invincible) {
        this.invincible = invincible;
    }

    @Override
    public void recevoirDegats(int degats) {
        if (!invincible) {
            super.recevoirDegats(degats);
        } else {
            System.out.println("Link est invincible et ne reçoit pas de dégâts." + "\n");
        }
    }
}



