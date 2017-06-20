package model;

import java.sql.SQLException;
import model.IMap;
import model.element.mobile.IMobile;

/**
 * <h1>The Interface IModel.</h1>
 * @author Tejesh Tailor
 *
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
    
    public void movePawns();
    
    //public ArrayList<IMobile> getPawns();
}
