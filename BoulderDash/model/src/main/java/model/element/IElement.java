package model.element;

import java.awt.Image;

//public interface IElement extends ISquare {
public interface IElement {

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
     * @see fr.exia.showboard.ISquare#getImage()
     */
   /* @Override
    Image getImage();*/

}
