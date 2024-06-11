    package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement;

    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.Item;
    import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.Link;
    import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.Personnage;

    public class Environnement {

        private Map map;

        private ObservableList<Personnage> listePersonnagesEnvi;
        private ObservableList<Item> listeItemEnvi;

        public Environnement() {
            this.map = new Map();
            this.listeItemEnvi = FXCollections.observableArrayList();
            this.listePersonnagesEnvi = FXCollections.observableArrayList();
        }

        public Map getMap() {
            return this.map;
        }

        public ObservableList<Personnage> getPersonnages() {
            return this.listePersonnagesEnvi;
        }

        public void ajouter(Personnage personnage) {
            this.listePersonnagesEnvi.add(personnage);
        }

        public ObservableList<Item> getListeItemEnvi(){
            return this.listeItemEnvi;
        }

        public void ajouter(Item item){
            this.listeItemEnvi.add(item);
        }

        public void unTour(Personnage personnage) {

            Item itemRamasable = estRamasable(personnage);

            if (itemRamasable != null) {
                System.out.println("Item ramassé : " + itemRamasable.getNom() + "\n");
                listeItemEnvi.remove(itemRamasable);
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

        public Personnage estMort() {
            for (Personnage perso : listePersonnagesEnvi) {
                System.out.println(listePersonnagesEnvi.size());
                if (!perso.estVivant()) {
                    return perso;
                }
            }
//            System.out.println("Pas de mort !");
            return null;
        }
    }

