package model;

import java.util.ArrayList;
import java.util.Observable;

import model.element.Permeability;
import model.element.mobile.IMobile;

/**
 * @author Paul Combaldieu
 */
public interface IMap {
  
  /**
   *  Get Width.
   *  
   * @return the Width of the map
   */
	public int getWidth();
	
	
	/**
	 * Get Height.
	 * 
	 * @return the Height of the map
	 */
	public int getHeight();
	
	
	/**
	 * Gets the x and y.
	 * 
	 * @param x
	 * @param y
	 * @return the x and y 
	 */
	public IElement getOnTheMapXY(int x, int y);
	
	
	/**
     * Sets the x and y.
     *
     * @param x
     * @param y
     *            the new x and y
     */
	public void setOnTheMapXY(int x, int y, IElement elem);
	public void setMobileHasChanged();
	public Observable getObservable();
	public void addPawn(final IMobile pawn);
	public ArrayList<IMobile> getPawns();
	public void decreaseDiamondCount();
	public void addDiamondCount();
	
	/**
	 * Get DiamondCount
	 * 
	 * @return DiamondCount, number of diamond in the map
	 */
	public int getDiamondCount();
	public IMobile getMyCharacter();
	public void setMyCharacter(IMobile character);
	public Permeability getSquareIsOccupiedXY(final int x, final int y);
}
