package model.element.motionlesselement;

import contract.model.element.Permeability;
import contract.model.element.Sprite;
import element.Element;

/**
 * Abstract representation of a motionless element
 * @author paul
 *
 */
public abstract class MotionlessElement extends Element {
	public MotionlessElement(Sprite sprite, Permeability permeability)
	{
		super(sprite, permeability);
	}
}
