package model;

import java.util.ArrayList;
import java.util.Observable;

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
}
