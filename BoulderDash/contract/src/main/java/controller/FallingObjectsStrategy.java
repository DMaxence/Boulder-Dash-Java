package controller;

import model.IMap;
import model.element.Permeability;
import model.element.mobile.IMobile;

public abstract class FallingObjectsStrategy implements IStrategy {

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
								pawnVerif.getPosition().y + 1) == Permeability.PENETRABLE) {
							currentPawn.moveLeft();
							return;
						}
					}

					// if the current pawn can go to right
					if (currentPawn.canMoveTo(UserOrder.RIGHT)) {

						// if the current pawn can go slide to the right to fall
						if (map.getSquareIsOccupiedXY(pawnVerif.getPosition().x + 1,
								pawnVerif.getPosition().y + 1) == Permeability.PENETRABLE) {
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
