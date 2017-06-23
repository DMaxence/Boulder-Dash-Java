package contract.controller;

import contract.model.IMap;
import contract.model.element.mobile.IMobile;

/**
 * The IStrategy interface.
 * @author Paul Combaldieu
 *
 */
public interface IStrategy {
  
  /** 
   * Makes a pawn perform actions on a map 
   * 
   * @param currentPawn 
   * The pawn to perform actions.
   * 
   * @param map
   * The map to use for the pawn.
   */
  public void followStrategy(IMobile currentPawn, IMap map);
}
