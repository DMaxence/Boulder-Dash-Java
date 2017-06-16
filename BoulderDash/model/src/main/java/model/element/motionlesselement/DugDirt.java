package model.element.motionlesselement;

import model.element.Permeability;
import model.element.Sprite;

public class DugDirt extends MotionlessElement{
	
	public static final Sprite sprite = new Sprite(' ', "TODO");

	public DugDirt() {
		super(sprite, Permeability.PENETRABLE);
	}

}
