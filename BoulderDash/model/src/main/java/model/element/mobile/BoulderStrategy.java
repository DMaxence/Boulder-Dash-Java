package model.element.mobile;

import controller.FallingObjectsStrategy;
import model.IMap;

public class BoulderStrategy extends FallingObjectsStrategy {

	@Override
	public void followStrategy(IMobile currentPawn, IMap map, IMobile myCharacter) {
		super.followStrategy(currentPawn, map, myCharacter);
	}
}
