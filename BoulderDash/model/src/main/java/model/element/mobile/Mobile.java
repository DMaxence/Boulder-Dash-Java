package model.element.mobile;

import java.awt.Point;
import java.io.IOException;

import controller.UserOrder;
import model.IMap;
import element.Element;
import fr.exia.showboard.IBoard;
import model.element.Permeability;
import model.element.Sprite;
import ElementFactory.ElementFactory;

/**
 * <h1>The Mobile Class.</h1>
 *
 * @author Paul
 * @version 0.3
 */
abstract class Mobile extends Element implements IMobile {

    /**
     * The x.
     */
    private Point   position;

    /** The alive. */
    private Boolean alive = true;

    /** The map. */
    private IMap   map;

    /** The board. */
    private IBoard  board;

    /**
	 * Instantiates a new mobile.
	 *
	 * @param sprite
	 *            the sprite
	 * @param map
	 *            the map
	 * @param permeability
	 *            the permeability
	 */
    Mobile(final Sprite sprite, final IMap map, final Permeability permeability) {
        super(sprite, permeability);
        this.setMap(map);
        this.position = new Point();
    }

    /**
     * Instantiates a new mobile.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param sprite
     *            the sprite
     * @param map
     *            the map
     * @param permeability
     *            the permeability
     */
    Mobile(final int x, final int y, final Sprite sprite, final IMap map, final Permeability permeability) {
        this(sprite, map, permeability);
        //Following code will not work: if (0, y) or (x, 0) is BLOCKING,
        //The game will end instanty. We have to set the initial position without
        //Checking for collisions
        //this.setX(x);
        //this.setY(y);
        
        this.getPosition().x = x;
        this.getPosition().y = (y + this.getMap().getHeight()) % this.getMap().getHeight();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveUp()
     */
    @Override
    public void moveUp() {
        this.setY(this.getY() - 1);
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveLeft()
     */
    @Override
    public void moveLeft() {
        this.setX(this.getX() - 1);
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveDown()
     */
    @Override
    public void moveDown() {
        this.setY(this.getY() + 1);
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveRight()
     */
    @Override
    public void moveRight() {
        this.setX(this.getX() + 1);
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#doNothing()
     */
    @Override
    public void doNothing() {
        this.setHasMoved();
    }

    /**
     * Sets the has moved.
     */
    private void setHasMoved() {
        this.getMap().setMobileHasChanged();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#getX()
     */
    @Override
    public final int getX() {
        return this.getPosition().x;
    }

    /**
     * Sets the x.
     *
     * @param x
     *            the new x
     */
    public final void setX(final int x) { 	
    	this.digDirt();
        this.getPosition().x = x;
        if (this.isCrushed()) {
            this.die();
        }
    }
    
    public void digDirt()
    {
    	this.getMap().setOnTheMapXY(this.getX(), this.getY(), ElementFactory.createDugDirt());
    	try {
			this.getMap().getOnTheMapXY(getX(), getY()).getSprite().loadImage();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#getY()
     */
    @Override
    public final int getY() {
        return this.getPosition().y;
    }

    /**
     * Sets the y.
     *
     * @param y
     *            the new y, as the map is an infinite loop, there's a modulo
     *            based on the map height.
     */
    public final void setY(final int y) {
    	this.digDirt();
        this.getPosition().y = (y + this.getMap().getHeight()) % this.getMap().getHeight();
        if (this.isCrushed()) {
            this.die();
        }
    }

    /**
     * Gets the map.
     *
     * @return the map
     */
    public IMap getMap() {
        return this.map;
    }

    /**
     * Sets the map.
     *
     * @param map
     *            the new map
     */
    private void setMap(final IMap map) {
        this.map = map;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#isAlive()
     */
    @Override
    public Boolean isAlive() {
        return this.alive;
    }

    /**
     * Dies.
     */
    protected void die() {
        this.alive = false;
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#isCrushed()
     */
    @Override
    public Boolean isCrushed() {
        return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
    }
    
    @Override
    public Boolean canMoveTo(final UserOrder direction)
    {
    	switch(direction)
    	{
    	case UP:
    		return this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1).getPermeability() == Permeability.PENETRABLE;
		case DOWN:
			return this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1).getPermeability() == Permeability.PENETRABLE;
    	case RIGHT:
    		return this.getMap().getOnTheMapXY(this.getX() + 1, this.getY()).getPermeability() == Permeability.PENETRABLE;
    	case LEFT:
    		return this.getMap().getOnTheMapXY(this.getX() - 1, this.getY()).getPermeability() == Permeability.PENETRABLE;
    	case NOP:
    	default:
    		return true;
    	}
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.IPawn#getPosition()
     */
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#getPosition()
     */
    @Override
    public Point getPosition() {
        return this.position;
    }

    /**
     * Sets the position.
     *
     * @param position
     *            the position to set
     */
    public void setPosition(final Point position) {
        this.position = position;
    }

    /**
     * Gets the board.
     *
     * @return the board
     */
    protected IBoard getBoard() {
        return this.board;
    }

}
