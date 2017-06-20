package model.element.strategy;

import model.IMap;
import model.element.mobile.IMobile;

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
