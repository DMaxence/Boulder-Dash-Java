package model.element.mobile;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;

import controller.UserOrder;
import model.IMap;
import model.element.Permeability;
import model.element.Sprite;

/**
 * <h1>The MyCharacter Class.</h1>
 *
 * @author Paul
 * @version 0.2
 */
public class MyCharacter extends Mobile {

    /** The Constant SPRITE. */
    private static final Sprite sprite          = new Sprite('H', Sprite.characterTileSet, new Rectangle(16, 0, 16, 16));

    /** The Constant spriteTurnLeft. */
    private static final Sprite spriteTurnLeft  = new Sprite('H', Sprite.characterTileSet, new Rectangle(16, 16, 16, 16));

    /** The Constant spriteTurnRight. */
    private static final Sprite spriteTurnRight = new Sprite('H', Sprite.characterTileSet, new Rectangle(16, 48, 16, 16));

    /** The Constant spriteTurnUp. */
    private static final Sprite spriteTurnUp 	= new Sprite('H', Sprite.characterTileSet, new Rectangle(32, 80, 16, 16));
    
    /** The Constant spriteTurnDown. */
    private static final Sprite spriteTurnDown 	= new Sprite('H', Sprite.characterTileSet, new Rectangle(64, 16, 16, 16));

    /** The Constant spriteExplode. */
    private static final Sprite spriteDie   	= new Sprite('H', Sprite.characterTileSet, new Rectangle(64, 0, 16, 16));

    /**
     * Instantiates a new my vehicle.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param road
     *            the road
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public MyCharacter(final int x, final int y, final IMap map) throws IOException{
        super(x, y, sprite, map, Permeability.BLOCKING);
        spriteTurnLeft.loadImage();
        spriteTurnRight.loadImage();
        spriteTurnUp.loadImage();
        spriteTurnDown.loadImage();
        spriteDie.loadImage();
        sprite.loadImage();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveLeft()
     */
    @Override
    public final void moveLeft() {
        super.digDirt();
        super.moveLeft();
        this.setSprite(spriteTurnLeft);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveRight()
     */
    @Override
    public final void moveRight() {
        super.digDirt();
        super.moveRight();
        this.setSprite(spriteTurnRight);
    }
    
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveRight()
     */
    @Override
    public final void moveUp() {
        super.digDirt();
        super.moveUp();
        this.setSprite(spriteTurnUp);
    }
    
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveRight()
     */
    @Override
    public final void moveDown() {
        super.digDirt();
        super.moveDown();
        this.setSprite(spriteTurnDown);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#die()
     */
    @Override
    protected final void die() {
        super.die();
        this.setSprite(spriteDie);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#doNothing()
     */
    @Override
    public final void doNothing() {
        super.doNothing();
        this.setSprite(sprite);
    }
    
    @Override
    protected boolean mapAllowsMovementTo(final UserOrder direction)
    {
    	//TODO check if bitwise operators available for enums
    	switch(direction)
    	{
    	case UP:
    		return 
    				this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1).getPermeability() == Permeability.PENETRABLE ||
    				this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1).getPermeability() == Permeability.MINEABLE;
		case DOWN:
			return 
					this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1).getPermeability() == Permeability.PENETRABLE ||
					this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1).getPermeability() == Permeability.MINEABLE;
    	case RIGHT:
    		return 
    				this.getMap().getOnTheMapXY(this.getX() + 1, this.getY()).getPermeability() == Permeability.PENETRABLE ||
    				this.getMap().getOnTheMapXY(this.getX() + 1, this.getY()).getPermeability() == Permeability.MINEABLE;
    	case LEFT:
    		return 
    				this.getMap().getOnTheMapXY(this.getX() - 1, this.getY()).getPermeability() == Permeability.PENETRABLE ||
    				this.getMap().getOnTheMapXY(this.getX() - 1, this.getY()).getPermeability() == Permeability.MINEABLE;
    	case NOP:
    	default:
    		return true;
    	}
    }
    
    protected Boolean pawnsAllowMovementTo(final UserOrder direction)
    {
    	Point desiredPosition = null;
    	Boolean pushingAvailable = false;
    	switch(direction)
    	{
    	case UP:
    		desiredPosition = new Point(this.getX(), this.getY() - 1);
    		break;
		case DOWN:
			desiredPosition = new Point(this.getX(), this.getY() + 1);
			break;
    	case RIGHT:
    		desiredPosition = new Point(this.getX() + 1, this.getY());
    		pushingAvailable = this.getMap().getOnTheMapXY(getX() + 2, getY()).getPermeability() == Permeability.PENETRABLE;
    		break;
    	case LEFT:
    		desiredPosition = new Point(this.getX() - 1, this.getY());
    		pushingAvailable = this.getMap().getOnTheMapXY(getX() - 2, getY()).getPermeability() == Permeability.PENETRABLE;
    		break;
    	case NOP:
    	default:
    		return true;
		}

		for (IMobile pawn : this.getMap().getPawns()) {
			if (pawn.getPosition().equals(desiredPosition) && pawn.getPermeability() == Permeability.BLOCKING) {
				if (pushingAvailable) {
					if (direction == UserOrder.RIGHT)
						pawn.moveRight();
					else
						pawn.moveLeft();
					return true;
				}
				else
					return false;

			}
		}
		return true;
    }
    
    @Override
    public Boolean canMoveTo(final UserOrder direction)
    {
    	return this.mapAllowsMovementTo(direction) && this.pawnsAllowMovementTo(direction);
    }
}
