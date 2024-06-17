package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

import javafx.application.Platform;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.MasterSword;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.PotionInvincible;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.Potion;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.Link;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {
    private Link link;
    private Environnement envi;

     /*
        Les tests bug a cause d'un souci d'exportation de librairies et je n'ai pas réussi a résoudre le problème
     */

    @BeforeEach
    void setUp() {
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
