package model.element.motionlesselement;

import model.element.Permeability;
import model.element.Sprite;

public class Wall extends MotionlessElement{
	
	public static final Sprite sprite = new Sprite('#', "TODO");

	public Wall() {
		super(sprite, Permeability.PENETRABLE);
	}

}
