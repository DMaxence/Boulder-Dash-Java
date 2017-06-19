package model.element.mobile;

import controller.FallingObjectsStrategy;
import model.IMap;
import model.element.mobile.IMobile;

public class DiamondStrategy extends FallingObjectsStrategy {

	@Override
	public void followStrategy(IMobile currentPawn, IMap map, IMobile myCharacter) {
		// if the currentPawn is above the player
		if ((currentPawn.getPosition().y == myCharacter.getPosition().y - 1
				&& currentPawn.getPosition().x == myCharacter.getPosition().x)
				|| currentPawn.getPosition().equals(myCharacter.getPosition())) {
			currentPawn.removeFromBoard();
			map.decreaseDiamondCount();
			return;
		}
		super.followStrategy(currentPawn, map, myCharacter);
	}
}