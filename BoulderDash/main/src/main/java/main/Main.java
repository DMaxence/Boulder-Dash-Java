package main;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.ControllerFacade;
import controller.IBoulderDashController;
import model.IModel;
import model.ModelFacade;
import view.ViewFacade;

/**
 * <h1>The Class Main.</h1>
 * @author Tejesh Tailor
 *
 */
public abstract class Main {

    /**
     * This is the main method.
     *
     * @param args
     *            the arguments
     * @throws SQLException 
     * @throws IOException 
     */
    public static void main(final String[] args) throws SQLException, IOException {
    	
    	String idToAsk= JOptionPane.showInputDialog("Hello ! Please input id of the map : ", 1);
        int idAsked = Integer.parseInt(idToAsk);
        
    	final IModel model = new ModelFacade(idAsked);
    	final ViewFacade view = new ViewFacade(model.getMap(), model.getMyCharacter(), model.getMap().getPawns());
        System.out.println("");
        final IBoulderDashController controller = new ControllerFacade(view, model);
        view.setOrderPerformer(controller.getOrderPeformer());

        try {
            controller.start();
        } catch (InterruptedException e) {
        	System.out.println(e.getMessage());
			e.printStackTrace();
		}
    }
}
