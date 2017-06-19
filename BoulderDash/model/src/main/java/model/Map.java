package model;

import java.awt.Point;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import model.element.Permeability;
import model.element.mobile.IMobile;

/*
 * @author Paul Combaldieu
 */
public class Map extends Observable implements IMap {
  private int width;
  private int height;
  private IElement[][] map;
  private ArrayList<IMobile> pawns;
  private IMobile myCharacter = null;
  private int diamondCount = 0;

  /**
   * Constructeur par défaut.
   * 
   * @param newWidth
   *          la nouvelle largeur
   * @param newHeight
   *          la nouvelle hauteur
   * @param newMap
   *          la nouvelle map
   * @throws SQLException
   *           l'exception
   */
  public Map(final int newWidth, final int newHeight, final IElement[][] newMap) throws SQLException {
    super();
    this.map = newMap;

    this.width = newWidth;
    this.height = newHeight;
    this.pawns = new ArrayList<IMobile>();
  }

  @Override
  public void setMyCharacter(final IMobile newChara) {
    this.myCharacter = newChara;
  }

  @Override
  public void decreaseDiamondCount() {
    this.diamondCount--;
  }

  @Override
  public void addDiamondCount() {
    this.diamondCount++;
  }

  @Override
  public int getDiamondCount() {
    return this.diamondCount;
  }

  /**
   * Retourne la map en caractères ASCII.
   */
  @Override
  public final String toString() {
    String temp = new String();
    for (int y = 0; y < this.getHeight(); y++) {
      for (int x = 0; x < this.getWidth(); x++) {
        temp += map[x][y].getSprite().getConsoleImage();
      }
      temp += '\n';
    }
    return temp;
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public IElement getOnTheMapXY(final int x, final int y) {
    return this.map[x][y];
  }

  @Override
  public Observable getObservable() {
    return this;
  }

  @Override
  public final void setMobileHasChanged() {
    this.setChanged();
    this.notifyObservers();
  }

  @Override
  public void setOnTheMapXY(int x, int y, IElement elem) {
    this.map[x][y] = elem;
  }

  @Override
  public void addPawn(IMobile pawn) {
    this.pawns.add(pawn);
  }

  @Override
  public IMobile getMyCharacter() {
    return this.myCharacter;
  }

  @Override
  public ArrayList<IMobile> getPawns() {
    return this.pawns;
  }

  /**
   * 
   * @param x
   * @param y
   * @return
   */
  @Override
  public Permeability getSquareIsOccupiedXY(final int x, final int y) {
    Point point = new Point(x, y);
    for(IMobile pawn : this.getPawns()) {
      if (pawn.getPosition().equals(point))
        return pawn.getPermeability();
    }
    return this.getOnTheMapXY(x, y).getPermeability();
  }
}
