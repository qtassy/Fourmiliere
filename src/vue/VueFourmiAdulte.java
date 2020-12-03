package vue;

import java.awt.Dimension;
import java.util.Random;
import graphicLayer.GOval;

/**
 * Classe permettant de gérer les composants graphiques des fourmis Adultes et de les séparer de leurs
 * modèles.
 * 
 * @author Clément Stoliaroff, Quentin Tassy
 *
 */
public abstract class VueFourmiAdulte {
  /**
   * Cercle représentant la fourmi
   */
  protected GOval composantGraphique;
  
  /**
   * Reférence vers la représentation graphique de la fourmilière.
   */
  protected VueFourmiliere laVueDeLaFourmiliere;

  /**
   * Créé la 
   * @param laVueDeLaFourmiliere
   */
  public VueFourmiAdulte(VueFourmiliere laVueDeLaFourmiliere) {
    this.laVueDeLaFourmiliere = laVueDeLaFourmiliere;
    this.composantGraphique = new GOval();
    this.composantGraphique.setDimension(new Dimension(6, 6));
    this.laVueDeLaFourmiliere.ajouterFourmi(this.composantGraphique);
  }

  public void seDeplacer() {
    Random random = new Random();
    int unNombreAleatoire = random.nextInt(4);

    if (unNombreAleatoire == 0) {
      int posX = this.getComposantGraphique().getX() + 10;
      if (this.verifierPositionX(posX)) {
        composantGraphique.setX(posX);
      }
    } else if (unNombreAleatoire == 1) {
      int posX = this.getComposantGraphique().getX() - 10;
      if (this.verifierPositionX(posX)) {
        composantGraphique.setX(posX);
      }
    } else if (unNombreAleatoire == 2) {
      int posY = this.getComposantGraphique().getY() + 10;
      if (this.verifierPositionY(posY)) {
        composantGraphique.setY(posY);
      }
    } else if (unNombreAleatoire == 3) {
      int posY = this.getComposantGraphique().getY() - 10;
      if (this.verifierPositionY(posY)) {
        composantGraphique.setY(posY);
      }
    }
  }

  public boolean verifierPositionX(int pos) {
    return (pos > 0 && pos < (laVueDeLaFourmiliere.getLaVueTerrain().getLargeurTerrain()
        - this.composantGraphique.getWidth()));
  }

  public boolean verifierPositionY(int pos) {
    return (pos > 0 && pos < (laVueDeLaFourmiliere.getLaVueTerrain().getHauteurTerrain()
        - this.composantGraphique.getHeight()));
  }

  public void supprimerFourmi() {
    laVueDeLaFourmiliere.getLaVueTerrain().supprimerFourmi(composantGraphique);
  }

  public GOval getComposantGraphique() {
    return composantGraphique;
  }

  public void setComposantGraphique(GOval composantGraphique) {
    this.composantGraphique = composantGraphique;
  }
}
