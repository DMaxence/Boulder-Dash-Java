package element;

import java.awt.Image;

import contract.model.IElement;
import contract.model.element.Permeability;
import contract.model.element.Sprite;

/**
 * An element is an object that can be used on an IBoard
 * @author Paul Combaldieu
 *
 */
public abstract class Element implements IElement {

	/** The sprite. */
	private Sprite sprite;

	/** The permeability. */
	private Permeability permeability;

	/**
	 * Allows to Instantiates a new element.
	 *
	 * @param sprite
	 *            the sprite
	 * @param permeability
	 *            the permeability
	 */
	public Element(final Sprite sprite, final Permeability permeability) {
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}

	/**
	 * Getter for the sprite.
	 * @see sprite
	 */
	@Override
	public final Sprite getSprite() {
		return this.sprite;
	}

	/**
	 * Sets the sprite.
	 *
	 * @param sprite
	 *            the new sprite
	 */
	protected final void setSprite(final Sprite sprite) {
		this.sprite = sprite;
	}

	/**
	 * Getter for the permeability
	 * @see Permeability
	 */
	@Override
	public final Permeability getPermeability() {
		return this.permeability;
	}

	/**
	 * Sets the permeability.
	 *
	 * @param permeability
	 *            the new permeability
	 */
	private void setPermeability(final Permeability permeability) {
		this.permeability = permeability;
	}

	/**
	 * Getter for the image.
	 * @see java.awt.Image
	 */
	@Override
	public final Image getImage() {
		return this.getSprite().getImage();
	}
}
