package model.element.strategy;

import contract.model.IMap;
import contract.model.element.mobile.IMobile;

/**
 * A strategy that does nothing. Used when monsters are taken out of the board.
 * 
 * 
 * @author Paul Combaldieu
 * @version 1.0
 *
 */
public class NoStrategy extends MonsterStrategy {

	@Override
	public void followStrategy(IMobile currentPawn, IMap map) {
		// Nop
	}
}
