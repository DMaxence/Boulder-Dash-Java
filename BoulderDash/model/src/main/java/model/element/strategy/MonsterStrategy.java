package model.element.strategy;

import controller.IStrategy;
import model.IMap;
import model.element.mobile.IMobile;
import model.element.mobile.Monster;

public abstract class MonsterStrategy implements IStrategy{

	/**
	 * Strategy is to remove from board if crushed
	 */
	@Override
	public void followStrategy(IMobile currentPawn, IMap map) {
		if(currentPawn.isCrushed()) {
			System.out.println("A monster has been crushed");
			Monster monster = (Monster)(currentPawn);
			monster.removeStrategy();
			monster.removeFromBoard();
		}
	}
}
