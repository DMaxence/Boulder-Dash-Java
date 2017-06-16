package model;

import java.io.IOException;
import java.sql.SQLException;

import model.element.mobile.IMobile;
import model.element.mobile.MyCharacter;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ModelFacade implements IModel {
	
	private IMap map;
	
	private IMobile myCharacter;

    /**
     * Instantiates a new model facade.
     * @throws SQLException 
     * @throws IOException 
     */
    public ModelFacade(final int mapID) throws SQLException, IOException {
        super();
        this.setMap(new Map(mapID));
        this.setMyCharacter(new MyCharacter(1, 1, this.getMap()));
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getExampleById(int)
     */
    @Override
    public IMap getMap(){
        return this.map;
    }
    
    private void setMap(final Map newMap)
    {
    	this.map = newMap;
    }
    
    private void setMyCharacter(IMobile newChara)
    {
    	this.myCharacter = newChara;
    }
}
