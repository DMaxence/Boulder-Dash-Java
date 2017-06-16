package model;

import java.sql.SQLException;

import model.IMap;
import model.element.mobile.IMobile;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IModel {

    /**
     * Gets the example by id.
     *
     * @param id
     *            the id
     * @return the example by id
     * @throws SQLException
     *             the SQL exception
     */
    public IMap getMap();
    
    public IMobile getMyCharacter();
}
