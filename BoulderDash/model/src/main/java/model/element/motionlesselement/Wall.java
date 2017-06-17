package model.element.motionlesselement;

import java.awt.Rectangle;

import model.element.Permeability;
import model.element.Sprite;

public class Wall extends MotionlessElement{
	
	public static final Sprite sprite = new Sprite('#', Sprite.mapTileSet, new Rectangle(0, 0, 16, 16));

	public Wall() {
		super(sprite, Permeability.BLOCKING);
	}

}
