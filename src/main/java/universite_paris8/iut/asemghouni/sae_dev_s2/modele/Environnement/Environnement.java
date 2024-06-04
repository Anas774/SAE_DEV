    package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement;

    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.Item;
    import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Map;

    public class Environnement {

        private Map map;

    //    private ObservableList<Personnage> personnage;
        private ObservableList<Item> listeItemEnvi;

        public Environnement() {
            this.map = new Map();
            this.listeItemEnvi = FXCollections.observableArrayList();
    //        this.personnage = FXCollections.observableArrayList();
        }

        public Map getMap() {
            return this.map;
        }

    //    public ObservableList<Personnage> getPersonnages() {
    //        return this.personnage;
    //    }

    //    public void ajouter(Personnage personnage) {
    //        this.personnage.add(personnage);
    //    }

        public ObservableList<Item> getListeItemEnvi(){
            return this.listeItemEnvi;
        }

        public void ajouter(Item item){
            this.listeItemEnvi.add(item);
        }

        public int taille() {
            return listeItemEnvi.size();
        }
    }

