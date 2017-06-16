package model.element.motionlesselement;

import element.Element;
import model.element.Permeability;
import model.element.Sprite;

public abstract class MotionlessElement extends Element {
	public MotionlessElement(Sprite sprite, Permeability permeability)
	{
		super(sprite, permeability);
	}
}
