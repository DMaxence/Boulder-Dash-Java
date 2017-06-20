package model;

import java.util.ArrayList;
import java.util.Observable;

import model.element.Permeability;
import model.element.mobile.IMobile;

/**
 * The map interface.
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
	
	/** Notifies that the mobile has changed */
	public void setMobileHasChanged();
	
	/** @return The observable */
	public Observable getObservable();
	
	/** Adds a pawn to the current map */
	public void addPawn(final IMobile pawn);
	
	/** @return The pawns on the current map */
	public ArrayList<IMobile> getPawns();
	
	/** Decrements the diamond count */
	public void decreaseDiamondCount();
	
	/** Increments the diamond count */
	public void addDiamondCount();
	
	/**
	 * Get DiamondCount
	 * 
	 * @return DiamondCount, number of diamond in the map.
	 */
	public int getDiamondCount();
	
	/** @return The player's character */
	public IMobile getMyCharacter();
	
	/** Sets the player's character */
	public void setMyCharacter(IMobile character);
	
	/** @return the permeability of the square at the given position */
	public Permeability getSquareIsOccupiedXY(final int x, final int y);
}
