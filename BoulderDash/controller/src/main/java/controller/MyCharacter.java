package controller;
import java.sql.SQLException;
import java.util.List;
import model.IModel;
import view.IView;

public class MyCharacter implements IController {
	
	/** Constant speed of MyCharacter. */
	public static final int speed = 350;
	
	/** The view. */
	public MyCharacter view;
	
	/** The model. */ 
	public MyCharacter model;
	
	/** The stack order. */
	public UserOrder stackOrder;
	
	/**
	 * Instantiates a new My Character controller.
	 * 
	 * @param view
	 * 				the view
	 * @param model 
	 * 				the model
	 *
	 */
	
	

	

	
	
	
	/**
	 * Gets the view
	 * @return the view
	 * 
	 */
	public MyCharacter getView() {
		return view;
	}
	

	/**
	 * Sets the view.
	 * @param view
	 * 			the view to set
	 */
	public void setView(MyCharacter view) {
		this.view = view;
	}

	
	/**
	 * Gets the model.
	 * @return the model
	 */
	public MyCharacter getModel() {
		return model;
	}

	
	/**
	 * Sets the model.
	 * @param model
	 * 		the model to set
	 */
	public void setModel(MyCharacter model) {
		this.model = model;
	}

	
	/**
	 * Gets the stack order
	 * @return the stack order
	 */
	public UserOrder getStackOrder() {
		return stackOrder;
	}

	
	/** 
	 * Sets the stack order
	 * @param stackOrder
	 * 			the new stack order
	 */
	public void setStackOrder(UserOrder stackOrder) {
		this.stackOrder = stackOrder;
	}
	
	
	public void clearStackOrder() {
		
		
	}
	
	
	
	
	
	
}
