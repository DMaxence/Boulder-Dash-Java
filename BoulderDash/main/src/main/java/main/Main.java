package main;

import java.io.IOException;
import java.sql.SQLException;

import controller.ControllerFacade;
import controller.IBoulderDashController;
import model.IModel;
import model.ModelFacade;
import view.ViewFacade;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws SQLException 
     * @throws IOException 
     */
    public static void main(final String[] args) throws SQLException, IOException {
    	final IModel model = new ModelFacade(1);
    	final ViewFacade view = new ViewFacade(model.getMap(), model.getMyCharacter());
        final IBoulderDashController controller = new ControllerFacade(view, model);

        try {
            controller.start();
        } catch (InterruptedException e) {
        	System.out.println(e.getMessage());
			e.printStackTrace();
		}
    }
}
