package model.element.strategy;

import controller.FallingObjectsStrategy;
import model.IMap;
import model.element.mobile.IMobile;

public class BoulderStrategy extends FallingObjectsStrategy {

	@Override
	public void followStrategy(IMobile currentPawn, IMap map) {
		super.followStrategy(currentPawn, map);
	}
}
