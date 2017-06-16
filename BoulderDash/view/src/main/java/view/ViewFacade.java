package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

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
	
	private IMap map;
	private IMobile myCharacter;
	private Rectangle closeView;

    /**
     * Instantiates a new view facade.
     * @throws IOException 
     */
    public ViewFacade(final IMap map, final IMobile character) throws IOException {
        super();
        this.setMap(map);
        this.setMyCharacter(character);
        this.getMyCharacter().getSprite().loadImage();
        this.setCloseView(new Rectangle(0, 0, 2, 2));
        SwingUtilities.invokeLater(this);
    }

    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
    private void setMap(final IMap newMap)
    {
    	this.map = newMap;
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
		final BoardFrame boardFrame = new BoardFrame("Boulder Hendeck");
        boardFrame.setDimension(new Dimension(this.getMap().getWidth(), this.getMap().getHeight()));
        boardFrame.setDisplayFrame(this.closeView);
        boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
        boardFrame.setHeightLooped(true);
        boardFrame.addKeyListener(this);
        boardFrame.setFocusable(true);
        boardFrame.setFocusTraversalKeysEnabled(false);

        for (int x = 0; x < this.getMap().getWidth(); x++) {
            for (int y = 0; y < this.getMap().getHeight(); y++) {
                boardFrame.addSquare(this.map.getOnTheMapXY(x, y), x, y);
            }
        }
        boardFrame.addPawn(this.getMyCharacter());

        this.getMap().getObservable().addObserver(boardFrame.getObserver());
        //this.followMyVehicle();

        boardFrame.setVisible(true);
		
	}
	
	private IMap getMap()
	{
		return this.map;
	}
}
