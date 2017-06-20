package model.element.motionlesselement;

import java.awt.Rectangle;

import model.element.Permeability;
import model.element.Sprite;

/**
 * The DugDirt motionless element if a basic PENETRABLE element.
 * @author paul
 *
 */
public class DugDirt extends MotionlessElement{
	
	public static final Sprite sprite = new Sprite(' ', Sprite.mapTileSet, new Rectangle(32, 0, 16, 16));

	public DugDirt() {
		super(sprite, Permeability.PENETRABLE);
	}

}
