package model.element.strategy;

import contract.model.IMap;
import contract.model.element.mobile.IMobile;
/**
 * The strategy used by diamonds. The same as FallingObject strategy, but can be removed when on player's location.
 * @author paul
 *
 */
public class DiamondStrategy extends FallingObjectsStrategy {

	@Override
	public void followStrategy(IMobile currentPawn, IMap map) {
		// if the currentPawn is above the player
		if ((currentPawn.getPosition().y == map.getMyCharacter().getPosition().y - 1
				&& currentPawn.getPosition().x == map.getMyCharacter().getPosition().x)
				|| currentPawn.getPosition().equals(map.getMyCharacter().getPosition())) {
			currentPawn.removeFromBoard();
			map.decreaseDiamondCount();
			return;
		}
		super.followStrategy(currentPawn, map);
	}
}