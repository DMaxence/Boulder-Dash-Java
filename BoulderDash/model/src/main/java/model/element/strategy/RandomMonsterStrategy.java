package model.element.strategy;

import contract.controller.UserOrder;
import contract.model.IMap;
import contract.model.element.mobile.IMobile;

/**
 * One of the strategy that can be used by monsters. Moves in random directions,
 * if available.
 * 
 * @author Paul Combaldieu
 * @version
 *
 */
public class RandomMonsterStrategy extends MonsterStrategy {

	@Override
	public void followStrategy(IMobile currentPawn, IMap map) {
		super.followStrategy(currentPawn, map);
		if (currentPawn.getPosition().y < 0) {
			return;
		}

		UserOrder orderToFollow = UserOrder.RIGHT;
		int tries = 0;
		while (!currentPawn.canMoveTo(orderToFollow) && tries < 4) {
			orderToFollow = UserOrder.randomOrder();
			tries++;
		}
		
		if(tries == 4)
			return;
		
		this.moveToOrder(orderToFollow, currentPawn);
	}

	private void moveToOrder(final UserOrder orderToFollow, final IMobile currentPawn) {
		if (currentPawn.canMoveTo(orderToFollow)) {
			switch (orderToFollow) {
			case UP:
				currentPawn.moveUp();
				break;
			case DOWN:
				currentPawn.moveDown();
				break;
			case LEFT:
				currentPawn.moveLeft();
				break;
			case RIGHT:
				currentPawn.moveRight();
				break;
			default:
				currentPawn.doNothing();
				break;
			}
		}
	}
}
