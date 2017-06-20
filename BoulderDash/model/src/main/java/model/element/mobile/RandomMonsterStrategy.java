package controller;

import model.IMap;
import model.element.mobile.IMobile;

public class RandomMonsterStrategy extends MonsterStrategy{
	
	@Override
	public void followStrategy(IMobile currentPawn, IMap map) {
		
		UserOrder orderToFollow = UserOrder.NOP;
		int tries = 0;
		while (!currentPawn.canMoveTo(orderToFollow) || tries > 4) {
			orderToFollow = UserOrder.randomOrder();
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
