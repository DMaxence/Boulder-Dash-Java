package model.element.strategy;

import contract.controller.UserOrder;
import contract.model.IMap;
import contract.model.element.mobile.IMobile;

/**
 * One of the strategy that can be used by monsters.
 * 
 * @author Paul Combadieu
 * @version 1.0
 */
public class FollowWallAntiClockWiseStrategy extends MonsterStrategy {

	@Override
	public void followStrategy(IMobile currentPawn, IMap map) {
		super.followStrategy(currentPawn, map);
		if(currentPawn.getPosition().y < 0)
		{
			return;
		}
		
		if (currentPawn.getLastWallTouched() == UserOrder.NOP) {

			if (currentPawn.canMoveTo(UserOrder.RIGHT)) {

				currentPawn.moveRight();
				if (!currentPawn.canMoveTo(UserOrder.RIGHT)) {
					currentPawn.setLastWallTouched(UserOrder.RIGHT);
				}

			} else if (currentPawn.canMoveTo(UserOrder.UP)) {

				currentPawn.moveUp();
				if (!currentPawn.canMoveTo(UserOrder.UP)) {
					currentPawn.setLastWallTouched(UserOrder.UP);
				}

			} else if (currentPawn.canMoveTo(UserOrder.LEFT)) {

				currentPawn.moveLeft();
				if (!currentPawn.canMoveTo(UserOrder.LEFT)) {
					currentPawn.setLastWallTouched(UserOrder.LEFT);
				}

			} else if (currentPawn.canMoveTo(UserOrder.DOWN)) {

				currentPawn.moveDown();
				if (!currentPawn.canMoveTo(UserOrder.DOWN)) {
					currentPawn.setLastWallTouched(UserOrder.DOWN);
				}
			}
		}
		// a wall has been touched, follow it
		if (currentPawn.getLastWallTouched() == UserOrder.RIGHT) {
			if (currentPawn.canMoveTo(UserOrder.UP)) {
				currentPawn.moveUp();
				if (!currentPawn.canMoveTo(UserOrder.UP)) {
					currentPawn.setLastWallTouched(UserOrder.UP);
				}
			} else if (currentPawn.canMoveTo(UserOrder.LEFT)) {
				currentPawn.moveLeft();
				if (!currentPawn.canMoveTo(UserOrder.LEFT)) {
					currentPawn.setLastWallTouched(UserOrder.LEFT);
				}
			} else if (currentPawn.canMoveTo(UserOrder.DOWN)) {
				currentPawn.moveDown();
				if (!currentPawn.canMoveTo(UserOrder.DOWN)) {
					currentPawn.setLastWallTouched(UserOrder.DOWN);
				}
			}
		} else if (currentPawn.getLastWallTouched() == UserOrder.UP) {
			if (currentPawn.canMoveTo(UserOrder.LEFT)) {
				currentPawn.moveLeft();
				if (!currentPawn.canMoveTo(UserOrder.LEFT)) {
					currentPawn.setLastWallTouched(UserOrder.LEFT);
				}
			} else if (currentPawn.canMoveTo(UserOrder.DOWN)) {
				currentPawn.moveDown();
				if (!currentPawn.canMoveTo(UserOrder.DOWN)) {
					currentPawn.setLastWallTouched(UserOrder.DOWN);
				}
			} else if (currentPawn.canMoveTo(UserOrder.RIGHT)) {
				currentPawn.moveRight();
				if (!currentPawn.canMoveTo(UserOrder.RIGHT)) {
					currentPawn.setLastWallTouched(UserOrder.RIGHT);
				}
			}

		} else if (currentPawn.getLastWallTouched() == UserOrder.LEFT) {
			if (currentPawn.canMoveTo(UserOrder.DOWN)) {
				currentPawn.moveDown();
				if (!currentPawn.canMoveTo(UserOrder.DOWN)) {
					currentPawn.setLastWallTouched(UserOrder.DOWN);
				}
			} else if (currentPawn.canMoveTo(UserOrder.RIGHT)) {
				currentPawn.moveRight();
				if (!currentPawn.canMoveTo(UserOrder.RIGHT)) {
					currentPawn.setLastWallTouched(UserOrder.RIGHT);
				}
			} else if (currentPawn.canMoveTo(UserOrder.UP)) {
				currentPawn.moveUp();
				if (!currentPawn.canMoveTo(UserOrder.UP)) {
					currentPawn.setLastWallTouched(UserOrder.UP);
				}
			}

		} else if (currentPawn.getLastWallTouched() == UserOrder.DOWN) {
			if (currentPawn.canMoveTo(UserOrder.RIGHT)) {
				currentPawn.moveRight();
				if (!currentPawn.canMoveTo(UserOrder.RIGHT)) {
					currentPawn.setLastWallTouched(UserOrder.RIGHT);
				}
			} else if (currentPawn.canMoveTo(UserOrder.UP)) {
				currentPawn.moveUp();
				if (!currentPawn.canMoveTo(UserOrder.UP)) {
					currentPawn.setLastWallTouched(UserOrder.UP);
				}
			} else if (currentPawn.canMoveTo(UserOrder.LEFT)) {
				currentPawn.moveLeft();
				if (!currentPawn.canMoveTo(UserOrder.LEFT)) {
					currentPawn.setLastWallTouched(UserOrder.LEFT);
				}
			}
		}
	}
}
