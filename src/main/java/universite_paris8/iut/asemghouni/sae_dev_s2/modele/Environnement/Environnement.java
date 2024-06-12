    package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement;

    import javafx.beans.property.FloatProperty;
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Arme;
    import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.Item;
    import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.Link;
    import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.Personnage;

    public class Environnement {

        private Map map;
        private ObservableList<Personnage> listePersonnagesEnvi;
        private ObservableList<Item> listeItemEnvi;
        private ObservableList<Arme> listeArmesEnvi;

        public Environnement() {
            this.map = new Map();
            this.listeItemEnvi = FXCollections.observableArrayList();
            this.listePersonnagesEnvi = FXCollections.observableArrayList();
            this.listeArmesEnvi = FXCollections.observableArrayList();
        }

        public Map getMap() {
            return this.map;
        }

        public ObservableList<Personnage> getPersonnages() {
            return this.listePersonnagesEnvi;
        }

        public void ajouterPersonnage(Personnage personnage) {
            this.listePersonnagesEnvi.add(personnage);
        }

        public void retirerPersonnage(Personnage personnage) {
            this.listePersonnagesEnvi.remove(personnage);
        }

        public ObservableList<Item> getListeItemEnvi(){
            return this.listeItemEnvi;
        }

        public void ajouterItem(Item item) {
            this.listeItemEnvi.add(item);
        }

        public void retirerItem(Item item) {
            this.listeItemEnvi.remove(item);
        }

        public ObservableList<Arme> getListeArmesEnvi() {
            return this.listeArmesEnvi;
        }

        public void ajouterArme(Arme arme) {
            this.listeArmesEnvi.add(arme);
        }

        public void retirerArme(Arme arme) {
            this.listeArmesEnvi.remove(arme);
        }


        public void unTour(Personnage personnage) {

            Item itemRamasable = estRamasable(personnage);

            if (itemRamasable != null) {
                System.out.println("Item ramassé : " + itemRamasable.getNom() + "\n");
                listeItemEnvi.remove(itemRamasable);
                ((Link) personnage).getItems().add(itemRamasable);
                ((Link) personnage).effetPotion();
            }



            Arme armeRamasable = estRamasableArme(personnage);

            if (armeRamasable != null) {
                System.out.println("Armes ramassé : " + armeRamasable.getNom() + "\n");
                listeArmesEnvi.remove(armeRamasable);
                for (Personnage perso : listePersonnagesEnvi) {
                    if (perso instanceof Link) {
                        ((Link) perso).getArmePossederParLink().add(armeRamasable);
                    }
                }
            }

            Personnage persoMort = estMort();

            if (persoMort != null) {
                System.out.println("Le personnage est mort : " + persoMort.getNom());
                listePersonnagesEnvi.remove(persoMort);
            }

        }

        public Item estRamasable(Personnage personnage) {
            for (Item item : listeItemEnvi) {
                if ((personnage.getY() - 20 <= item.getY() && item.getY() <= personnage.getY() + 20) &&
                        (personnage.getX() - 20 <= item.getX() && item.getX() <= personnage.getX() + 20)) {
                    return item;
                }
            }
//            System.out.println("Pas d'item à côté");
            return null;
        }

        public Arme estRamasableArme(Personnage personnage) {
            for (Arme arme : listeArmesEnvi) {
                if ((personnage.getY() - 20 <= arme.getY() && arme.getY() <= personnage.getY() + 20) &&
                        (personnage.getX() - 20 <= arme.getX() && arme.getX() <= personnage.getX() + 20)) {
                    return arme;
                }
            }
//            System.out.println("Pas d'armes a coté ");
            return null;
        }

        public Personnage estMort() {
            for (Personnage perso : listePersonnagesEnvi) {
                if (!perso.estVivant()) {
                    return perso;
                }
            }
//            System.out.println("Pas de mort !");
            return null;
        }
    }

