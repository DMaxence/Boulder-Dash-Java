package contract.model;

import java.awt.Image;

import contract.model.element.Permeability;
import contract.model.element.Sprite;
import fr.exia.showboard.ISquare;

/**
 * The interface that represents elements on the board.
 * @author Paul Combaldieu 
 *
 */
public interface IElement extends ISquare {

    /**
     * Gets the sprite.
     *
     * @return the sprite
     */
    Sprite getSprite();

    /**
     * Gets the permeability.
     *
     * @return the permeability
     */
    Permeability getPermeability();

    /*
     * (non-Javadoc)
     */
    @Override
    Image getImage();

}
