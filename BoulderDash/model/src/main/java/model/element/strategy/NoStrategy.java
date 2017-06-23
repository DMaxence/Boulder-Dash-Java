package model.element.strategy;

import contract.model.IMap;
import contract.model.element.mobile.IMobile;

/**
 * A strategy that does nothing. Used when monsters are taken out of the board.
 * @author paul
 *
 */
public class NoStrategy extends MonsterStrategy {

	@Override
	public void followStrategy(IMobile currentPawn, IMap map) {
		// Nop
	}
}
