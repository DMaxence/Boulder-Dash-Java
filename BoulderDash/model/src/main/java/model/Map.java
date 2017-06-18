package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import model.element.mobile.IMobile;

/*
 * @author Paul Combaldieu
 */
public class Map extends Observable implements IMap{
	private int width;
	private int height;
	private IElement[][] map;
	private ArrayList<IMobile> pawns;
	private int diamondCount = 0;
	
	public Map(final int newWidth, final int newHeight, final IElement[][] newMap) throws SQLException
	{
		super();
		this.map = newMap;
		
		this.width = newWidth;
		this.height = newHeight;
        this.pawns = new ArrayList<IMobile>();
	}
	
	public int decreaseDiamondCount()
	{
		this.diamondCount--;
		return this.diamondCount;
	}
	
	public void addDiamondCount()
	{
		this.diamondCount++;
	}
	
	public final String toString()
	{
		String temp = new String();
		for (int y = 0; y < this.getHeight(); y++)
		{
			for (int x = 0; x < this.getWidth(); x++)
			{
				temp += map[x][y].getSprite().getConsoleImage();
			}
			temp += '\n';
		}
		return temp;
	}
	
	@Override
	public int getWidth()
	{
		return this.width;
	}
	
	@Override
	public int getHeight()
	{
		return this.height;
	}
	
	@Override
	public IElement getOnTheMapXY(final int x, final int y)
	{
		return this.map[x][y];
	}
	
	@Override
	public Observable getObservable()
	{
		return this;
	}
	
    @Override
    public final void setMobileHasChanged() {
        this.setChanged();
        this.notifyObservers();
    }

	@Override
	public void setOnTheMapXY(int x, int y, IElement elem) {
		//this.map[x%this.getWidth()][y%this.getHeight()] = elem;
		this.map[x][y] = elem;
	}

	@Override
	public void addPawn(IMobile pawn) {
		this.pawns.add(pawn);
		
	}

	@Override
	public ArrayList<IMobile> getPawns()
	{
		return this.pawns;
	}
}
