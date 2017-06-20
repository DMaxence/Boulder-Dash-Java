package model.element.strategy;

import controller.FallingObjectsStrategy;
import model.IMap;
import model.element.mobile.IMobile;

/**
 * The strategy followed by boulders. Basically the FallingObject strategy.
 * @author paul
 *
 */
public class BoulderStrategy extends FallingObjectsStrategy {

	@Override
	public void followStrategy(IMobile currentPawn, IMap map) {
		super.followStrategy(currentPawn, map);
	}
}
