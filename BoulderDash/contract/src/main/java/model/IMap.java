package model;

import java.util.Observable;

/*
 * @author Paul Combaldieu
 */
public interface IMap {
	public int getWidth();
	public int getHeight();
	public IElement getOnTheMapXY(int x, int y);
	public void setMobileHasChanged();
	public Observable getObservable();
}
