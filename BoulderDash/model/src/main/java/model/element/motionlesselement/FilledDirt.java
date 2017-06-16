package model.element.motionlesselement;

import model.element.Permeability;
import model.element.Sprite;

public class FilledDirt extends MotionlessElement{
	
	public static final Sprite sprite = new Sprite('.', "TODO");

	public FilledDirt() {
		super(sprite, Permeability.PENETRABLE);
	}

}
