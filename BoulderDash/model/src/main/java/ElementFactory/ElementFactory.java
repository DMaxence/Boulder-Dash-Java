package ElementFactory;

import model.motionlesselement.DugDirt;
import model.motionlesselement.FilledDirt;
import model.motionlesselement.Wall;

public class ElementFactory {
	  /** The Constant ditchRight. */
    private static final Wall        		 wall          		 = new Wall();

    /** The Constant ditchLeft. */
    private static final DugDirt	         dugDirt             = new DugDirt();

    /** The Constant ditchLeftTurnLeft. */
    private static final FilledDirt   		 filledDirt   		 = new FilledDirt();

    /**
     * The motionless elements is an array of all possible MotionlessElement.
     */
    private static MotionlessElement[]       motionlessElements  = {
        ditchRight,
        ditchLeft,
        ditchLeftTurnLeft,
        ditchLeftTurnRight,
        ditchRightTurnLeft,
        ditchRightTurnRight,
        MACADAM,
        OBSTACLE,
        TREE, };

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDitchRight() {
        return ditchRight;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDitchLeft() {
        return ditchLeft;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDitchLeftTurnLeft() {
        return ditchLeftTurnLeft;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDitchLeftTurnRight() {
        return ditchLeftTurnRight;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDitchRightTurnLeft() {
        return ditchRightTurnLeft;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDitchRightTurnRight() {
        return ditchRightTurnRight;
    }

    /**
     * Creates a new macadam object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createMacadam() {
        return MACADAM;
    }

    /**
     * Creates a new obstacle object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createObstacle() {
        return OBSTACLE;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createTree() {
        return TREE;
    }

    /**
     * Gets the good MotionlessElement from file symbol.
     *
     * @param fileSymbol
     *            the file symbol
     * @return the from file symbol
     */
    public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
        for (final MotionlessElement motionlessElement : motionlessElements) {
            if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
                return motionlessElement;
            }
        }
        return MACADAM;
    }
}
