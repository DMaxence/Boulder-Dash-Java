package model;

import java.util.ArrayList;
import java.util.Observable;

import model.element.Permeability;
import model.element.mobile.IMobile;

/*
 * @author Paul Combaldieu
 */
public interface IMap {
	public int getWidth();
	public int getHeight();
	public IElement getOnTheMapXY(int x, int y);
	public void setOnTheMapXY(int x, int y, IElement elem);
	public void setMobileHasChanged();
	public Observable getObservable();
	public void addPawn(final IMobile pawn);
	public ArrayList<IMobile> getPawns();
	public void decreaseDiamondCount();
	public void addDiamondCount();
	public int getDiamondCount();
	public IMobile getMyCharacter();
	public void setMyCharacter(IMobile character);
	public Permeability getSquareIsOccupiedXY(final int x, final int y);
}
