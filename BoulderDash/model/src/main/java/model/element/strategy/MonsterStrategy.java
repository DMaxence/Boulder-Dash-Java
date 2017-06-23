package model.element.strategy;

import contract.controller.IStrategy;
import contract.model.IMap;
import contract.model.element.mobile.IMobile;
import model.element.mobile.Monster;

/**
 * The base strategy for monsters. If crushed, removed from board, and strategy set to noStrategy.
 * @author paul
 *
 */
public abstract class MonsterStrategy implements IStrategy{

	/**
	 * Strategy is to remove from board if crushed
	 */
	@Override
	public void followStrategy(IMobile currentPawn, IMap map) {
		if(currentPawn.isCrushed()) {
			Monster monster = (Monster)(currentPawn);
			monster.removeStrategy();
			monster.removeFromBoard();
		}
	}
}
