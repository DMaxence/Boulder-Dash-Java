package element.elementfactory;

import element.Element;
import model.element.motionlesselement.DugDirt;
import model.element.motionlesselement.FilledDirt;
import model.element.motionlesselement.Wall;

/**
 * Motionless element factory. 
 * @author paul
 * 
 * @version 1.0
 */
public abstract class ElementFactory {
	  /** The Constant wall. */
    private static final Wall        		 wall          		 = new Wall();

    /** The Constant dugDirt. */
    private static final DugDirt	         dugDirt             = new DugDirt();

    /** The Constant filledDirt. */
    private static final FilledDirt   		 filledDirt   		 = new FilledDirt();

    /**
     * The motionless elements is an array of all possible MotionlessElement.
     * used for get from char symbol
     */
    private static Element[]       elements  = {
        dugDirt,
        filledDirt,
        wall
     };

    /**
     * Create a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static Element createDugDirt() {
        return dugDirt;
    }

    /**
     * Create a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static Element createFilledDirt() {
        return filledDirt;
    }

    /**
     * Create a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static Element createWall() {
        return wall;
    }

    /**
     * Gets the good MotionlessElement from file symbol.
     *
     * @param fileSymbol
     *            the file symbol
     * @return the from file symbol
     */
    public static Element getFromFileSymbol(final char fileSymbol) {
        for (final Element motionlessElement : elements) {
            if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
                return motionlessElement;
            }
        }
        return dugDirt;
    }
}
	