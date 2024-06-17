package universite_paris8.iut.asemghouni.sae_dev_s2;

import javafx.application.Platform;
//import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.MasterSword;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.PotionInvincible;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.Potion;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.Link;

import static org.junit.jupiter.api.Assertions.*;

/*
    J'ai fais les test mais je n'ai pas réussi a lancé car je n'arrivais au cause du import en commentaire en haut qui ne marche pas, j'ai cherchais mais je n'ai pas trouvé
 */

class ZeldaTest {
    private Link link;
    private Environnement envi;

    @BeforeEach
    void setUp() {
//        new JFXPanel(); // Initialiser le toolkit JavaFX
        Platform.runLater(() -> {
        });
        envi = new Environnement();
        link = new Link("Link", 20, new MasterSword(), envi, null);
    }

    @Test
    void testEffetPotionVie() {
        link.setPointVie(16); // Link perd 4 points de vie
        link.effetPotion();
        assertEquals(20, link.getPointVie().get(), "Link devrait récupérer 4 points de vie.");
    }

    @Test
    void testEffetPotionVieMax() {
        link.setPointVie(20); // Link a déjà toute sa vie
        link.effetPotion();
        assertEquals(20, link.getPointVie().get(), "Link ne devrait pas récupérer de points de vie s'il a déjà toute sa vie.");
    }

    @Test
    void testEffetPotionInvincible() throws InterruptedException {
        link.effetPotionInvincible();
        assertTrue(link.estInvincible(), "Link devrait être invincible après avoir utilisé la potion.");

        // Attendre 16 secondes pour vérifier que l'invincibilité est bien supprimée après 15 secondes
        Thread.sleep(16000);
        assertFalse(link.estInvincible(), "Link ne devrait plus être invincible après 15 secondes.");
    }

    @Test
    void testRecevoirDegats() {
        link.recevoirDegats(5);
        assertEquals(15, link.getPointVie().get(), "Link devrait perdre 5 points de vie.");
    }

    @Test
    void testRecevoirDegatsInvincible() {
        link.setInvincible(true);
        link.recevoirDegats(5);
        assertEquals(20, link.getPointVie().get(), "Link ne devrait pas perdre de points de vie lorsqu'il est invincible.");
    }

    @Test
    void testRamasserPotionVie() {
        Potion potionVie = new Potion("Potion de Vie", envi);
        envi.ajouterItem(potionVie);

        // Simuler que Link ramasse la potion de vie
        link.setPointVie(10);
        potionVie.utiliser(link);
        assertEquals(14, link.getPointVie().get(), "Link devrait récupérer 4 points de vie après avoir ramassé une potion de vie.");
    }

    @Test
    void testRamasserPotionInvincible() {
        PotionInvincible potionInvincible = new PotionInvincible("Potion Invincible", envi);
        envi.ajouterItem(potionInvincible);

        // Simuler que Link ramasse la potion invincible
        potionInvincible.utiliser(link);
        assertTrue(link.estInvincible(), "Link devrait être invincible après avoir ramassé une potion invincible.");
    }
}
