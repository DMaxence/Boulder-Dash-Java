package model;

import java.sql.SQLException;
import java.util.List;

import model.dao.MapDAO;
import model.element.IElement;

import contract.model.IModel;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ModelFacade implements IModel {
	
	private IMap map;

    /**
     * Instantiates a new model facade.
     * @throws SQLException 
     */
    public ModelFacade(final int mapID) throws SQLException {
        super();
        this.setMap(new Map(mapID));
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
}
