package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import graphicLayer.GBounded;
import graphicLayer.GOval;
import graphicLayer.GRect;
import graphicLayer.GSpace;

public class VueTerrain {
  
  private final int hauteurTerrain = 700;
  private final int largeurTerrain = 700;
  private GSpace fenetre;
  private GBounded terrain;
  
  public VueTerrain() {
    this.InitialiserVue();
  }
  
  public void InitialiserVue() {
    fenetre = new GSpace("Terrain", new Dimension(550, 550));
    fenetre.open();
  }
  
  public void ajouterTerrain() {
    terrain = new GBounded();
    terrain.setColor(Color.GRAY);
    terrain.setPosition(new Point(30, 30));
    terrain.setDimension(new Dimension(500, 500));
    
    fenetre.addElement(terrain);
  }
  
  public void ajouterFourmiliere() {
    GRect fourmiliere = new GRect();
    fourmiliere.setColor(Color.BLACK);
    fourmiliere.setPosition(new Point(245, 245));
    fourmiliere.setDimension(new Dimension(10, 10));
    this.terrain.addElement(fourmiliere);
  }
  
  public void ajouterFourmi(GOval composantGraphique) {
    this.terrain.addElement(composantGraphique);
    composantGraphique.repaint();
  }
  
  public void supprimerFourmi(GOval composantGraphique) {
    this.terrain.removeElement(composantGraphique);
  }

  public GBounded getTerrain() {
    return terrain;
  }

  public int getHauteurTerrain() {
    return hauteurTerrain;
  }

  public int getLargeurTerrain() {
    return largeurTerrain;
  }
  
  
  
}