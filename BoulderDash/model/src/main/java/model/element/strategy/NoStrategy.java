package model.element.strategy;

import model.IMap;
import model.element.mobile.IMobile;

public class NoStrategy extends MonsterStrategy {

	@Override
	public void followStrategy(IMobile currentPawn, IMap map) {
		// Nop
	}
}
