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
    
    /** The FallSpeed */
    private boolean fallSpeed = false;
    
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
        this.map = map;
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
        this.getPosition().y = y;
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
        this.fallSpeed = true;
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
        this.fallSpeed = false;
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
    	return this.mapAllowsMovementTo(direction) && this.pawnsAllowMovementTo(direction);
    }
    
    protected boolean mapAllowsMovementTo(final UserOrder direction)
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
    
    /**
     * This method does NOT test the position of the player.
     * @param direction
     * @return if the pawn can step to the given direction
     */
	protected Boolean pawnsAllowMovementTo(final UserOrder direction) {
		Point desiredPosition = null;
		switch (direction) {
		case UP:
			desiredPosition = new Point(this.getX(), this.getY() - 1);
			break;
		case DOWN:
			desiredPosition = new Point(this.getX(), this.getY() + 1);
			break;
		case RIGHT:
			desiredPosition = new Point(this.getX() + 1, this.getY());
			break;
		case LEFT:
			desiredPosition = new Point(this.getX() - 1, this.getY());
			break;
		case NOP:
		default:
			return true;
		}
		for (IMobile pawn : this.getMap().getPawns()) {
			if (pawn.getPosition().equals(desiredPosition)) {
				if (pawn.getPermeability() != Permeability.PENETRABLE) {
					return false;
				} else {
					return true;
				}
			}
		}
		
		
		return true;
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

	public boolean getFallSpeed() {
		return fallSpeed;
	}
	
	@Override
	public void removeFromBoard() {
	  this.setPosition(new Point(1, -1));
	  this.getMap().getPawns().remove(this);
	}
	
	@Override
	public UserOrder getLastWallTouched() {
		//nop
		return UserOrder.NOP;
	}
	
	@Override
	public void setLastWallTouched(final UserOrder userOrder) {
		//nop
	}
}
