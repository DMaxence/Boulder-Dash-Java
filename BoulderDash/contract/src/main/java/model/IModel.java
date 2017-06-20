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
     * Gets the map by id.
     *
     * @param id
     *            the id
     * @return the map by id
     * @throws SQLException
     *             the SQL exception
     */
    public IMap getMap();
    
    /** @return the player's character */
    public IMobile getMyCharacter();
    
    /** Makes the pawn follow their strategy */
    public void movePawns();
}
