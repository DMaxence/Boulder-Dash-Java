package controller;

import java.io.IOException;

import model.IModel;
import view.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IOrderPerformer, IBoulderDashController {

    /** The view. */
    private final IView  view;

    /** The model. */
    private final IModel model;
    
    /** The Constant speed. */
    private static final int     speed = 300;
    
    /** The stack order. */
    private UserOrder            stackOrder;

    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;
    }

    /**
     * Start.
     * @throws InterruptedException 
     */
    @Override
    public void start() throws InterruptedException {
        this.getView().displayMessage(this.getModel().getMap().toString());
        System.exit(0);
        while (this.getModel().getMyCharacter().isAlive()) {
            Thread.sleep(speed);
            switch (this.getStackOrder()) {
                case RIGHT:
                    this.getModel().getMyCharacter().moveRight();
                    break;
                case LEFT:
                    this.getModel().getMyCharacter().moveLeft();
                    break;
                case DOWN:
                	this.getModel().getMyCharacter().moveDown();
                	break;
                case UP:
                	this.getModel().getMyCharacter().moveUp();
                	break;
                case NOP:
                default:
                    this.getModel().getMyCharacter().doNothing();
                    break;
            }
            this.clearStackOrder();

            this.getView().followMyCharacter();
        }
        this.getView().displayMessage("CRASH !!!!!!!!!.");
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    public IView getView() {
        return this.view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }

	@Override
	public IOrderPerformer getOrderPeformer() {
		return this;
	}

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.controller.IIinsaneVehiclesController#orderPerform(fr.exia.
     * insanevehicles.controller.UserOrder)
     */
    @Override
    public final void orderPerform(final UserOrder userOrder) throws IOException {
        this.setStackOrder(userOrder);
    }
    
    private UserOrder getStackOrder()
    {
    	return this.stackOrder;
    }
    
    private void setStackOrder(UserOrder newOrder)
    {
    	this.stackOrder = newOrder;
    }
    
    private void clearStackOrder()
    {
    	this.stackOrder = UserOrder.NOP;
    }
}
