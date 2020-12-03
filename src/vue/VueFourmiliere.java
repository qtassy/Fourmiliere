package vue;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;
import graphicLayer.GOval;
import graphicLayer.GRect;

/**
 * Classe permettant de gérer le composant graphique d'une fourmilière et de le séparer de son
 * modèle (classe Fourmiliere).
 * 
 * @author Clément Stoliaroff, Quentin Tassy
 */
public class VueFourmiliere {
  /**
   * Le rectangle représentant la fourmilière.
   */
  private GRect composantFourmiliere;

  /**
   * Reférence vers la représentation graphique du terrain contenant la représentation graphique de
   * la fourmilière.
   */
  VueTerrain laVueTerrain;

  /**
   * Permet de créer la representation graphique de la fourmilière et de l'ajouter dans la
   * représentation graphique du terrain.
   * 
   * @param uneVueTerrain La représentation graphique du terrain dans laquelle ajouter la
   *        représentation graphique de la fourmilière.
   */
  public VueFourmiliere(VueTerrain uneVueTerrain) {
    this.laVueTerrain = uneVueTerrain;
    this.composantFourmiliere = new GRect();
    // La fourmilière est un carré marron (en code RGB)
    this.composantFourmiliere.setColor(new Color(88, 41, 0));
    this.placerFourmiliere();
    this.laVueTerrain.ajouterFourmiliere(this.composantFourmiliere);
  }
  
  /**
   * Place la fourmiliere de maniere aléatoire sur le terrain.
   */
  public void placerFourmiliere() {
    Random random = new Random();
    int x = random.nextInt(laVueTerrain.getLargeurTerrain() - this.composantFourmiliere.getHeight());
    int y = random.nextInt(laVueTerrain.getHauteurTerrain() - this.composantFourmiliere.getWidth());
    composantFourmiliere.setPosition(new Point(x,y));
  }

  /**
   * Ajoute la représentation graphique d'une fourmi dans la représentation graphique du terrain.
   * 
   * @param laFourmi Le cercle représentant la fourmi à ajouter.
   */
  public void ajouterFourmi(GOval laFourmi) {
    // On calcule la position de la fourmi pour qu'elle apparaisse au milieu de la fourmilière
    int milieurHorizontal = (int) (this.composantFourmiliere.getX()
        + (this.composantFourmiliere.getWidth() / 2) - laFourmi.getWidth());

    int milieurVertical = (int) (this.composantFourmiliere.getY()
        + (this.composantFourmiliere.getHeight() / 2) - laFourmi.getHeight());

    // On place la fourmi au milieu de la fourmilière
    laFourmi.setPosition(new Point(milieurHorizontal, milieurVertical));

    // On Fait apparaitre la fourmi sur le terrain
    this.laVueTerrain.ajouterFourmi(laFourmi);
  }

  public GRect getComposantFourmiliere() {
    return composantFourmiliere;
  }

  public VueTerrain getLaVueTerrain() {
    return this.laVueTerrain;
  }
}
