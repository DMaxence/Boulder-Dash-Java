package model.element.strategy;

import contract.controller.IStrategy;
import contract.controller.UserOrder;
import contract.model.IMap;
import contract.model.element.Permeability;
import contract.model.element.mobile.IMobile;

/**
 * The base strategy for a falling object.
 * 
 * @author paul Combaldieu, Maxence Duhoux
 * @version 1.0
 * 
 *
 */
public abstract class FallingObjectsStrategy implements IStrategy {

	/**
	 * The strategy for falling objects.
	 * @param currentPawn The pawn which will apply the strategy.
	 * @param map The map to move the pawn on
	 */
	@Override
	public void followStrategy(IMobile currentPawn, IMap map) {
		// if current pawn can go down
		if (currentPawn.canMoveTo(UserOrder.DOWN)) {
			currentPawn.moveDown();
		} else {

			// if not, check if he can fall on the sides
			for (IMobile pawnVerif : map.getPawns()) {

				// if there is a pawn under current pawn
				if (currentPawn.getPosition().y == pawnVerif.getPosition().y - 1
						&& currentPawn.getPosition().x == pawnVerif.getPosition().x) {

					// if the current pawn can go to left
					if (currentPawn.canMoveTo(UserOrder.LEFT)) {

						// if the current pawn can go slide to the left to fall
						if (map.getSquareIsOccupiedXY(pawnVerif.getPosition().x - 1,
								pawnVerif.getPosition().y) == Permeability.PENETRABLE) {
							currentPawn.moveLeft();
							return;
						}
					}

					// if the current pawn can go to right
					if (currentPawn.canMoveTo(UserOrder.RIGHT)) {

						// if the current pawn can go slide to the right to fall
						if (map.getSquareIsOccupiedXY(pawnVerif.getPosition().x + 1,
								pawnVerif.getPosition().y) == Permeability.PENETRABLE) {
							currentPawn.moveRight();
							return;
						}
					}
				}
			}
			currentPawn.doNothing();
		}
	}

}
