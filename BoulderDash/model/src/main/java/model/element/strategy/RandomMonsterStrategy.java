package model.element.strategy;

import controller.UserOrder;
import model.IMap;
import model.element.mobile.IMobile;

/**
 * One of the strategy that can be used by monsters. Moves in random directions, if available.
 * @author paul
 *
 */
public class RandomMonsterStrategy extends MonsterStrategy {
	
	@Override
	public void followStrategy(IMobile currentPawn, IMap map) {
		
		super.followStrategy(currentPawn, map);
		if(currentPawn.getPosition().y < 0) {
			return;
		}
		
		UserOrder orderToFollow = UserOrder.RIGHT;
		int tries = 0;
		while (!currentPawn.canMoveTo(orderToFollow) || tries < 4) {
			orderToFollow = UserOrder.randomOrder();
			tries++;
		}

		if(currentPawn.canMoveTo(orderToFollow)) {
			switch(orderToFollow) {
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
