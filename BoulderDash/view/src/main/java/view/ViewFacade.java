package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.IOrderPerformer;
import controller.UserOrder;
import fr.exia.showboard.BoardFrame;
import model.IMap;
import model.element.mobile.IMobile;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IView, Runnable, KeyListener {
	
    /** The Constant squareSize. */
    private static final int squareSize = 50;
	
	private IMap map = null;
	private IMobile myCharacter = null;
	private ArrayList<IMobile> pawns = null;
	private Rectangle closeView = null;
	private IOrderPerformer orderPerformer = null;
	private final BoardFrame boardFrame = new BoardFrame("Boulder Hendeck");

    /**
     * Instantiates a new view facade.
     * @throws IOException 
     */
    public ViewFacade(final IMap map, final IMobile character, final ArrayList<IMobile> pawns) throws IOException {
        super();
        this.setMap(map);
        this.setMyCharacter(character);
        this.setPawns(pawns);
        this.setCloseView(this.getReasonableViewPort());
        
        SwingUtilities.invokeLater(this);
    }
    
    private Rectangle getReasonableViewPort()
    {
    	int reasonableWidth;
    	int reasonableHeight;
    	
    	//First let's find a reasonable width
    	if((int)(map.getWidth() * 0.75) > 10)
    		reasonableWidth = 10;
    	else if((int)(map.getWidth() * 0.75) < 5)
    		reasonableWidth = map.getWidth();
    	else
    		reasonableWidth = (int)(map.getWidth() * 0.75);
    	
    	//Same with the height
    	if((int)(map.getHeight() * 0.75) > 10)
    		reasonableHeight = 10;
    	else if((int)(map.getHeight() * 0.75) < 5)
    		reasonableHeight = map.getHeight();
    	else
    		reasonableHeight = (int)(map.getHeight() * 0.75);
    	
    	return new Rectangle(0, 0, reasonableWidth, reasonableHeight);
    }

    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
    private void setMap(final IMap newMap) throws IOException
    {
    	this.map = newMap;
        for (int x = 0; x < this.getMap().getWidth(); x++) {
            for (int y = 0; y < this.getMap().getHeight(); y++) {
                this.getMap().getOnTheMapXY(x, y).getSprite().loadImage();
            }
        }
    }

    private void setMyCharacter(final IMobile newCharacter)
    {
    	this.myCharacter = newCharacter;
    }
    
    private IMobile getMyCharacter()
    {
    	return this.myCharacter;
    }
    
    private void setCloseView(final Rectangle newView)
    {
    	this.closeView = newView;
    }
    
    /**
     * Key code to user order.
     *
     * @param keyCode
     *            the key code
     * @return the user order
     */
    private static UserOrder keyCodeToUserOrder(final int keyCode) {
        UserOrder userOrder;
        switch (keyCode) {
            case KeyEvent.VK_RIGHT:
                userOrder = UserOrder.RIGHT;
                break;
            case KeyEvent.VK_LEFT:
                userOrder = UserOrder.LEFT;
                break;
            case KeyEvent.VK_UP:
            	userOrder = UserOrder.UP;
            	break;
            case KeyEvent.VK_DOWN:
            	userOrder = UserOrder.DOWN;
            	break;
            default:
                userOrder = UserOrder.NOP;
                break;
        }
        return userOrder;
    }
    
    /*
     * (non-Javadoc)
     * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
     */
    @Override
    public void keyTyped(final KeyEvent keyEvent) {
        // Nop
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
     */
    @Override
    public final void keyPressed(final KeyEvent keyEvent) {
        try {
            this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
        } catch (final IOException exception) {
            exception.printStackTrace();
        }
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
     */
    @Override
    public void keyReleased(final KeyEvent keyEvent) {
        // Nop
    }

	@Override
	public final void run() {
        boardFrame.setDimension(new Dimension(this.getMap().getWidth(), this.getMap().getHeight()));
        boardFrame.setDisplayFrame(this.closeView);
        boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
        //boardFrame.setHeightLooped(true);
        boardFrame.addKeyListener(this);
        boardFrame.setFocusable(true);
        boardFrame.setFocusTraversalKeysEnabled(false);

        for (int x = 0; x < this.getMap().getWidth(); x++) {
            for (int y = 0; y < this.getMap().getHeight(); y++) {
                boardFrame.addSquare(this.map.getOnTheMapXY(x, y), x, y);
            }
        }
        boardFrame.addPawn(this.getMyCharacter());
        for (IMobile pawn : this.pawns)
        {
        	System.out.println(pawn.getSprite().getConsoleImage());
        	System.out.println(pawn.getPosition());
        	System.out.println(pawn.getSprite().isImageLoaded());
        	System.out.println(this.getMyCharacter().getSprite().isImageLoaded());
        	boardFrame.addPawn(pawn);
        }
 
        this.getMap().getObservable().addObserver(boardFrame.getObserver());
        this.followMyCharacter();

        boardFrame.setVisible(true);
		
	}
	
	private IMap getMap()
	{
		return this.map;
	}

	@Override
	public void followMyCharacter() {
		// TODO Auto-generated method stub
		
	}
	
	private IOrderPerformer getOrderPerformer()
	{
		return this.orderPerformer;
	}
	
	public void setOrderPerformer(final IOrderPerformer newPerformer)
	{
		this.orderPerformer = newPerformer;
	}
	
	public void updateBoardFrame()
	{
        for (int x = 0; x < this.getMap().getWidth(); x++) {
            for (int y = 0; y < this.getMap().getHeight(); y++) {
                boardFrame.addSquare(this.map.getOnTheMapXY(x, y), x, y);
            }
        }
	}
	
	private void setPawns(final ArrayList<IMobile> newPawns)
	{
		this.pawns = newPawns;
	}
	
}
