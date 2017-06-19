package controller;

import model.IMap;
import model.element.mobile.IMobile;

public interface IStrategy {
  public void followStrategy(IMobile currentPawn, IMap map, IMobile myCharacter);
}
