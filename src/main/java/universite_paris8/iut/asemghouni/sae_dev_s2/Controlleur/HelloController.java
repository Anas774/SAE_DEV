package universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur;

import javafx.animation.KeyFrame;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur.Observateur.ObservateurArme;
import universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur.Observateur.ObservateurItem;
import universite_paris8.iut.asemghouni.sae_dev_s2.Vue.*;
import javafx.animation.Timeline;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.*;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Map;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.Item;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.PotionInvincible;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.Potion;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    // Attribut concernant Link
    private Link link;
    private VueLink vueLink;

    // Attribut Item
    private Item item;

    // Attribut concernant Gameloop
    private Timeline gameLoop;
    private int temps;

    // Attribut concernant l'envi et la map
    private Map map;
    private Environnement envi;
    private VueMap vueMap;

    // Attribut concernant l'affichage
    @FXML
    private Pane affichagePane;
    @FXML
    private TilePane affichageTilePane;

    // Attribut concernant la vie de link
    @FXML
    private HBox vieBox;
    private VueVieLink vueVieLink;

    // Attribut Observateur
    private ObservateurItem observateurItem;
    private ObservateurArme observateurArme;

    // Compteur
    private int ennemisTues = 0;
    private int phaseBoss = 0;

    // Attribut boolean
    private boolean BossEnVie = false;
    private boolean Boss2EnVie = false;
    private boolean GanonEnVie = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        affichageTilePane.setPrefTileHeight(38);
        affichageTilePane.setPrefTileWidth(38);

        // Initialise l'environnement et la map
        this.envi = new Environnement();
        this.map = new Map();

        // Initialise Link
        this.link = new Link("Link", 20, new MasterSword(), envi, link);

        // Initialise le clavier
        Clavier clavier = new Clavier(link, affichagePane, affichageTilePane, map, item);

        // Initialise les vues
        this.vueMap = new VueMap(affichageTilePane, map);
        this.vueLink = new VueLink(affichagePane, link, affichageTilePane, clavier);
        this.vueVieLink = new VueVieLink(vieBox, link.pointVieProperty());

        clavier.setVueLink(vueLink);

        affichagePane.requestFocus();
        affichagePane.addEventHandler(KeyEvent.KEY_PRESSED, clavier);

        // Observateur Item
        observateurItem = new ObservateurItem(affichagePane);
        envi.getListeItemEnvi().addListener(observateurItem);

        // Observateur Arme
        observateurArme = new ObservateurArme(affichagePane);
        envi.getListeArmesEnvi().addListener(observateurArme);

        // Pour observer la vie de link
        link.pointVieProperty().addListener((obs, old, newValue) -> {
            if (newValue.intValue() <= 0) {
                vueLink.supprimerVue(affichagePane);
                System.out.println("Game Over! Link a été vaincu." + "\n");
                gameLoop.stop();
            }
        });

        animation();
        gameLoop.play();
    }

    @FXML
    public void mouseClicked(MouseEvent mouseEvent) {
        affichagePane.requestFocus();
    }

    private void spawnEnnemi() {

        // Initialise soldatEnnemi
        SoldatEnnemi soldatEnnemi = new SoldatEnnemi("SoldatEnnemi", 100, new Hache(), envi, link);

        // Initialise VueSoldatEnnemi
        VueEnnemi vueSoldatEnnemi = new VueEnnemi(affichagePane, affichageTilePane, soldatEnnemi, link);

        envi.ajouterPersonnage(soldatEnnemi);

        // Pour observer la vie du soldatEnnemi
        soldatEnnemi.pointVieProperty().addListener((obs, old, newValue) -> {
            if (newValue.intValue() <= 0) {
                vueSoldatEnnemi.supprimerVue(affichagePane);
                ennemisTues++;
                System.out.println("SoldatEnnemi tué !" + "\n" + "Total SoldatEnnemis tués : " + ennemisTues + "\n");
                verifierPhase();
            }
        });
    }

    private void spawnBoss() {
        if (!BossEnVie) {

            // Initialise boss
            Boss boss = new Boss("Bogo", 160, new Epée(), envi, link);

            // Initialise VueBoss
            VueBoss vueBoss = new VueBoss(affichagePane, affichageTilePane, boss, link);

            envi.ajouterPersonnage(boss);

            BossEnVie = true;

            // Pour observer la vie du boss
            boss.pointVieProperty().addListener((obs, old, newValue) -> {
                if (newValue.intValue() <= 0) {
                    vueBoss.supprimerVue(affichagePane);
                    phaseBoss++;
                    BossEnVie = false;
                    System.out.println("Boss Bogo vaincu. Passage à la phase : " + phaseBoss);
                    verifierPhase();
                }
            });
        }
    }

    private void spawnBoss2() {
        if (!Boss2EnVie) {

            // Initialise boss2
            Boss2 boss2 = new Boss2("Kotake", 180, new Epée(), envi, link);

            // Initialise VueBoss2
            VueBoss2 vueBoss2 = new VueBoss2(affichagePane, affichageTilePane, boss2, link);

            envi.ajouterPersonnage(boss2);

            Boss2EnVie = true;

            // Pour observer la vie du boss2
            boss2.pointVieProperty().addListener((obs, old, newValue) -> {
                if (newValue.intValue() <= 0) {
                    vueBoss2.supprimerVue(affichagePane);
                    phaseBoss++;
                    Boss2EnVie = false;
                    System.out.println("Boss Kotake vaincu. Passage à la phase : " + phaseBoss);
                    verifierPhase();
                }
            });
        }
    }

    private void spawnGanon() {
        if (!GanonEnVie) {

            // Initialise ganon
            Ganon ganon = new Ganon("Ganon", 200, new EpeeDuDieuBestial(), envi, link);

            // Initialise VueGanon
            VueGanon vueGanon = new VueGanon(affichagePane, affichageTilePane, ganon, link);

            envi.ajouterPersonnage(ganon);

            GanonEnVie = true;

            // Pour observer la vie de ganon
            ganon.pointVieProperty().addListener((obs, old, newValue) -> {
                if (newValue.intValue() <= 0) {
                    vueGanon.supprimerVue(affichagePane);
                    System.out.println("Link a gagné !" + "\n");
                    GanonEnVie = false;
                    gameLoop.stop();

                }
            });
        }
    }

    private void verifierPhase() {
        if (ennemisTues >= 1) {
            if (!BossEnVie && phaseBoss == 0) {
                spawnBoss();
            } else if (!Boss2EnVie && phaseBoss == 1) {
                spawnBoss2();
            } else if (!GanonEnVie && phaseBoss == 2) {
                spawnGanon();
            }
        }
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
                    if (temps == 1) {
                        envi.getListeArmesEnvi().add(new MasterSword());
                    }
                    if (temps % 200 == 0) {
                        for (int i = 0; i < 1; i++) {
                            envi.getListeItemEnvi().add(new Potion("popo", envi));
                        }
                    }
                    if (temps % 1500 == 0) {
                        for (int i = 0; i < 1; i++) {
                            envi.getListeItemEnvi().add(new PotionInvincible("PotionInvincible", envi));
                        }
                    }
                    if (temps == 1) {
                        for (int i = 0; i < 1; i++) {
                            spawnEnnemi();
                        }
                    }
                    if (temps % 13 == 0) {
                        for (Personnage p : envi.getPersonnages()) {
                            if (p instanceof SoldatEnnemi) {
                                ((SoldatEnnemi) p).suivreJoueurSoldatEnnemi();
                            } else if (p instanceof Boss) {
                                ((Boss) p).suivreJoueurBoss();
                            } else if (p instanceof Boss2) {
                                ((Boss2) p).suivreJoueur2Boss2();
                            } else if (p instanceof Ganon) {
                                ((Ganon) p).suivreJoueur2Ganon();
                            }
                        }
                    }
                    envi.unTour(link);
                    temps++;
                })
        );

        gameLoop.getKeyFrames().add(keyFrame);
    }
}
