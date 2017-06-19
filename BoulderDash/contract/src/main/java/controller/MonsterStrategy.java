package controller;

import model.IMap;
import model.element.mobile.IMobile;

public abstract class MonsterStrategy implements IStrategy{

	@Override
	public void followStrategy(IMobile currentPawn, IMap map) {
		//nop
		
	}

}
