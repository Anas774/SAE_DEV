package universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur.Observateur.ObservateurArme;
import universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur.Observateur.ObservateurItem;
import universite_paris8.iut.asemghouni.sae_dev_s2.Vue.*;
import javafx.util.Duration;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.*;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Map;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.Item;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.Potion;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    // Attribut Personnage
    private Link link;
    private SoldatEnnemi soldatEnnemi;
    private Boss boss;
    private Boss2 boss2;
    private Ganon ganon;

    // Attribut VuePersonnage
    private VueLink vueLink;
    private VueEnnemi vueSoldatEnnemi;
    private VueBoss vueBoss;
    private VueBoss2 vueBoss2;
    private VueGanon vueGanon;

    // Attribut concernant gameloop
    private Timeline gameLoop;
    private int temps;

    // Attribut Environnement et Map
    private Map map;
    private Environnement envi;

    // Attribut concernant VueMap
    private VueMap vueMap;

    // Attribut Pane et tilepane
    @FXML
    private Pane affichagePane;
    @FXML
    private TilePane affichageTilePane;

    // Attribut Item
    private Item item;

    // Attribut concernant la vie
    @FXML
    private HBox vieBox;
    private VueVieLink vueVieLink;
    @FXML
    private HBox inventaireBox;

    // Attribut concernant les observateur
    private ObservateurItem observateurItem;
    private ObservateurArme observateurArme;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        affichageTilePane.setPrefTileHeight(38);
        affichageTilePane.setPrefTileWidth(38);

        this.envi = new Environnement();
        this.map = new Map();

        // Initialiser le personnage principal
        this.link = new Link("Link", 20, new MasterSword(), envi, link);

        // Initialiser le soldat ennemi
        this.soldatEnnemi = new SoldatEnnemi("Ennemi", 10, new Hache(), envi, link);

        // Initialiser le boss
        this.boss = new Boss("Bogo",110, new Epée(),envi,link);

        // Initialiser le boss2
        this.boss2 = new Boss2("Kotake",115, new Arc(), envi, link);

        //Initialiser ganon
        this.ganon = new Ganon("Ganon",120, new EpeeDuDieuBestial(),envi, link);

        // Initialiser le clavier
        Clavier clavier = new Clavier(link, affichagePane, affichageTilePane, map, item);

        // Initialiser les vues
        this.vueMap = new VueMap(affichageTilePane, map);
        this.vueLink = new VueLink(affichagePane, link, affichageTilePane, clavier);
        this.vueSoldatEnnemi = new VueEnnemi(affichagePane, affichageTilePane, soldatEnnemi, link);
        this.vueVieLink = new VueVieLink(vieBox, link.pointVieProperty());
        this.vueBoss = new VueBoss(affichagePane,affichageTilePane,boss,link);
        this.vueBoss2 = new VueBoss2(affichagePane, affichageTilePane, boss2, link);
        this.vueGanon = new VueGanon(affichagePane,affichageTilePane,ganon,link);

        clavier.setVueLink(vueLink);

        affichagePane.requestFocus();
        affichagePane.addEventHandler(KeyEvent.KEY_PRESSED, clavier);

        // Observateur des items
        observateurItem = new ObservateurItem(affichagePane);
        envi.getListeItemEnvi().addListener(observateurItem);

        // Observateur des armes
        observateurArme = new ObservateurArme(affichagePane);
        envi.getListeArmesEnvi().addListener(observateurArme);

        // Observation de la vie de link
        link.pointVieProperty().addListener((obs, old, newValue) -> {
            if (newValue.intValue() <= 0) {
                vueLink.supprimerVue(affichagePane);
            }
        });

        // Observation de la vie du soldatEnnemi
        soldatEnnemi.pointVieProperty().addListener((obs, old, newValue) -> {
            if (newValue.intValue() <= 0) {
                vueSoldatEnnemi.supprimerVue(affichagePane);
            }
        });

        // Observation de la vie du boss
        boss.pointVieProperty().addListener((obs, old, newValue) -> {
            if (newValue.intValue() <= 0) {
                vueBoss.supprimerVue(affichagePane);
            }
        });

        // Observation de la vie du boss2
        boss2.pointVieProperty().addListener((obs, old, newValue) -> {
            if (newValue.intValue() <= 0) {
                vueBoss2.supprimerVue(affichagePane);
            }
        });

        // Observation de la vie du ganon
        ganon.pointVieProperty().addListener((obs, old, newValue) -> {
            if (newValue.intValue() <= 0) {
                vueGanon.supprimerVue(affichagePane);
            }
        });

        // Démarrer l'animation
        animation();
        gameLoop.play();

    }

    @FXML
    public void mouseClicked(MouseEvent mouseEvent) {
        affichagePane.requestFocus();

    }

    private void animation() {
        gameLoop = new Timeline();
        temps = 0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(0.017),
                (ev -> {
                    if (temps == 10000) {
                        System.out.println("fin");
                        gameLoop.stop();
                    }
                    if (temps == 2) {
                        envi.getListeArmesEnvi().add(new MasterSword());
                    }
                    else if (temps % 10 == 0) {
                        for (Personnage p : envi.getPersonnages()) {
                            if (p instanceof SoldatEnnemi) {
                                ((SoldatEnnemi) p).suivreJoueur2();
                            }
                            if (p instanceof Boss) {
                                ((Boss) p).suivreJoueur2Boss();
                            }
                            if (p instanceof Boss2) {
                                ((Boss2) p).suivreJoueur2Boss2();
                            }
                            if (p instanceof Ganon) {
                                ((Ganon) p).suivreJoueur2Ganon();
                            }
                        }

                        if (temps % 500 == 0) {
                            for (int i = 0; i < 1; i++) {
                                envi.getListeItemEnvi().add(new Potion("popo", envi));
                            }
                        }
                    }

                    // Logique de vérification des ennemis tués et d'apparition des boss
                    verifierEnnemisTuesEtApparitionBoss();

                    envi.unTour(link);
                    temps++;
                })
        );

        gameLoop.getKeyFrames().add(keyFrame);
    }

    private int ennemisTues = 0;
    private int phaseBoss = 0;

    private void verifierEnnemisTuesEtApparitionBoss() {
        long ennemisRestants = envi.getPersonnages().stream().filter(p -> p instanceof SoldatEnnemi && !p.estVivant()).count();

        if (ennemisRestants >= 5) {
            ennemisTues += ennemisRestants;
            if (ennemisTues >= 5) {
                ennemisTues = 0;
                phaseBoss++;
                spawnBoss();
            }
        }
    }

    private void spawnBoss() {
        switch (phaseBoss) {
            case 1:
                boss = new Boss("Bogo", 110, new Epée(), envi, link);
                vueBoss = new VueBoss(affichagePane, affichageTilePane, boss, link);
                envi.ajouterPersonnage(boss);
                boss.pointVieProperty().addListener((obs, old, newValue) -> {
                    if (newValue.intValue() <= 0) {
                        vueBoss.supprimerVue(affichagePane);
                    }
                });
                break;
            case 2:
                boss2 = new Boss2("Kotake", 115, new Arc(), envi, link);
                vueBoss2 = new VueBoss2(affichagePane, affichageTilePane, boss2, link);
                envi.ajouterPersonnage(boss2);
                boss2.pointVieProperty().addListener((obs, old, newValue) -> {
                    if (newValue.intValue() <= 0) {
                        vueBoss2.supprimerVue(affichagePane);
                    }
                });
                break;
            case 3:
                ganon = new Ganon("Ganon", 120, new EpeeDuDieuBestial(), envi, link);
                vueGanon = new VueGanon(affichagePane, affichageTilePane, ganon, link);
                envi.ajouterPersonnage(ganon);
                ganon.pointVieProperty().addListener((obs, old, newValue) -> {
                    if (newValue.intValue() <= 0) {
                        vueGanon.supprimerVue(affichagePane);
                        System.out.println("Link a gagné !");
                        gameLoop.stop();
                    }
                });
                break;
        }
    }

}