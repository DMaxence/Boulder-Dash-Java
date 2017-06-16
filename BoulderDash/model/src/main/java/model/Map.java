package model;

import java.sql.SQLException;
import java.util.Observable;

import model.dao.MapDAO;

/*
 * @author Paul Combaldieu
 */
public class Map extends Observable implements IMap{
	private int width;
	private int height;
	private IElement[][] map;
	
	public Map(final int ID) throws SQLException
	{
		super();
		this.loadMapFromDatabase(ID);
		
		this.width = map.length;
		this.height = map[0].length;
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
	
	private void loadMapFromDatabase(final int ID) throws SQLException
	{
		this.map = MapDAO.getMapById(ID);
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
}
