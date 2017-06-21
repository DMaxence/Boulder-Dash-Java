package model;

import model.IMap;
import model.element.mobile.IMobile;

/**
 * <h1>The Interface IModel.</h1>
 * @author Tejesh Tailor
 *
 */
public interface IModel {

    /**
     * Gets the map.
     */
    public IMap getMap();
    
    /** @return the player's character */
    public IMobile getMyCharacter();
    
    /** Makes the pawn follow their strategy */
    public void movePawns();
}
