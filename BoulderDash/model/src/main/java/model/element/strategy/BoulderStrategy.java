package model.element.strategy;

import contract.model.IMap;
import contract.model.element.mobile.IMobile;

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
