package controller;

import java.util.Random;

/**
 * <h1>The Enum UserOrder.</h1>
 * 
 * @author Tejesh Tailor
 * @version 0.1
 */
public enum UserOrder {

	/** The right. */
	RIGHT,

	/** The left. */
	LEFT,

	/** The up. */
	UP,

	/** Down there. */
	DOWN,

	/** The nope. */
	NOP;
	
	public static UserOrder randomOrder() {
	    int pick = new Random().nextInt(UserOrder.values().length);
	    return UserOrder.values()[pick];
	}

}
